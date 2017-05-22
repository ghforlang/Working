package mybatisonly.service;

import mybatisonly.po.User;
import mybatisonly.service.impl.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-19 11:28
 *  
 */
public class TestUserService {

    private UserService userService = new UserServiceImpl();


    @Test
    public void testUserSave(){

        List<User> userList = new ArrayList<User>();
        for(int i=0;i<10;i++){
            User user = new User();
            user.setIsDeleted(0);
            user.setUserName("张三" + i);
            user.setPassword("123");
            user.setNoteInfo("我是张三" +i);
            userList.add(user);
        }

        for(User user : userList){
            userService.saveUser(user);
        }
    }

    public void testUserGetById(){
        int id = 81;
        User user = userService.getUserById(id);
        Field[] fields = User.class.getFields();
//        Method[] methods = User.class.getMethods();
//
//        Map<Field,Method> map = new HashMap<Field,Method>();

        for(Field field : fields){
            System.out.println(field.getName());
        }
    }



}
