package frp.demo2;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;

import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 17:59
 */
public class ApiWrapper3 {
    Api api;

    public AsyncJob<List<Cat>> queryCats(String query){
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(CallBack<List<Cat>> callBack) {
                api.queryCats(query,new Api.CatsQueryCallBack(){
                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        callBack.onResult(cats);
                    }

                    @Override
                    public void onError(Exception ex) {
                        callBack.onError(ex);
                    }
                });
            }
        };
    }

    public AsyncJob<Uri> store(Cat cat){
        return new AsyncJob<Uri>() {
            @Override
            public void start(CallBack<Uri> callBack) {
                api.store(cat,new Api.StoreCallBack(){

                    @Override
                    public void onCatStored(Uri uri) {
                        callBack.onResult(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception ex) {
                        callBack.onError(ex);
                    }
                });
            }
        };

    }
}
