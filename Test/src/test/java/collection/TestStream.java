package collection;

import myBatis.po.User;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import util.DataUtils;
import util.JsonUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 16:12
 *  
 */
@FixMethodOrder(MethodSorters.JVM)
public class TestStream {
    Logger LOGGER = Logger.getLogger(TestStream.class);
    private static List<Integer> integers = DataUtils.getIntegers();


    @Test
    public void testSteamForJdk7(){
        List<Integer> list = new ArrayList<>();
        for(Integer t: integers){
            if(t.intValue() > 5000){
                list.add(t);
            }
        }

    }

    @Test
    public void testNewInstance(){//创建Stream的方式
        Stream stream = Stream.of("a","b","c");
        stream.forEach(System.out::print);
        System.out.println();
        String[] arrays = new String[]{"a","b","c"};
        Stream arrayStream = Stream.of(arrays);
        Stream arrayStream2 = Arrays.stream(arrays);

        List<String> strList = Arrays.asList(arrays);
        Stream stream1 = strList.stream();

        //数值流
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);
        System.out.println();
        IntStream.range(1, 3).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 3).forEach(System.out::print);
        System.out.println();
    }

    @Test
    public void testMap(){
        List<String> output = DataUtils.getStrs().stream()
                .map(String::toUpperCase).collect(Collectors.toList());
        for(String s : output){
            System.out.println(s);
        }

        List<Integer> intOutPut = DataUtils.getNums().stream()
                .map(x -> x*x)
                .collect(Collectors.toList());
        for(Integer i : intOutPut){
            System.out.println(i);
        }
    }

    @Test
    public void testFlatMap(){
        Stream<List<Integer>> stream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );

        List<Integer> output = stream.
                flatMap((childList) -> childList.stream())
                .collect(Collectors.toList());
        for(Integer i : output){
            System.out.println(i);
        }
    }

    @Test
    public void testFilter(){
        List<Integer> list = DataUtils.getNums();

        List<Integer> evenList = list.stream().filter((x) -> x%2==0)
                .collect(Collectors.toList());
        System.out.println(JsonUtils.toJSon(evenList));

    }

    @Test
    public void testForEach(){
        List<Integer> list = DataUtils.getNums();
        list.stream().filter((x) -> x %2 != 0)
                .forEach((x) ->{System.out.println(x);});
    }

    @Test
    public void testPeek(){
//        peek 对每个元素执行操作并返回一个新的 Stream
        List<String> list = Stream.of("one","two","three","four")
                .filter(x -> x.length() > 3)
                .peek(x -> System.out.println("original value " + x))
                .map(x -> x.toUpperCase())
                .peek(x -> System.out.println("mapped value " + x))
                .collect(Collectors.toList());

        System.out.println(JsonUtils.toJSon(list));
    }

    @Test
    public void testReduce(){
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);
    }

    @Test
    public void testLimitAndSkip(){
        List<Integer> integers = DataUtils.getIntegers().stream()
                .map(x -> x-1)
                .limit(100)
                .skip(99)
                .collect(Collectors.toList());
        System.out.println(JsonUtils.toJSon(integers));
    }

    @Test
    public void testSorted(){
        List<Integer> list = DataUtils.getNums()
                .stream()
                .limit(5)
                .distinct()
                .filter(x -> x %2 ==0)
                .sorted((a,b) -> a.compareTo(b))
                .collect(Collectors.toList());
        System.out.println(JsonUtils.toJSon(list));
    }

    @Test
    public void testMinMaxDistinct(){
        Optional optional = DataUtils.getNums().stream().min((a,b) -> a.compareTo(b));
        System.out.println(JsonUtils.toJSon(optional.get()));

        Optional optional1 = DataUtils.getNums().stream().max((a,b) -> a.compareTo(b));
        System.out.println(JsonUtils.toJSon(optional1.get()));
    }

    @Test
    public void testMatch(){
        List<User> userList = DataUtils.userList();
        boolean isAllAdult = userList.stream().allMatch(u -> u.getId() > 3);
        boolean isThereAnyChild = userList.stream().anyMatch(u -> u.getId() < 3);
        System.out.println("is all adult : " + isAllAdult);
        System.out.println("is there any child : " + isThereAnyChild);
    }

    @Test
    public void testSelfGenerateStream(){
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        System.out.println();
        IntStream.generate(() -> (int)(System.nanoTime() % 100)).limit(10).forEach(System.out::println);
    }

    @Test
    public void testSelfImplementSupplier(){
        Stream.generate(new UserSupplier()).limit(10)
                .forEach( u -> System.out.println("id = " + u.getId() + "; userName = " + u.getUserName()));

    }

    @Test
    public void testIterate(){
        UnaryOperator operator = UnaryOperator.identity();//一元操作
        operator.apply(1);
        Stream.iterate(1,t->t*2).limit(10).forEach(x -> System.out.print(x + " "));//生成等比、等差数列
    }

    @Test
    public void testGroupBy(){
        Map<Integer,List<User>> userGroups = Stream.generate(new UserSupplier())
                .limit(5)
                .collect(Collectors.groupingBy(null));
    }

    @Test
    public void testOther(){

    }

    class UserSupplier implements Supplier<User>{
        private int index = 0;
        private Random random = new Random();
        int randomNum = random.nextInt(20) % 5;
        @Override
        public User get() {
            return DataUtils.userList().get(randomNum);
        }
    }
}
