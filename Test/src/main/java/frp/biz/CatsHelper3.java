package frp.biz;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;
import frp.demo2.ApiWrapper3;
import frp.demo2.AsyncJob;
import frp.demo2.CallBack;

import java.util.Collections;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 18:01
 */
public class CatsHelper3 {
    ApiWrapper3 apiWrapper;



    public AsyncJob<Uri> saveTheCutestCat(String query){
        return new AsyncJob<Uri>() {
            @Override
            public void start(CallBack<Uri> callBack) {
                apiWrapper.queryCats(query).start(new CallBack<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        Cat cutest = findCutest(result);
                        apiWrapper.store(cutest).start(new CallBack<Uri>() {
                            @Override
                            public void onResult(Uri result) {
                                callBack.onResult(result);
                            }

                            @Override
                            public void onError(Exception ex) {
                                callBack.onError(ex);
                            }
                        });
                    }

                    @Override
                    public void onError(Exception ex) {
                        callBack.onError(ex);
                    }
                });
            }
        };
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
