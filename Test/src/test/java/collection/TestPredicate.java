package collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:45
 *  
 */
public class TestPredicate {
    Logger LOGGER = Logger.getLogger(TestPredicate.class);

    @Test
    public  void testPredicate(){
        //Predicate<T> -T作为输入，返回的boolean值作为输出(特定输出函数，true Or false)  
        Predicate<String> pre = (x) ->{
            LOGGER.info(x);
            if(x instanceof String){
                return true;
            }
            return false;};

        LOGGER.info(": "+pre.test("hello World"));

        Predicate<String> pre1 = (x) ->{
            LOGGER.info(x);
            return pre.test(x);
        };

        LOGGER.info(": " + pre.and(pre1).test("12"));
        LOGGER.info(": " + pre.or(pre1).test("13"));
    }
}
