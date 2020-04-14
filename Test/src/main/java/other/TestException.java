package other;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/3/29 17:15
 */
public class TestException {
    public static void main(String[] args) {
        System.out.println(exception());
    }

    static int exception(){
        int i =4;
        try{
            i= 3;
            return i;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            i = 12;
//            System.out.println(i);
            return i;
        }
//        return 0;
    }

}
