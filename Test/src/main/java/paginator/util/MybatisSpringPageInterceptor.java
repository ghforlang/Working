package paginator.util;

import exception.PageNotSupportException;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import paginator.Page;
import sun.plugin.javascript.ReflectUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-08 16:58
 *  
 */
public class MybatisSpringPageInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisSpringPageInterceptor.class);

    public static final String MYSQL = "mysql";
    public static final String ORACLE = "oracle";

    protected  String databaseType;//数据库类型

    protected  ThreadLocal<Page> pageThreadLocal = new ThreadLocal<Page>();

    public String getDatabaseType(){
        return databaseType;
    }

    public void setDatabaseType(String databaseType){
        if(!MYSQL.equals(databaseType) && !ORACLE.equals(databaseType)){
            throw new PageNotSupportException("Page not support for the type of database, database type [\" + databaseType + \"]\"");
        }
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if(invocation.getTarget() instanceof StatementHandler){
            Page page = pageThreadLocal.get();
            if(page == null){//非分页查询
                return invocation.proceed();
            }


            RoutingStatementHandler handler = (RoutingStatementHandler)invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler,"delegate");
            BoundSql boundSql = delegate.getBoundSql();
            Connection connection = (Connection)invocation.getArgs()[0];
            prepareAndCheckDatabaseType(connection);

            if(page.getTotalPage() > -1){
                if(LOGGER.isTraceEnabled()){
                    LOGGER.trace("已设置总页数，不需要再查询");
                }
            }else{
                Object parameterObj = boundSql.getParameterObject();
                MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
                queryTotal(page,parameterObj,mappedStatement,connection);
            }

            String sql = boundSql.getSql();
            String pageSql = buildPageSql(page,sql);
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("分页时, 生成分页pageSql: " + pageSql);
            }
            ReflectUtil.setFieldValue(boundSql,"sql",pageSql);
            return invocation.proceed();
        }else{
            Page<?> page = findPageObject(invocation.getArgs()[1]);
            if(page == null){
                if (LOGGER.isTraceEnabled()) {
                    LOGGER.trace("没有Page对象作为参数, 不是分页查询.");
                }
                return invocation.proceed();
            }else{
                if (LOGGER.isTraceEnabled()) {
                    LOGGER.trace("检测到分页Page对象, 使用分页查询.");
                }
            }

            //设置真正的parameterObj
            invocation.getArgs()[1] = extractRealParameterObjcet(invocation.getArgs()[1]);

            pageThreadLocal.set(page);

            Object resultObj = invocation.proceed();
            if(resultObj instanceof List){
                page.setResult((List)resultObj);
            }
            return resultObj;
        }
    }

    /**
     * <pre>
     * 把真正的参数对象解析出来
     * Spring会自动封装对个参数对象为Map<String, Object>对象
     * 对于通过@Param指定key值参数我们不做处理，因为XML文件需要该KEY值
     * 而对于没有@Param指定时，Spring会使用0,1作为主键
     * 对于没有@Param指定名称的参数,一般XML文件会直接对真正的参数对象解析，
     * 此时解析出真正的参数作为根对象
     * </pre>
     * @param parameterObj
     * @return
     */
    protected Object extractRealParameterObjcet(Object parameterObj){
        if(parameterObj instanceof Map<?,?>){
            Map<?,?> parameterMap = (Map<?,?>)parameterObj;
            if(parameterMap.size() == 2){
                boolean springMapWithNoParamName = true;
                for(Object key : parameterMap.keySet()){
                    if(! (key instanceof String)){
                        springMapWithNoParamName = false;
                        break;
                    }
                    String keyStr = (String)key;
                    if( !"0".equals(keyStr) && !"1".equals(keyStr)){
                        springMapWithNoParamName = false;
                        break;
                    }
                }
                if(springMapWithNoParamName){
                    for(Object value : parameterMap.values()){
                        if(!(value instanceof  Page<?>)){
                            return value;
                        }
                    }
                }
            }
        }
        return parameterObj;
    }

    protected Page<?> findPageObject(Object parameterObj){
        if (parameterObj instanceof Page<?>) {
            return (Page<?>)parameterObj;
        }else if(parameterObj instanceof Map){
            for(Object val : ((Map<?,?>)parameterObj).values()){
                if(val instanceof  Page<?>){
                    return (Page<?>)val;
                }
            }
        }
        return null;
    }

    protected  String buildPageSql(Page<?> page,String sql){
        if (MYSQL.equalsIgnoreCase(databaseType)) {
            return buildMysqlPageSql(page,sql);
        } else if (ORACLE.equalsIgnoreCase(databaseType)) {
            return buildOraclePageSql(page,sql);
        }
        return sql;
    }

    protected String buildMysqlPageSql(Page<?> page,String sql){
        int offset = (page.getPageNo() -1) * page.getPageSize();
        return new StringBuilder(sql).append(" limit ").append(offset).append(",").append(page.getPageSize()).toString();
    }

    protected String buildOraclePageSql(Page<?> page,String sql){
        int offset = (page.getPageNo() -1) * page.getPageSize();
        StringBuilder sb = new StringBuilder(sql);
        sb.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getPageSize());
        sb.insert(0, "select * from (").append(") where r >= ").append(offset);
        return sb.toString();
    }

    protected void queryTotal(Page<?> page,Object parameterObj,MappedStatement mappedStatement,Connection connection){
        BoundSql boundSql = mappedStatement.getBoundSql(page);
        String sql = boundSql.getSql();
        String countSql = this.buildCountSql(sql);
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("分页时，生成countSql:" + countSql);
        }

        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(),countSql,parameterMappingList,parameterObj);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement,parameterObj,countBoundSql);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt =connection.prepareStatement(countSql);
           parameterHandler.setParameters(pstmt);
           rs = pstmt.executeQuery();{
               if(rs.next()){
                   long total = rs.getLong(1);
                   page.setTotal(total);
               }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    if(LOGGER.isWarnEnabled()){
                        LOGGER.warn("关闭ResultSet时异常",e);
                    }
                    e.printStackTrace();
                }
            }
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    if(LOGGER.isWarnEnabled()){
                        LOGGER.warn("关闭PreparedStatement时异常",e);
                    }
                    e.printStackTrace();
                }
            }
        }
    }

    protected String buildCountSql(String sql){
        int index = sql.indexOf("from");
        return "select count(*) " + sql.substring(index);
    }

    protected void prepareAndCheckDatabaseType(Connection connection) throws SQLException {
        if(databaseType != null){
            String productName = connection.getMetaData().getDatabaseProductName();
            if(LOGGER.isTraceEnabled()){
                LOGGER.trace("Database productName :" + productName);
            }
            productName = productName.toLowerCase();
            if(productName.indexOf(MYSQL) != -1){
                databaseType = MYSQL;
            }else if(productName.indexOf(ORACLE) != -1){
                databaseType = ORACLE;
            }else{
                throw new PageNotSupportException("Page not support for the type of database, database type [\" + databaseType + \"]\"");
            }
            if(LOGGER.isInfoEnabled()){
                LOGGER.info("自动检测到的数据库为" + databaseType);
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dataBaseType = properties.getProperty("dataBaseType");
        if(dataBaseType != null){
            setDatabaseType(dataBaseType);
        }
    }

    private static class ReflectUtil{
        public static Object getFieldValue(Object obj,String fieldName){
            Object result = null;
            Field field = getField(obj,fieldName);
            if(field != null){
                field.setAccessible(true);
                try {
                    result = field.get(obj);
                } catch(IllegalArgumentException ex){
                    ex.printStackTrace();
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        public static void setFieldValue(Object obj,String fieldName,String fieldValue){
            Field field = getField(obj,fieldName);
            if(field != null){
                field.setAccessible(true);
                try {
                    field.set(obj,fieldValue);
                } catch(IllegalArgumentException ex){
                    ex.printStackTrace();
                } catch(IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        private static Field getField(Object obj,String fieldName){
            Field field = null;
            for(Class<?> clazz = obj.getClass();clazz != Object.class ; clazz = clazz.getSuperclass()){
                try {
                    field = clazz.getDeclaredField(fieldName);
                    break;
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    // 这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
                }
            }
            return field;
        }
    }
}
