package myBatis.plugin;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-04 10:39
 *  
 */
@Intercepts({
     @Signature(type = StatementHandler.class,
             method= "prepare",
             args={Connection.class}
     )
})
public class MyPlugin implements Interceptor{

    //插件默认参数,可配置
    private Integer defaultPageNo;//默认页码
    private Integer defaultPageSize;//默认页大小
    private Boolean defaultUseFlag;//默认使用插件
    private Boolean defaultCheckFlag ;//默认是否检测页码参数
    private Boolean defaultClearOrderBy;//默认是否清除最后一个orderBy

    private static final String DB_TYPE_MYSQL = "mysql";
    private static final String DB_TYPE_ORACLE = "oracle";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler stmentHandler =  (StatementHandler) getUnProxyObject(invocation.getTarget());

        MetaObject metaStatementHandler = SystemMetaObject.forObject(stmentHandler);
        String sql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");

        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        String dbType = this.getDataSourceType(mappedStatement);

        //不是select语句
        if(checkIsSelect(sql)){
            invocation.proceed();
        }

        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object paramObject = boundSql.getParameterObject();
        PageParams pageParams = getPageParamsForParamObj(paramObject);
        if(null == pageParams){
           return invocation.proceed();
        }

        Boolean useFlag = pageParams.getUseFlag() == null ? defaultUseFlag : pageParams.getUseFlag();
        if(!useFlag){
           return invocation.proceed();
        }
        Integer pageNo = pageParams.getPage() == null ? defaultPageNo : pageParams.getPage();
        Integer pageSize = pageParams.getPageSize() == null ? defaultPageSize : pageParams.getPageSize();
        Boolean checkFlag = pageParams.getCheckFlag() == null ? defaultCheckFlag : pageParams.getCheckFlag();
        Boolean checkClearOrderBy = pageParams.getCleanOrderBy()==null ? defaultClearOrderBy : pageParams.getCleanOrderBy();

        //分页总条数
        int total = getTotal(invocation,metaStatementHandler,boundSql,checkClearOrderBy,DB_TYPE_MYSQL);
        pageParams.setTotal(total);

        int totalPage = (total % pageSize == 0) ? (total / pageSize) : (total/pageSize + 1);
        pageParams.setTotalPage(totalPage);

