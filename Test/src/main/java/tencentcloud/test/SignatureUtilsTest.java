package tencentcloud.test;

import org.apache.commons.lang.StringUtils;
import tencentcloud.cloudutils.SignatureUtils;
import tencentcloud.constant.DataConstants;
import tencentcloud.constant.QCloudConstants;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/10 16:36
 */
public class SignatureUtilsTest {

    private static final String TEST_SECRET_ID = "AKIDz8krbsJ5yKBZQpn74WFkmLPx3gnPhESA";
    private static final String TEST_SECRET_KEY = "Gu5t9xGARNpq86cd98joQYCN3Cozk1qA";

    private static final String REQUEST_GET = "GET";
    private static final String REQUEST_POST = "POST";
    private static final String HOST_NAME = "cvm.api.qcloud.com";
    private static final String TEST_ULR = "/v2/index.php";
    private static final String SEPRATOR = "?";
    private static final String SEPRATOR_ = "&";


    public static void main(String[] args) {
//        testBuildCompleteURL();
        testEncryptURL();
    }

    public static void testEncryptURL(){
        String encryptedURL = SignatureUtils.encryptURL(DataConstants.COMPLETE_URL, QCloudConstants.SIGNATURE_METHOD_HmacSHA256);
        System.out.println(encryptedURL);
        System.out.println("**************************************");
        System.out.println(DataConstants.ENCREPYT_URL_HmacSHA256);
        System.out.println(strEquals(encryptedURL,DataConstants.ENCREPYT_URL_HmacSHA256));
    }


    public static void testBuildCompleteURL(){
        System.out.println(DataConstants.COMPLETE_URL);
        String compareURL = buildCompleteURL(DataConstants.JSON_DATA);
        System.out.println("**************************************");
        System.out.println(compareURL);
        System.out.println(strEquals(DataConstants.COMPLETE_URL,compareURL));
    }

    public static String buildCompleteURL(String url){
        StringBuilder sb = new StringBuilder();
        sb.append(REQUEST_GET);
        sb.append(HOST_NAME);
        sb.append(TEST_ULR);
        sb.append(SEPRATOR);
        if(StringUtils.isNotBlank(url)){
            url = SignatureUtils.getURL(url);
            sb.append(url);
        }
        return sb.toString();
    }

    public static boolean strEquals(String a,String b){
        if(a== null || b == null){
            return false;
        }
        return a.equalsIgnoreCase(b);
    }

}
