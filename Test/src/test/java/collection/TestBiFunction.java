package collection;

import myBatis.po.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import util.DataUtils;
import util.JsonUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:49
 *  
 */
public class TestBiFunction {
    Logger LOGGER = Logger.getLogger(TestBiFunction.class);

    @Test
    public void testBiFunction(){
        BiFunction<String,List<User>,List<User>> byName = (name, userList)->{
            return userList.stream().
                    filter(a -> a.getUserName().contains(name)).
                    collect(Collectors.toList());
        };
        List<User> users1 = byName.apply("张", DataUtils.userList());
        users1.forEach(user -> {
            LOGGER.info(JsonUtils.toJSon(user));
        });


        BiFunction<String,List<User>,List<User>> byRoleName = (roleName,userList) ->{
            return userList.stream().
                    filter( a -> a.getRoleName().contains(roleName)).
                    collect(Collectors.toList());
        };
        users1 = byRoleName.apply("李",DataUtils.userList());
        users1.forEach(user -> {
            LOGGER.info(JsonUtils.toJSon(user));
        });


        Function<List<User>,List<User>> sortUser = (userList) ->{
            return userList.stream().sorted((a,b) -> a.getCreateTime().compareTo(b.getCreateTime())
            ).collect(Collectors.toList());
        };
        users1 = sortUser.apply(DataUtils.userList());
        users1.forEach(user -> {
            LOGGER.info(JsonUtils.toJSon(user));
        });


        Function<List<User>,Optional<User>> findFirst = (userList) ->{
            return userList.stream().findFirst();
        };
        LOGGER.info(JsonUtils.toJSon(findFirst.apply(users1).get()));


        Function<List<User>,Optional<User>> newest = findFirst.compose(sortUser);//最新创建的用户
        LOGGER.info(JsonUtils.toJSon(newest.apply(users1).get()));

        BiFunction<String,List<User>,Optional<User>> x = byName.andThen(newest);
        LOGGER.info(JsonUtils.toJSon(x.apply("张",users1).get()));

        BiFunction<String,List<User>,List<User>> xx= byName.andThen(sortUser);
        List<User> users2 = xx.apply("xx",users1);
        LOGGER.info(JsonUtils.toJSon(users2));

        BiFunction<String,List<User>,Optional<User>> xxx = byRoleName.andThen(newest);
        LOGGER.info(JsonUtils.toJSon(xxx.apply("xxx",users1).get()));
    }
}
