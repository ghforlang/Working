package frp.demo4;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;
import frp.demo2.Api;
import rx.Observable;
import rx.Subscriber;

import java.net.URI;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/3/13 11:10
 */
public class ApiWarapper {
    Api api;

    public Observable<List<Cat>> queryCats(final String query){
        return Observable.unsafeCreate(new Observable.OnSubscribe<List<Cat>>() {
            @Override
            public void call(Subscriber<? super List<Cat>> subscriber) {
                api.queryCats(query,new Api.CatsQueryCallBack(){

                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        subscriber.onNext(cats);
                    }

                    @Override
                    public void onError(Exception ex) {
                        subscriber.onError(ex);
                    }
                });
            }
        });
    }

    public Observable<Uri> store(final Cat cat){
        return Observable.unsafeCreate(new Observable.OnSubscribe<Uri>() {
            @Override
            public void call(Subscriber<? super Uri> subscriber) {
                api.store(cat,new Api.StoreCallBack(){

                    @Override
                    public void onCatStored(Uri uri) {
                        subscriber.onNext(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception ex) {
                        subscriber.onError(ex);
                    }
                });
            }
        });
    }
}
