package other.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-27 11:04
 *  
 */
public class ReflectService {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        Object service = Class.forName("ReflectService").newInstance();
        Method method = service.getClass().getMethod("print",String.class);
        method.invoke(service,"zhang san");
    }

    public void print(String name){
        System.out.println("this is " + name);
    }
}
