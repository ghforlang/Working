package other;

import org.apache.commons.lang.ArrayUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-30 10:37
 *  
 */
public class TestHttp {
    public static void main(String[] args) {
        String url = "http://kano.guahao-inc.com/vvX27368160?token=NWI1NDJlMGViZTVkNDVmYmU4NjEyZGMwYjFmYjUxNjRfTUQ1COUSTOM";
//        String url = "https://download.jetbrains.8686c.com/idea/ideaIU-2017.2.3.dmg";
//        String url = "https://dldir1.qq.com/qqfile/qq/QQ8.9.4/21603/QQ8.9.4.exe";
        long startTime = System.currentTimeMillis();
        try {
            long st1 = System.currentTimeMillis();
            HttpClientBuilder builder = HttpClientBuilder.create();
            System.out.println(System.currentTimeMillis() - st1);
            //发送get请求
            CloseableHttpClient client = builder.build();
            HttpGet request = new HttpGet(url);
            System.out.println(System.currentTimeMillis() - st1);
            long st2 = System.currentTimeMillis();
            HttpResponse response = client.execute(request);
            System.out.println(System.currentTimeMillis() - st2);

            long st3 = System.currentTimeMillis();
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                Header[] fileName = response.getHeaders("Content-Type");
                if(ArrayUtils.isNotEmpty(fileName)){
                    int index = fileName[0].getValue().indexOf("=");
                    System.out.println(fileName[0].getValue().substring(index + 1));
                }
            } else {
                System.out.println("get请求提交失败:" + url);
            }
            System.out.println(System.currentTimeMillis() - st3);
        } catch (IOException e) {
            System.out.println("get请求提交失败:" + url);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
