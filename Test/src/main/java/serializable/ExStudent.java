package serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-01 10:15
 *  
 */
public class ExStudent implements Externalizable {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

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

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ExStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
