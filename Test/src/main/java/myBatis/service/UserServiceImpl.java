package myBatis.service;

import myBatis.manager.UserManager;
import myBatis.po.User;

import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-20 15:45
 *  
 */
public class UserServiceImpl implements UserService {
    private static UserManager userManager = new UserManager();

    public static void main(String[] args){
        long id = insert();
        User user = getById(id);
        if(user == null){
            System.out.println(user == null);
        }else{
            System.out.println("创建时间：" + user.getCreateTime());
        }
    }

    private static User createUser(){
        User user = new User();
        user.setNoteInfo("我是张三，我喂自己带盐");
        user.setPassword("123456");
        user.setUserName("zhangsan");
        return user;
    }

    public static long insert(){
        User user = createUser();
        int result = userManager.save(user);
        System.out.println(user.getId() + ":创建成功!" + "***" + result );
        return user.getId();
    }

    public static User getById(Long id){
        User u = (User) userManager.getById(id);
        if(u == null){
            System.out.println("对象为空");
        }else{
            System.out.println("u.getId:" + u.getId());
            System.out.println("u.getName:" + u.getUserName());
            System.out.println("u.getPassword:" + u.getPassword());
            System.out.println("u.getNoteInfo:" + u.getNoteInfo());
            System.out.println("u.getCreateTime:" + u.getCreateTime());
            System.out.println("u.getUpdateTime:" + u.getUpdateTime());
        }
        return u;
    }

}
