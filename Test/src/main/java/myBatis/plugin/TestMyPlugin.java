package myBatis.plugin;


import myBatis.dao.UserMapper;
import myBatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import util.JsonUtils;
import util.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-04 16:21
 *  
 */
public class TestMyPlugin {
    private static final Logger LOGGER = Logger.getLogger(TestMyPlugin.class);
    public static void main(String[] args) {
        testGetUser();
//        testInherit();
//        testAtParam();
//        testMap();
//        testPojoProperty();
//        testPoJoProperty2();
    }

    public static void testGetUser(){
        LOGGER.info("#################测试没有分页参数的查询###########################");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            LOGGER.info(sqlSession.getClass().toGenericString());
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findUserById(72L);
            LOGGER.info(JsonUtils.toJSon(user));
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    /**
     * 继承PageParams的参数传递.
     */
    public static void testInherit() {
        LOGGER.info("#################测试分页参数以继承PageParams形式传递###########################");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            TestPageParams1 params = new TestPageParams1();
            params.setUseFlag(true);
            params.setCheckFlag(false);
            params.setPage(2);
            params.setPageSize(5);
            params.setRoleName("张三");
            userMapper.selectAllUser(params);
            LOGGER.info("总条数==>" + params.getTotal());
            LOGGER.info("总页数 ==>" + params.getTotalPage());
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 使用map方式。（map的键随意取）
     */
    public static void testMap() {
        LOGGER.info("#################测试分页参数以Map形式传递###########################");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> paramMap = new HashMap<String, Object>();
            PageParams pageParams = new PageParams();
            pageParams.setUseFlag(true);
            pageParams.setCheckFlag(false);
            pageParams.setPage(2);
            pageParams.setPageSize(5);
            paramMap.put("roleName", "张三");
            paramMap.put("page", pageParams);
            userMapper.selectUserByMap(paramMap);
            LOGGER.info("总条数==>" + pageParams.getTotal());
            LOGGER.info("总页数 ==>" + pageParams.getTotalPage());
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 使用MyBatis  @Param注解 传递参数.
     */
    public static void testAtParam() {
        LOGGER.info("#################测试分页参数以@Param形式传递###########################");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            PageParams pageParams2 = new PageParams();
            pageParams2.setUseFlag(true);
            pageParams2.setCheckFlag(true);
            pageParams2.setPage(2);
            pageParams2.setPageSize(5);
            pageParams2.setCleanOrderBy(true);
            List<User> userList = userMapper.selectUserByMap2("张三", pageParams2);
            LOGGER.info(JsonUtils.toJSon(userList));
            LOGGER.info("总条数==>" + pageParams2.getTotal());
            LOGGER.info("总页数 ==>" + pageParams2.getTotalPage());
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 使用POJO传递，但是POJO内部有一个PageParams属性，和它的setter方法.
     */
    public static void testPojoProperty() {
        LOGGER.info("#################测试分页参数作为参数属性传递###########################");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            UserMapper roleMapper = sqlSession.getMapper(UserMapper.class);
            PageParams pageParams3 = new PageParams();
            pageParams3.setUseFlag(true);
            pageParams3.setCheckFlag(false);
            pageParams3.setPage(3);
            pageParams3.setPageSize(5);
            pageParams3.setCleanOrderBy(true);
            TestPageParams2 p2 = new TestPageParams2();
            p2.setPageParams(pageParams3);
            p2.setRoleName("张三");
            roleMapper.selectAllUser2(p2);
            LOGGER.info("总条数==>" + pageParams3.getTotal());
            LOGGER.info("总页数 ==>" + pageParams3.getTotalPage());
        } finally {
            sqlSession.close();
        }
    }

    public static void testPoJoProperty2(){
        LOGGER.info("#################测试分页参数作为参数属性传递2###########################");
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            UserMapper roleMapper = sqlSession.getMapper(UserMapper.class);
            PageParams pageParams3 = new PageParams();
            pageParams3.setUseFlag(true);
            pageParams3.setCheckFlag(true);
            pageParams3.setPage(10);
            pageParams3.setPageSize(5);
            pageParams3.setCleanOrderBy(false);
            TestPageParams2 p2 = new TestPageParams2();
            p2.setPageParams(pageParams3);
            p2.setRoleName("张三");
            roleMapper.selectAllUser2(p2);
            LOGGER.info("总条数==>" + pageParams3.getTotal());
            LOGGER.info("总页数 ==>" + pageParams3.getTotalPage());
        } finally {
            sqlSession.close();
        }
    }
}
