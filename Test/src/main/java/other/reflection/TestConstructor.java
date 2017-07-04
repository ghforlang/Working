package other.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 10:56
 *  
 */
public class TestConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = (Class<Person>)Class.forName("other.reflection.Person");

        Constructor<Person>[] constructors = (Constructor<Person>[]) clazz.getConstructors();

        for(Constructor con : constructors){
            System.out.println(con);
        }

        Constructor constructor = clazz.getConstructor(String.class,Integer.class);
        System.out.println("指定的constructor  " + constructor);
        constructor.setAccessible(true);


        Person obj = (Person)constructor.newInstance("老李",20);
        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}
