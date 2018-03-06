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
 * @create on 2018/2/27 19:12
 */
public class CatsHelper4 {
    ApiWrapper3 apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query){

        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);

        AsyncJob<Cat> cutestCatAsyncJob = new AsyncJob<Cat>(){

            @Override
            public void start(CallBack<Cat> callBack) {
                catsListAsyncJob.start(new CallBack<List<Cat>>() {
                    @Override
                    public void onResult(List<Cat> result) {
                        callBack.onResult(findCutest(result));
                    }

                    @Override
                    public void onError(Exception ex) {
                        callBack.onError(ex);
                    }
                });
            }
        };

        AsyncJob<Uri> storeUriAsyncJob = new AsyncJob<Uri>() {
            @Override
            public void start(CallBack<Uri> callBack) {
                cutestCatAsyncJob.start(new CallBack<Cat>() {
                    @Override
                    public void onResult(Cat result) {
                        apiWrapper.store(result).start(new CallBack<Uri>() {
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
        return storeUriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
