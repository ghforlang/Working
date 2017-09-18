package other;

import myBatis.po.User;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 10:47
 *  
 */
public class TestOther implements OtherInterface {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
    }

    @Override
    public String getName(User user) {
        return user.getUserName();
    }
}
