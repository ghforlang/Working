package other.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-28 16:07
 *  
 */
public class TestMethods {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        TestMethods method = new TestMethods();
        method.testMethods();
    }

    public void testMethods() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("myBatis.po.User");

        //只能获取类的共有方法，私有方法获取不到
        Method[] methods = clazz.getMethods();
        System.out.println("方法总数：" + methods.length);
        for (int i = 0; i <methods.length ; i++) {
            System.out.println(methods[i].getName());
        }

        System.out.println("*************************");
        //获取当前类声明的所有方法，包括私有方法，不包括继承父类的方法
        methods = clazz.getDeclaredMethods();
        System.out.println("方法总数：" + methods.length);
        for (int i = 0; i <methods.length ; i++) {
            System.out.println(methods[i].getName());
        }

        System.out.println("*************************");
        Method method = clazz.getMethod("setUserName",String.class);
        System.out.println(method);

        System.out.println("*************************");
        Method method1= clazz.getMethod("getUserName");
        Object obj = clazz.newInstance();
        method.invoke(obj,"aaa");
        System.out.println(method1.invoke(obj));
    }
}
