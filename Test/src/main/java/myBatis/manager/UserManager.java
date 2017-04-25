package myBatis.manager;

import myBatis.dao.UserMapper;
import myBatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import util.JDBCUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-20 15:33
 *  
 */
public class UserManager {

    private static final String RESOURCE = "config.xml";

    public static SqlSession getSession() throws IOException {
        return JDBCUtils.getSession(RESOURCE);
    }

    public int save(User user){
        int result = -1;
        try {
            SqlSession session = getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            result =  userMapper.save(user);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public User getById(Long id){
        SqlSession session = null;
        User user = null;
        try {
            session = getSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            user =  userMapper.findUserById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
