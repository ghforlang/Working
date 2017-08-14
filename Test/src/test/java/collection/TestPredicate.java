package collection;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    @Test
    public void testA(){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<18;i++){
            list.add(i);
        }
       List<Integer>  subList  = list.stream().filter(integer -> {
            if(integer % 3 == 0){
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        subList.forEach(integer -> {
            System.out.println(integer);
        });
    }
}
