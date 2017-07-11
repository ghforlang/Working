package util;

import myBatis.po.User;

import java.util.*;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 11:04
 *  
 */
public class DataUtils {

    private static List<Integer> integers = null;

    public static List<User> userList(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            Date now = new Date();
            User user = new User();
            user.setId(i);
            user.setCreateTime(now);
            user.setNoteInfo("张三" + i);
            user.setRoleName("张三" + i);
            user.setUserName("张" + i);
            user.setUpdateTime(now);
            users.add(user);
        }
        return users;
    }

    public static List<Integer> getIntegers(){
        if(integers == null){
            integers = new ArrayList<>();
            Random random = new Random();
            for(int i=0;i<100000;i++) {
                integers.add(random.nextInt(100000));
            }
        }else{
            return integers;
        }
        return integers;
    }

    public static List<String> getStrs(){
        String[] arrays = new String[]{"aaa","bbb","ccc"};
        return Arrays.asList(arrays);
    }

    public static List<Integer> getNums(){
       List<Integer> nums = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            nums.add(i+1);
        }
        return nums;
    }
}
