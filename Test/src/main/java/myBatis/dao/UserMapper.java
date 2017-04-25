package myBatis.dao;

import myBatis.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-20 15:27
 *  
 */
public interface UserMapper {
    public int save(User user);

    public User findUserById (Long userId);

    public List<User> findAllUsers();
}
