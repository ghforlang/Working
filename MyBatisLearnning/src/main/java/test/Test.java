package test;

import java.util.*;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-19 15:36
 *  
 */
public class Test {
    private static final int NUM = 10000;

    public static void main(String[] args){
        List<Integer> list = null;
        Map<Integer,Integer> countMap = new HashMap<Integer, Integer>();
        for(int i=0;i<10;i++){
            list = getNumbers(NUM);
            for(Integer num : list){
                System.out.print(num + ",");
            }
            System.out.println();
            for(Integer num : list){
                Integer xx = countMap.get(num.intValue());
                if(null != xx){
                    countMap.put(num.intValue(),++xx);
                }else{
                    countMap.put(num.intValue(),1);
                }
            }
        }

        System.out.println("*******************************************");
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue() >=5){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

//        for(int i=0;i<10;i++){
//            System.out.print((i+1) + " : ");
//            list = getNumbers(NUM);
//            Collections.sort(list);
//            printList(list);
//        }

    }

    public static void printList(List<Integer> list){
        for(Integer num : list){
            System.out.print(num + ",");
        }
        System.out.println();
    }

    public static List<Integer> getNumbers(Integer num){
        List<Integer> result = new ArrayList<Integer>(5);
        Random random = new Random();
        int xx = 0;
        while(result.size()< 5){
            xx = random.nextInt(num);
            xx %= 13;
            if(xx != 0 && !result.contains(xx)){
                result.add(xx);
            }else{
                xx = random.nextInt();
            }
        }
        return result;
    }

}
