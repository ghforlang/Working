import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-03 15:51
 *  
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        Integer[] IntArr = list.toArray(new Integer[list.size()]);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(i);
        }
    }


}
