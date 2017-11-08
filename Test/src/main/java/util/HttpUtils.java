package util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/8 16:28
 */
public class HttpUtils {

    public static final String SERVER = "Server";
    public static final String DATE = "Date";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONNECTION = "Connection";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String EXPIRES_DATE = "Expires";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String LAST_MODIFIED_DATE = "Last-Modified";

    private static final String ATTACH_FILE_NAME = "filename";

    private static final String HEADER_HOST = "Host";
    public static final int HTTP_OK = 200;

    private static CloseableHttpClient CLIENT;

    static {
        RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000)
                .setConnectionRequestTimeout(2000).build();
        CLIENT = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig)
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
    }

    public static Map<String,String> getResponseInfo(String url){
        Map<String, String> resultMap = new HashMap<>();
        if(StringUtils.isBlank(url)){
            return resultMap;
        }
        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = CLIENT.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                Header[] headers = response.getAllHeaders();
                if(ArrayUtils.isNotEmpty(headers)){
                    for(Header header : headers){
                        resultMap.put(header.getName(),URLDecoder.decode(header.getValue(),"UTF-8"));
                    }
                }
            } else {
                System.out.println("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public static String getAttachmentName(String url){
        Map<String,String> map = getResponseInfo(url);
        Map<String,Map<String,String>> resultMap = valueRelease(map);
        return resultMap.get(CONTENT_DISPOSITION).get(ATTACH_FILE_NAME);
    }

    public static Map<String,Map<String,String>> valueRelease(Map<String,String> map){
        Map<String,Map<String,String>> resultMap = new HashMap<>();
        for(Map.Entry<String,String> entry : map.entrySet()){
            String value = entry.getValue();
            Map<String,String> subMap = new HashMap<>();
            if(StringUtils.contains(value,"=")){
                String[] attachments = StringUtils.split(value,";");
                for(String str : attachments){
                    if(StringUtils.contains(str.trim(),"=")){
                        String[] values = StringUtils.split(str.trim(),"=");
                        if(values.length % 2 == 0){
                            subMap.put(values[0],values[1]);
                        }
                    }
                }
                resultMap.put(entry.getKey(),subMap);
            }
        }
        return resultMap;
    }

}
