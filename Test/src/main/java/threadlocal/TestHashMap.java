package threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/5/14 19:34
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        new Thread(
                () -> {
                    for (int i = 0; i< 10000; i++) {
                        map.put(i, i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        for(int i=0;i<10;i++){
            new Thread(
                    () -> {
                        while (true) {
                            for (Integer key : map.keySet()) {
                                System.out.println(key + "," + map.get(key));
                            }
                        }
                    }
            ).start();
        }
    }
}
