package other.reconstruct;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 16:14
 *  
 */
public class Test {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1(){
        List<String> courses = new ArrayList<>();
        courses.add("英语");

        Student xiaoli = new Student("xiaoli",courses);
        xiaoli.getCourses().add("数学");

        for (String course: xiaoli.getCourses()) {
            System.out.println(course);
        }
    }

    public static void test2(){
        List<String> courses = new ArrayList<>();
        courses.add("英语");

        Student2 xiaoli = new Student2("xiaoli",courses);
        xiaoli.addCourse("数学");
        for (String course: xiaoli.getCourses()) {
            System.out.println(course);
        }
    }
}