        this.checkPage(checkFlag,pageNo,totalPage);
        return this.preparedSQL(invocation,metaStatementHandler,boundSql,pageNo,pageSize,dbType);
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties props) {
        String strDefaultPage = props.getProperty("default.page", "1");
        String strDefaultPageSize = props.getProperty("default.pageSize", "50");
        String strDefaultUseFlag = props.getProperty("default.useFlag", "false");
        String strDefaultCheckFlag = props.getProperty("default.checkFlag", "false");
        String StringDefaultCleanOrderBy = props.getProperty("default.cleanOrderBy", "false");

        this.defaultPageNo = Integer.parseInt(strDefaultPage);
        this.defaultPageSize = Integer.parseInt(strDefaultPageSize);
        this.defaultUseFlag = Boolean.parseBoolean(strDefaultUseFlag);
        this.defaultCheckFlag = Boolean.parseBoolean(strDefaultCheckFlag);
        this.defaultClearOrderBy = Boolean.parseBoolean(StringDefaultCleanOrderBy);
    }

    //从代理对象中分离出真实对象
    private Object getUnProxyObject(Object target){
        MetaObject metaStatementHandler = SystemMetaObject.forObject(target);
        //分离代理对象链（由于目标类可能被多个拦截器拦击，从而形成多次代理，通过循环可以分离出最原始的代理类）
        Object obj = null;
        while(metaStatementHandler.hasGetter("h")){
            obj = metaStatementHandler.getValue("h");
        }
        if(obj == null){
            return target;
        }
        return obj;
    }

    private String getDataSourceType(MappedStatement mappedStatement) throws SQLException {
        Connection connection = null;
        String connectStr = null;
        try{
            connection = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
            connectStr = connection == null ? null : connection.toString();
        }finally {
            if(connection != null){
                connection.close();
            }
        }

        if (connectStr == null || connectStr.trim() == "") {
            throw new IllegalArgumentException("当前插件未获取连接信息");
        }
        connectStr = connectStr.toLowerCase();
        if (connectStr.contains(DB_TYPE_MYSQL)) {
            return DB_TYPE_MYSQL;
        }else if(connectStr.contains(DB_TYPE_ORACLE)){
            return DB_TYPE_ORACLE;
        }else{
            throw new IllegalArgumentException("当前插件不支持该数据库");
        }
    }

    private boolean checkIsSelect(String sql){
        sql = sql.trim();
        int index = sql.toLowerCase().indexOf("select");
        return index == 0;
    }

    private PageParams getPageParamsForParamObj(Object paramObject) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        PageParams pageParms = null;
        if(paramObject == null){
            return null;
        }

        //处理map参数和@Param注解参数，都是MAP
        if(paramObject instanceof Map){
            @SuppressWarnings("unchecked")
            Map<String,Object> paramMap = (Map<String,Object>)paramObject;
            Set<String> keySet = paramMap.keySet();
            Iterator<String> keyIterator = keySet.iterator();
            while(keyIterator.hasNext()){
                String key = keyIterator.next();
                Object value = paramMap.get(key);
                if(value instanceof PageParams){
                    return (PageParams)value;
                }
            }
        }else if(paramObject instanceof PageParams){
            return (PageParams)paramObject;
        }else{//从POJO尝试读取分页参数
            Field[] fields = paramObject.getClass().getDeclaredFields();
            //尝试从POJO中获得类型为PageParams的属性
            for (Field field: fields) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(),paramObject.getClass());
                Method method = pd.getReadMethod();
                return (PageParams)method.invoke(paramObject);
            }
        }
        return pageParms;
    }

    private Integer getTotal(Invocation ivt, MetaObject metaStatementHandler, BoundSql boundSql, Boolean cleanOrderBy, String dbType) throws SQLException {
        MappedStatement mapStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        Configuration config = mapStatement.getConfiguration();
//        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        String sql = boundSql.getSql();
        if(cleanOrderBy){
           sql = this.cleanOrderBy(sql);
        }
        String countSql = this.getCountSql(sql,dbType);
        //获取拦截方法参数，根据插件签名，知道是Connection对象.
        Connection connection = (Connection) ivt.getArgs()[0];
        PreparedStatement preparedStatement = null;
        int total = 0;

        try {
            preparedStatement = connection.prepareStatement(countSql);
            BoundSql countBoundSql = new BoundSql(config,countSql,boundSql.getParameterMappings(),boundSql.getParameterObject());
            ParameterHandler countSqlHandler = new DefaultParameterHandler(mapStatement,boundSql.getParameterObject(),countBoundSql);
            countSqlHandler.setParameters(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                total = rs.getInt("total");
            }
        }finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
        return total;
    }

    private String getCountSql(String sql, String dbType) {
        if (DB_TYPE_ORACLE.equals(dbType)) {
            return "select count(*) from (" + sql + ")";
        }else if(DB_TYPE_MYSQL.equals(dbType)){
            return "select count(*) from (" + sql + ") $_paging";
        }else{
            throw new IllegalArgumentException("插件不支持当前操作");
        }
    }

    private String cleanOrderBy(String sql){
        StringBuilder sb = new StringBuilder(sql);
        String newSql = sql.toLowerCase();
        if(newSql.indexOf("order") == -1){
          return sql;
        }
        int index = newSql.lastIndexOf("order");
        return sb.substring(0,index).toString();
    }

    private void checkPage(Boolean checkFlag,Integer pageNo,Integer totalPage){
        if(checkFlag){
            if(pageNo > totalPage){
                throw new IllegalArgumentException("页码数大于总页数");
            }
        }
    }

    private Object preparedSQL(Invocation invocation,MetaObject metaStatementHandler,BoundSql boundSql,Integer pageNo,Integer pageSize,String dbType) throws InvocationTargetException, IllegalAccessException {
        //获取当前要执行的sql
        String sql = boundSql.getSql();
        //生成需要分页的sql
        String newSql = this.getPageDataSql(sql,dbType);
        //更新sql值
        metaStatementHandler.setValue("delegate.boundSql.sql",newSql);
        //这里相当于StatementHandler执行了prepared()方法，这个时候，就剩下2个分页参数没有设置
        Object statement = invocation.proceed();
        //设置两个分页参数
        try {
            this.preparePageDataParams((PreparedStatement) statement,pageNo,pageSize,dbType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    private void preparePageDataParams(PreparedStatement ps,int pageNum,int pageSize,String dbType) throws SQLException {
        //prepared()方法编译SQL，由于MyBatis上下文没有我们分页参数的信息，所以这里需要设置这两个参数.
        //获取需要设置的参数个数，由于我们的参数是最后的两个，所以很容易得到其位置
        int idx = ps.getParameterMetaData().getParameterCount();
        if (DB_TYPE_MYSQL.equals(dbType)) {
            //最后两个是我们的分页参数.
            ps.setInt(idx -1, (pageNum - 1) * pageSize);//开始行
            ps.setInt(idx, pageSize); //限制条数
        } else if (DB_TYPE_ORACLE.equals(dbType)) {
            ps.setInt(idx -1, pageNum * pageSize);//结束行
            ps.setInt(idx, (pageNum - 1) * pageSize); //开始行
        } else {
            throw new IllegalArgumentException("当前插件未支持此类型数据库");
        }
    }

    private String getPageDataSql(String currSql, String dbType) {
        if (DB_TYPE_MYSQL.equals(dbType)) {
            return "select * from (" + currSql + ") $_paging_table limit ?, ?";
        } else if (DB_TYPE_ORACLE.equals(dbType)) {
            return " select * from (select cur_sql_result.*, rownum rn from (" + currSql + ") cur_sql_result  where rownum <= ?) where rn > ?";
        } else {
            throw new IllegalArgumentException("当前插件未支持此类型数据库");
        }
    }


}
