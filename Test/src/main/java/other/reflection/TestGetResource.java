package other.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-06-28 15:46
 *  
 */
public class TestGetResource {

    public static void main(String[] args) throws IOException {
        TestGetResource getResource = new TestGetResource();
        getResource.testGetResourceAsStream();
    }

    public void testGetResourceAsStream() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println("当前类加载器：" + classLoader);

        InputStream in = classLoader.getResourceAsStream("db.properties");
        System.out.println("in：" + in);

        Properties properties = new Properties();
        properties.load(in);

        String dbDriver = properties.getProperty("driver");
        System.out.println(dbDriver);
        String url = properties.getProperty("url");
        System.out.println(url);
        String userName = properties.getProperty("username");
        //中文转码处理
        userName = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(userName);
        String passWord = properties.getProperty("password");
        System.out.println(passWord);
    }
}
