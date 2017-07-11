package collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.function.Function;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:43
 *  
 */
public class TestFunction {
    Logger LOGGER = Logger.getLogger(TestFunction.class);

    @Test
    public void testFunction(){
        // Function<T, R> -T作为输入，返回的R作为输出 (有输入输出的函数) 
        Function<String,Boolean> function = (x) -> {System.out.print(x+": ");return false;};
        Boolean result = function.apply("hello world");
        System.out.println(result);

        Function<Integer,Integer> times = (e) ->{
            LOGGER.info("times:" + e);
            e = e * 2;
            return e;
        };

        Function<Integer,Integer> mutil = (e) ->{
            LOGGER.info("mutil:" + e);
            e = e * e;
            return e;
        };

        Function<Integer,Integer> mutil3 = (e)->{
            LOGGER.info("mutil3:" + e);
            e = e * 3;
            return e;
        };

        //执行顺序：mutil3 -> times -> mutil
        System.out.println(times.andThen(mutil).compose(mutil3).apply(4));//576
        //执行顺序：mutil -> times -> mutil3
        System.out.println(times.compose(mutil).andThen(mutil3).apply(4));//32
    }
}
