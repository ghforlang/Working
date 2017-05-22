package mybatisonly.service;

import mybatisonly.po.User;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-19 10:30
 *  
 */
public interface UserService {
    public void saveUser(User user);

    public User getUserById(Integer id);

    public List<User> getUsers(List<Integer> ids);

    public void deleteUser(Integer id);
}
