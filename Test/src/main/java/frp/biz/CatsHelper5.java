package frp.biz;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;
import frp.demo2.ApiWrapper3;
import frp.demo2.AsyncJob;
import frp.demo2.CallBack;
import frp.demo2.Func;

import java.util.Collections;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/27 19:35
 */
public class CatsHelper5 {
    ApiWrapper3 apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query) {

        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);

        AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });


        AsyncJob<Uri> storeUriAsyncJob = cutestCatAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });

        //^^^^^^^^^^^^^^^^^^^^^^^ will not compile
        //      Incompatible types:
        //      Required: AsyncJob<Uri>
        //      Found: AsyncJob<AsyncJob<Uri>>
        return storeUriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
