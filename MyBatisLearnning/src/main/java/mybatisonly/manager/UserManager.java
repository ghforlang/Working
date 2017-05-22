package mybatisonly.manager;

import Utils.MybatisUtil;
import mybatisonly.dao.UserMapper;
import mybatisonly.po.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-19 10:29
 *  
 */
public class UserManager {
    private static final SqlSession session = MybatisUtil.openSession();

    public void save(User user){
       UserMapper userMapper = session.getMapper(UserMapper.class);
       userMapper.save(user);
       session.commit();
    }

    public User getById(Integer id){
        return null;
    }

    public List<User> getList(List<Integer> list){
        return null;
    }

    public void deleteById(Integer id){

    }
}
