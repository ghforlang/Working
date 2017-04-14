package paginator.mapper;

import org.apache.ibatis.session.SqlSession;
import paginator.po.User;
import paginator.util.JDBCUtils;

import java.io.IOException;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-08 13:59
 *  
 */
public class UserService {
    public int addUser(User u){
        SqlSession session = null;
        int result = 0;
        try {
            session = JDBCUtils.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            result = mapper.save(u);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args){
        UserService service = new UserService();

        for(int i=0;i<5;i++){
            User user = new User();
            user.setUserName("张" + i);
            user.setPassword("123456");
            user.setNoteInfo(user.getUserName() + ":" + user.getPassword());
            System.out.println(service.addUser(user));
        }
//        System.out.println(result);
    }
}
