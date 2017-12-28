import org.apache.commons.lang.ArrayUtils;
import other.recursion.SubObjOne;
import other.recursion.SubObjTwo;
import other.recursion.TargetObj;
import util.JsonUtils;

import java.lang.reflect.Field;
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
        Object[] objs = testData();
        Object[] filtedObjects = filtObjects(objs);
        for(Object obj : filtedObjects){
            System.out.println(obj);
        }
    }

    public static Object[] filtObjects(Object[] objs){
        if(ArrayUtils.isEmpty(objs)){
            return null;
        }
        List<Object> objList = new ArrayList<>(objs.length);
        for(Object obj : objs){
            if(obj instanceof byte[]){
                objList.add("bytes");
            }else{
                Field[] fields = obj.getClass().getDeclaredFields();
                for(Field field : fields){
                    if(field.getType().equals(byte[].class)){
                        obj.getClass();
                    }
                }
                objList.add(JsonUtils.toJSon(obj));
            }
        }

        return objList.toArray();
    }

    private static void testOne(){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        Integer[] IntArr = list.toArray(new Integer[list.size()]);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(i);
        }
    }

    private static Object[] testData(){
        List<Object> objects = new ArrayList<>(3);
        objects.add("xTest");
        objects.add(123);
        TargetObj to = new TargetObj();
        byte[] bytes = {1,2,3};
        byte[] bytes1 = {3,2,1};
        byte[] bytes3 = {4,5,6,7};
        to.setBytes(bytes);
        to.setDesc("targetObj");
        to.setName("targetObj");

        SubObjOne soo = new SubObjOne();
        soo.setFiles(bytes1);
        soo.setName("subObjOne");

        SubObjTwo sot = new SubObjTwo();
        sot.setName("subObjTwo");
        sot.setSubFile(bytes3);

        soo.setSubObjTwo(sot);
        to.setSubObjOne(soo);
        objects.add(to);

        return objects.toArray();
    }

}
