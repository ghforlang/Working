package mybatisonly.service.impl;

import mybatisonly.manager.UserManager;
import mybatisonly.po.User;
import mybatisonly.service.UserService;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-19 10:30
 *  
 */
public class UserServiceImpl implements UserService {

    private UserManager userManager = new UserManager();


    public void saveUser(User user) {
        userManager.save(user);
    }

    public User getUserById(Integer id) {
       return userManager.getById(id);
    }

    public List<User> getUsers(List<Integer> ids) {
        return userManager.getList(ids);
    }

    public void deleteUser(Integer id) {
        userManager.deleteById(id);
    }
}
