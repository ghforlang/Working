package json;


import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-19 19:08
 *  
 */
public class HttpUtil {
    public static byte[] get(String urlString){
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(3000);

            int responseCode = urlConnection.getResponseCode();
            if(responseCode == 200){
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                InputStream in = urlConnection.getInputStream();
                byte[] buffer = new byte[4*1024];
                int len = -1;
                while ((len = in.read(buffer)) != -1){
                    bos.write(buffer,0,len);
                }
                close(in);
                byte[] result = bos.toByteArray();
                close(bos);
                return result;
            }else{
                return null;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
        return null;
    }

    private static void close(Closeable stream){
        if(stream != null){
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
