package other.reflection;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 10:45
 *  
 */
public class Person {
    public String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    @PersonValidator(max = 100,min=0)
    public void setAge(Integer age) {
        this.age = age;
    }
}
