package sort;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

@Getter
@Setter
@ToString
public class People implements Comparable{
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 身高
     */
    private Integer height;
    /**
     * 体重
     */
    private Integer weight;


    @Override
    public int compareTo(Object o) {
        People people = (People) o;
        //年龄升序
        if(this.getAge() < people.getAge()){
            return 1;
        }else if(this.getAge() == people.getAge()){
            //身高降序
            if(this.getHeight() < people.getHeight()){
                return 1;
            }else if (this.getHeight() == people.getHeight()){
                //体重降序
                if(this.getWeight() < people.getWeight()){
                    return 1;
                }else if (this.getWeight() == people.getWeight()){
                    return 0;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}
