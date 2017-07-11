package collection;

import exception.ValueAbsentException;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Optional;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:19
 *  
 */
public class TestOptional  {
    Logger LOGGER = Logger.getLogger(TestOptional.class);

    @Test
    public void testOptionalInstance(){
        //这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
        //实例化
        Optional<String> p = Optional.of("xx");
        LOGGER.info(p.get());

        p = Optional.ofNullable(null);
        LOGGER.info(p.isPresent());
        p = Optional.ofNullable("xxx");
        LOGGER.info(p.get() instanceof String);

        p = Optional.empty();
        LOGGER.info(p.isPresent());

    }

    @Test
    public void testIfPresent(){
        Optional<Object> p = Optional.empty();
        Optional<Object> userName = Optional.of("zhangsan");

        LOGGER.info(p.isPresent());
        p.ifPresent(xxx ->{
            LOGGER.info(xxx);
        });

        //如果Optional实例有值则为其调用consumer，否则不做处理
        p.ifPresent(xxx ->{
            System.out.println(xxx);
        });
        LOGGER.info(userName.isPresent());
        userName.ifPresent(xxx ->{
            LOGGER.info(xxx);
        });
    }

    @Test
    public void testOrElse(){
        Optional<Object> p = Optional.empty();
        Optional<Object> userName = Optional.of("zhangsan");

        // 如果有值则将其返回，否则返回指定的其它值
        LOGGER.info(p.orElse("orElse"));
        LOGGER.info(userName.orElse("null orElse"));

        //orElseGet与orElse方法类似，区别在于可以用supplier得到的默认值
        LOGGER.info(p.orElseGet(() ->"xxxxxxxx"));
        LOGGER.info(userName.orElseGet(() -> "aaaaaa"));

        // 如果有值则将其返回，否则抛出supplier接口创建的异常
        try {
            p.orElseThrow(ValueAbsentException::new);
        } catch (ValueAbsentException e) {
            LOGGER.info(e.getMessage());
        }

    }

    @Test
    public void testMap(){
        Optional<String> p = Optional.empty();
        Optional<String> userName = Optional.of("zhangsan");
        //如果有值，则对其执行调用mapping函数得到返回值。如果返回值不为null，则创建包含mapping返回值的Optional作为map方法返回值，否则返回空Optional
        Optional<String> upperP = userName.map((x) -> x.toUpperCase());
        LOGGER.info("userName:" + userName.get() + ",upperUserName:" + upperP.orElse("null"));

        //如果有值，为其执行mapping函数返回Optional类型返回值，否则返回空Optional。flatMap与map（Funtion）方法类似，
        // 区别在于flatMap中的mapper返回值必须是Optional。调用结束时，flatMap不会对结果用Optional封装
        Optional<String> upperPp = userName.flatMap((value) -> Optional.of(value.toUpperCase()));
        LOGGER.info("userName:" + userName.get() + ",upperUserName:" + upperPp.orElse("null"));
    }

    @Test
    public void testFilter(){
        //如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional
        Optional<String> p = Optional.empty();
        Optional<String> userName = Optional.of("zhangsan");

        Optional<String> longName = userName.filter((value) -> value.length() > 6);
        LOGGER.info(longName.orElse("string length less than 6"));

        Optional<String> shortName = userName.filter((value) -> value.contains("xxx"));
        LOGGER.info(shortName.orElse("string contains no san"));

    }
}
