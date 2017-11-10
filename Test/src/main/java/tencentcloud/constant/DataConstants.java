package tencentcloud.constant;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/10 17:14
 */
public class DataConstants {
    public static final  String JSON_DATA = "{"+
            "    \"Action\":\"DescribeInstances\","+
            "    \"Nonce\":11886,"+
            "    \"Region\":\"ap-guangzhou\","+
            "    \"SecretId\":\"AKIDz8krbsJ5yKBZQpn74WFkmLPx3gnPhESA\","+
            "    \"SignatureMethod\":\"HmacSHA256\","+
            "    \"Timestamp\":1465185768,"+
            "    \"InstanceIds.0\":\"ins-09dx96dg\""+
            "}";

    public static final String COMPLETE_URL = "GETcvm.api.qcloud.com/v2/index.php?Action=DescribeInstances" +
            "&InstanceIds.0=ins-09dx96dg" +
            "&Nonce=11886" +
            "&Region=ap-guangzhou" +
            "&SecretId=AKIDz8krbsJ5yKBZQpn74WFkmLPx3gnPhESA" +
            "&SignatureMethod=HmacSHA256" +
            "&Timestamp=1465185768";

    public static final String ENCREPYT_URL_HmacSHA256  = "0EEm/HtGRr/VJXTAD9tYMth1Bzm3lLHz5RCDv1GdM8s=";
    public static final String ENCREPYT_URL_HmacSHA1 = "RVSD1I6ip2Zo56I2HdqRVrt+1TE=";

    public static final String ENCODE_URL_HmacSHA256 = "0EEm%2FHtGRr%2FVJXTAD9tYMth1Bzm3lLHz5RCDv1GdM8s%3D";
    public static final String ENCODE_URL_HmacSHA1 = "";
}
