package collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:48
 *  
 */
public class TestOperator {
    Logger LOGGER = Logger.getLogger(TestOperator.class);

    @Test
    public void testOperator(){
        //BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用 
        BinaryOperator<String> bina = (x, y) ->{System.out.print(x+" "+y);return "BinaryOperator";};
        System.out.println("  "+bina.apply("hello ","world"));
    }
}
