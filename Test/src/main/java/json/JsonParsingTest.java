package json;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-19 18:42
 *  
 */
public class JsonParsingTest {
    public static final String urlString = "http://news-at.zhihu.com/api/4/news/latest";

    public static void main(String[] args){
        String jsonString = new String(HttpUtil.get(urlString));
        System.out.println(jsonString);
    }
}
