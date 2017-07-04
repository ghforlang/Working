package other.reflection;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 10:46
 *  
 */
public class TestFiled {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("other.reflection.Person");

        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            System.out.println(field);
        }

        Person person = new Person("张三",20);
        Field field = clazz.getDeclaredField("name");
        System.out.println(field);
        System.out.println(field.get(person));

        field.set(person,"李四额");
        System.out.println(field.get(person));

        Field field2 = clazz.getDeclaredField("age");
        field2.setAccessible(true);
        System.out.println(field2.get(person));
        field2.set(person,40);
        System.out.println(field2.get(person));
    }
}
