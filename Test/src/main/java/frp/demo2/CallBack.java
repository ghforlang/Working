package frp.demo2;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 17:46
 */
public interface CallBack<T> {

    void onResult(T result);
    void onError(Exception ex);
}
