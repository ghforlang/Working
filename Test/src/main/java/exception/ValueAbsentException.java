package exception;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-10 13:58
 *  
 */
public class ValueAbsentException extends Throwable {
    public ValueAbsentException() {
        super();
    }

    public ValueAbsentException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "No value present in the Optional instance";
    }
}
