package frp.demo1;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/24 17:52
 */
public interface CallBack<T> {

    void onResult(T result);
    void onError(Exception ex);
}
