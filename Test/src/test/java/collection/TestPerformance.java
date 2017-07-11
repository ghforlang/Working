package collection;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import util.DataUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 14:54
 *  
 */
@FixMethodOrder(MethodSorters.JVM)
public class TestPerformance {
    Logger LOGGER = Logger.getLogger(TestOthers.class);
    public static List<Integer> integers = DataUtils.getIntegers();

    @Test
    public void testIterator(){
        //iterator
        long startTime = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for (Iterator it = integers.iterator(); it.hasNext(); ) {
            max = Integer.max(max, (Integer)it.next());
        }
        long endTime = System.currentTimeMillis();
//        LOGGER.info("iterator time cost :" + (endTime - startTime) + "   max value: " + max);
        System.out.println("iterator time cost :" + (endTime - startTime) + "   max value: " + max);
    }

    @Test
    public void testForeach(){
        //foreach
        long startTime = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for (Integer n : integers) {
            max = Integer.max(max, n);
        }
        long endTime = System.currentTimeMillis();
//        LOGGER.info("foreach time cost :" + (endTime - startTime) + "max value: " + max);
        System.out.println("foreach time cost :" + (endTime - startTime) + "    max value: " + max);
    }

    @Test
    public void testForI(){
        //fori
        long startTime = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <integers.size(); i++) {
            max = Integer.max(max, integers.get(i));
        }
        long endTime = System.currentTimeMillis();
//        LOGGER.info("fori time cost :" + (endTime - startTime) + "max value: " + max);
        System.out.println("fori time cost :" + (endTime - startTime) + "       max value: " + max);
    }

    @Test
    public void testFunctional(){
        long startTime = System.currentTimeMillis();
        //functional
        Optional maxx = integers.parallelStream().reduce(Integer::max);
        long endTime = System.currentTimeMillis();
//        LOGGER.info("functional paraller stream time cost :" + (endTime - startTime) + "max value: " + maxx.get());
        System.out.println("functional paraller stream time cost :" + (endTime - startTime) + "       max value: " + maxx.get());
    }

    @Test
    public void testLambda(){
        long startTime = System.currentTimeMillis();
        //lambda
        int max = integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
        long endTime = System.currentTimeMillis();
//        LOGGER.info("lambda time cost :" + (endTime - startTime) + "max value: " + maxx.get());
        System.out.println("lambda time cost :" + (endTime - startTime) + "       max value: " + max);
    }

    @Test
    public void testForeachLambda(){
        //forEachLambda
        long startTime = System.currentTimeMillis();
        final IntegerWrapper wrapper = new IntegerWrapper();
        wrapper.inner = Integer.MIN_VALUE;
        integers.forEach(i -> wrapper.helper(i, wrapper));
//        LOGGER.info("forEachLambda time cost :" + (endTime - startTime) + "max value: " + wrapper.inner.intValue());
        long endTime = System.currentTimeMillis();
        System.out.println("forEachLambda time cost :" + (endTime - startTime) + "       max value: " + wrapper.inner.intValue());
    }

    @Test
    public void testStream(){
        long startTime = System.currentTimeMillis();
        //stream
        Optional max = integers.stream().reduce(Integer::max);
//        LOGGER.info("stream time cost :" + (endTime - startTime) + "max value: " + wrapper.inner.intValue());
        long endTime = System.currentTimeMillis();
        System.out.println("stream time cost :" + (endTime - startTime) + "       max value: " + max.get());
    }
    public static class IntegerWrapper {
        public Integer inner;

        private int helper(int i, IntegerWrapper wrapper) {
            wrapper.inner = Math.max(i, wrapper.inner);
            return wrapper.inner;
        }
    }

}
