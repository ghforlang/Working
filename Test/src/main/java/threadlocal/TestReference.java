package threadlocal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/5/15 10:59
 */
public class TestReference {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            testReference();
        }
    }

    private static void testReference(){
        String str = new String("aaa");
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        WeakReference<String> wr = new WeakReference<String>(str,rq);
        //取消str的强引用
        str = null;
        //若 "aaa"已经被GC，那么str1应该为null,对应rq.poll()返回reference对象
        //若 "aaa"未被GC,那么 str1应该为"aaa",对应rq.poll()返回null;
        String str1 = wr.get();
        System.out.println("str1 : " +str1);
        Reference<? extends String> ref = rq.poll();
        System.out.println("ref : " + ref);
    }

}
