package study.exception;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/28 16:40
 */
public class TestException2 {
    public long maxLevel = 20;

    public static void main(String[] args) {
        TestException2 te = new TestException2();

        long start = System.currentTimeMillis();
        int count = 10000;
        for(int i=0;i<count ;i ++ ){
            try{
                doTest(2,0);
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println("程序異常");
            }
        }

        long diff = System.currentTimeMillis() - start;
        System.out.println("average time : " + (double)diff/count);
    }

    public static void doTest(int a,int b){
        int i = a / b;
        System.out.println(i);
    }
}
