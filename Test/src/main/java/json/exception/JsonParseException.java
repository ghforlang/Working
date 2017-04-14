package json.exception;

import java.io.IOException;

/**
 * json解析异常封装
 *
 * @author fanwh
 * @create 2017-04-01 10:08
 **/
public class JsonParseException extends IOException {
    public JsonParseException(String message) {
        super(message);
    }
}
