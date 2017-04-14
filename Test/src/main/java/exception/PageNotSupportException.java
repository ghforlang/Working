package exception;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-08 17:11
 *  
 */
public class PageNotSupportException extends RuntimeException {
    private String message;

    public PageNotSupportException() {
        super();
    }

    public PageNotSupportException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public PageNotSupportException(String message) {
        super(message);
    }

    public PageNotSupportException(Throwable cause) {
        super(cause);
    }
}
