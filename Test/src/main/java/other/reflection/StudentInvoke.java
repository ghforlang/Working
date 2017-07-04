package other.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-30 09:34
 *  
 */
public class StudentInvoke extends PersonInvoke{

    public static void main(String[] args) {
        Object obj = new StudentInvoke();
        Object result = invoke(obj,"method1",20);
        System.out.println(result);
        result = invoke(obj,"method2");
        System.out.println(result);
    }

    private String method1(Integer age){
        return "this is StudentInvoke age = " + age;
    }

    public static Object invoke(Object obj,String methodName,Object ...args){
        Class[] paramTypes = new Class[args.length];

        for (int i = 0; i <args.length ; i++) {
            paramTypes[i] = args[i].getClass();
        }

        Method method = getMethod(obj.getClass(),methodName,paramTypes);
        method.setAccessible(true);
        try {
            return method.invoke(obj,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object invoke(String className,String methodName,Object...args){
        Object obj = null;
        try {
            obj = Class.forName(className);
            return invoke(obj,methodName,args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoke(null,methodName,args);
    }


    private static Method getMethod(Class clazz,String methodName,Class ...classes){
        for (;clazz != Object.class;clazz = clazz.getSuperclass()){
            try {
                return clazz.getDeclaredMethod(methodName,classes);
            } catch (NoSuchMethodException e) {
            }
        }
        return null;
    }
}
