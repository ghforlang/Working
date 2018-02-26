package frp.demo2;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;

import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 17:47
 */
public class ApiWrapper {

    Api api;

    public void queryCats(String query, CallBack<List<Cat>> catsCallBack){
        api.queryCats(query,new Api.CatsQueryCallBack(){
            @Override
            public void onCatListReceived(List<Cat> cats) {
                catsCallBack.onResult(cats);
            }

            @Override
            public void onError(Exception ex) {
                catsCallBack.onError(ex);
            }
        });
    }

    public void store(Cat cat,CallBack<Uri> uriCallBack){
        api.store(cat,new Api.StoreCallBack(){
            @Override
            public void onCatStored(Uri uri) {
                uriCallBack.onResult(uri);
            }

            @Override
            public void onStoreFailed(Exception ex) {
                uriCallBack.onError(ex);
            }
        });
    }
}
