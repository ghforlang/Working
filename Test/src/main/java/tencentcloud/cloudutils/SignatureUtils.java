package tencentcloud.cloudutils;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import tencentcloud.constant.QCloudConstants;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/10 16:36
 */
public class SignatureUtils {

    public static String encryptURL(String completeURL,String encryptType) {
        if(StringUtils.isNotBlank(completeURL) && StringUtils.isNotBlank(encryptType)){
            return base64(encrypted(completeURL,encryptType));
        }
        return null;
    }

    private static String base64(String str){
        byte[] b=str.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        return new String(b);
    }

    private static String encrypted(String str,String encryptType){
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance(encryptType);
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    public static String getURL(String jsonStr){
        Map<String,String> map = getStrMap(jsonStr);
        List<String> list = new ArrayList<>(map.size());
        for(Map.Entry<String,String> entry : map.entrySet()){
            String subStr = entry.getKey() + "=" + entry.getValue();
            list.add(subStr);
        }

        return StringUtils.join(list,"&");
    }

    private static Map<String,String> getStrMap(String jsonStr){
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isNotBlank(jsonStr)){
            jsonStr = StringUtils.replace(jsonStr,"\"","");
            if(StringUtils.startsWith(jsonStr,"{")){
                jsonStr = StringUtils.substring(jsonStr,1);
            }
            if(StringUtils.endsWith(jsonStr,"}")){
                jsonStr = StringUtils.substring(jsonStr,0,jsonStr.length()-1);
            }
            if(StringUtils.isNotBlank(jsonStr)){
                String[] fields = StringUtils.split(jsonStr,",");
                for(String field : fields){
                    if(StringUtils.isNotBlank(field) && StringUtils.contains(field,":")){
                        String[] subStrs = StringUtils.split(field,":");
                        if(subStrs.length %2 == 0){
                            map.put(subStrs[0].trim(),subStrs[1].trim());
                        }
                    }
                }
            }

        }
        return map;
    }
}
