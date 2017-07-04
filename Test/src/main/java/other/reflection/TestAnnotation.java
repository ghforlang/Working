package other.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 11:08
 *  
 */
public class TestAnnotation {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Person person = new Person("李四",30);

        Class clazz = Class.forName("other.reflection.Person");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("setAge",Integer.class);

        int val = 100;

        Annotation annotation = method.getAnnotation(PersonValidator.class);
        System.out.println(annotation);

        if(annotation != null){
            if(annotation instanceof PersonValidator){
                PersonValidator personValidator = (PersonValidator)annotation;
                if(val < personValidator.min() || val > personValidator.max()){
                    throw  new IllegalMonitorStateException("参数范围超出限制");
                }
            }
        }
        method.invoke(obj,val);
        System.out.println(obj);
    }
}
