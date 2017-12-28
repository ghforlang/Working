import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/28 15:32
 */
public class TestList {
    private static final List<Integer> arrList = new ArrayList<>();
    private static final List<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        generateArrList();;
        System.out.println();
        genreateLinkedList();
    }

    public static final void generateArrList(){
        for(int i=0;i<100;i++){
            arrList.add(i);
        }
        arrList.forEach(value ->{
            System.out.print(value + ",");
        });
    }

    public static final void genreateLinkedList(){
        for(int i=0;i<100;i++){
            linkedList.add(i);
        }

        linkedList.forEach(value ->{
            System.out.print(value + ",");
        });
    }
}
