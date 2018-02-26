package frp.demo2;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;

import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 16:43
 */
public interface Api {

    interface CatsQueryCallBack{
        void onCatListReceived(List<Cat> cats);
        void onError(Exception ex);
    }

    interface StoreCallBack{
        void onCatStored(Uri uri);
        void onStoreFailed(Exception ex);
    }

    void queryCats(String query,CatsQueryCallBack callBack);
    Uri store(Cat cat,StoreCallBack callBack);
}
