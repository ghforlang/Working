package mybatisonly.dao;

import mybatisonly.po.User;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-19 14:17
 *  
 */
public interface UserMapper {
    public void save(User user);

    public User selectOne(Integer id);

    public List<User> getUserList(List<Integer> ids);

    public void deleteById(Integer id);
}
