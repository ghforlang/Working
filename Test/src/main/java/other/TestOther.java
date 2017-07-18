package other;

import myBatis.po.User;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 10:47
 *  
 */
public class TestOther implements OtherInterface{
    public static void main(String[] args) {

    }

    @Override
    public String getName(User user) {
        return user.getUserName();
    }
}
