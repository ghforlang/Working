package other.reconstruct;

import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 16:18
 *  
 */
public class Student2 {
    private String name;
    private List<String> courses;

    public Student2(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public void addCourse(String course){
        courses.add(course);
    }

    public String removeCourse(String course){
        if(courses.remove(course)){
            return course;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
