import util.HttpUtils;

import java.util.Map;

/**
 * @author fanwh
 *
 * @version v1.0
 * @decription
 * @create on 2017/11/8 16:51
 */
public class TestHttpUtils {

    private static final  String url = "http://fs.static.guahao-inc.com/bo227397415?token=NTdhYjJiY2IyOGRlMTIwYTk2ZmZkZmY2MmFjMmNjODBfTUQ1COUSTOM";

    public static void main(String[] args) {
//        testHttpUtils();
//        testGetAttachFileName();
        testReleaseMap();
    }


    public static void testHttpUtils(){
        Map<String,String> responseMap = HttpUtils.getResponseInfo(url);

        responseMap.forEach((k,v) ->{
            System.out.println(k + " : " + v);
        });
    }

    public static void testGetAttachFileName(){
        System.out.println(HttpUtils.getAttachmentName(url));
    }

    public static void testReleaseMap(){
        Map<String,String> map = HttpUtils.getResponseInfo(url);
        Map<String,Map<String,String>> resultMap = HttpUtils.valueRelease(map);
        resultMap.forEach((k,v) ->{
            System.out.println(k + " : ");
            v.forEach((kk,vv)->{
                System.out.println( "    " + kk + " : " + vv);
            });
        });
    }

}
