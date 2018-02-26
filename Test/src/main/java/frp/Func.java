package frp;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 11:07
 */
public interface Func<T,R> {
    R call(T t);
}
