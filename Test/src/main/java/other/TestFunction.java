package other;

import org.apache.ibatis.io.ResolverUtil;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-04 18:55
 *  
 */
public class TestFunction {
    Function<String,Integer> function = new Function<String,Integer>() {
        @Override
        public Integer apply(String s) {
            return 0;
        }
    };

    interface IntegerMath{
        int operation(int a,int b);
    }

    public int operateBinary(int a,int b,IntegerMath op){
        return op.operation(a,b);
    }

    public static void main(String[] args){
//        test1();
        test2();
    }

    public static void test1(){
        TestFunction FUNCTION = new TestFunction();
        IntegerMath addition = (a,b) -> a + b;
        IntegerMath subtraction = (a,b) -> a - b;

        System.out.println("40 + 2 = " + FUNCTION.operateBinary(40,2,addition));
        System.out.println("40 - 2 = " + FUNCTION.operateBinary(40,2,subtraction));
    }

    class FirstLevel{
        public int x = 0;
        void methodInFirstLevel(int x){
            Consumer<Integer> myConsumer = (y) ->{
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("this.X = " + this.x);
                System.out.println("TestFunction.this.x = " + TestFunction.this.x);
            };

            myConsumer.accept(x);
        }
    }

    public static void test2(){
        TestFunction function = new TestFunction();
        function.FirstLevel firstLevel =
    }
}


