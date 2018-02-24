package other;

import myBatis.po.User;
import org.apache.commons.lang.StringUtils;

import java.util.*;


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
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> treeSet = new TreeSet<>();

        List<String> list = new ArrayList<>();
        System.out.println(StringUtils.join(list,","));;

    }

    @Override
    public String getName(User user) {
        return user.getUserName();
    }
}
