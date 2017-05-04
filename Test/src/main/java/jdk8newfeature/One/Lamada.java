package jdk8newfeature.One;

import util.PrintUtils;

import java.util.Arrays;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-27 19:19
 *  
 */
public class Lamada {
    private static String[] arrTest = {"a","b","c"};

    public static void lamada1(){
        PrintUtils.print("lamadal : ");
        Arrays.asList(arrTest).forEach(e -> PrintUtils.print(e));
        PrintUtils.println();
    }

    public static void lamada2(){
        PrintUtils.print("lamada2 : ");
        Arrays.asList(arrTest).forEach((String e)-> PrintUtils.print(e));
        PrintUtils.println();
    }

    /**
     * 注意：lamada3 与lamada4是等价的
     * Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）
     */

    public static void lamada3(){
        String separator = " | ";
        Arrays.asList(arrTest).forEach(
                (String e) -> PrintUtils.print( e + separator)
        );
    }

    public static void lamada4(){
        final String  separator = " | ";
        Arrays.asList(arrTest).forEach(
                (String e) -> PrintUtils.print(e + separator)
        );
    }

    /**
     * lamada5与lamada6是完全等价的
     * Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句
     */
    public static void lamada5(){
        Arrays.asList(arrTest).sort((e1,e2) -> e1.compareTo(e2));
    }

    public static  void lamada6(){
        Arrays.asList(arrTest).sort((e1,e2) ->{
            int result = e1.compareTo(e2);
            return result;
        });
    }

    /**
     * 函数式接口
     * 使现有的函数友好地支持lambda
     * 函数式接口，即一个具有一个方法的普通接口，这样的接口可以被隐式转为lamada表达式
     * 为了克服函数式接口的这种脆弱性并且能够明确声明接口作为函数式接口的意图，
     * Java 8增加了一种特殊的注解@FunctionalInterface
     */
    public static void lamada7(){

    }
}
