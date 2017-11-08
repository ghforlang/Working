package decode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/8 16:17
 */
public class TestCode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String srcStr = "%E9%AA%8C%E6%94%B6%E8%A7%86%E8%A7%89%E9%97%AE%E9%A2%98%E5%8F%8D%E9%A6%886.26.docx";
        System.out.println(srcStr);

//        srcStr = new String(srcStr.getBytes("gb2312"),"UTF-8");
        srcStr = URLDecoder.decode(srcStr,"utf-8");
        System.out.println(srcStr);
    }
}
