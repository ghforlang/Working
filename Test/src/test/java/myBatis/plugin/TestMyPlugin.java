package myBatis.plugin;

import myBatis.dao.UserMapper;
import myBatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import util.JsonUtils;
import util.MyBatisUtils;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 11:04
 *  
 */
public class TestMyPlugin {
    Logger LOGGER = Logger.getLogger(TestMyPlugin.class);

    @Test
    public void testGetUser(){
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
}
