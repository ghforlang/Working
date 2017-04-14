import java.util.EnumMap;
import java.util.EnumSet;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by fanwenhao on 2017/3/29.
 */
public class Test {
    public static void main(String[] args){
//        System.out.println("xxx");
//        System.out.println("ttttt");
//        Integer a = TestEnum.TWO;
//        System.out.println(TestEnum.ZERO);
//        System.out.println(TestEnum.TWO);
//        TestEnum a = TestEnum.ZERO;
        System.out.println("List Enum ");
        for( TestEnum a : TestEnum.values()){
            System.out.println(a);
//            System.out.println(a.toString());
//            System.out.println(a.name());
//            System.out.println(a.ordinal());
        }
        System.out.println("EnumMap :");
        EnumMap<TestEnum,String> map = new EnumMap<TestEnum, String>(TestEnum.class);
        for( TestEnum a : TestEnum.values()){
           map.put(a,new Integer(a.ordinal()).toString());
        }

        for(EnumMap.Entry<TestEnum,String> entry : map.entrySet()){
            System.out.println(entry.getValue() + "," + entry.getKey());
        }
        System.out.println("EnumSet:");
        EnumSet<TestEnum> enumSet = EnumSet.allOf(TestEnum.class);
//                EnumSet.noneOf(TestEnum.class);
        for(TestEnum t: enumSet){
            System.out.println(t.ordinal() + "," + t.name());
        }

        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        System.out.println(str);
        System.out.println(str.replace("-",""));

//        Enum<Integer> e = new Enum<Integer>();

    }

}
