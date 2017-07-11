package collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:47
 *  
 */
public class TestConsumer {
    Logger LOGGER = Logger.getLogger(TestConsumer.class);

    @Test
    public void testConsumer(){
        //Consumer<T> - T作为输入，执行某种动作但没有返回值(void类型函数) 
        Consumer<String> con = (x) -> {System.out.println(x);};
        Consumer<String> consum = (x) ->{
            System.out.println(x);
        };
        con.andThen(consum).accept("12");
        con.accept("hello world");
    }
}
