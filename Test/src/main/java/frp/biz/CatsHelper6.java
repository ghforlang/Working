package frp.biz;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;
import frp.demo2.ApiWrapper3;
import frp.demo2.AsyncJob;

import java.util.Collections;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/27 19:35
 */
public class CatsHelper6 {
    ApiWrapper3 apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(cats -> findCutest(cats));
        AsyncJob<Uri> storeUriAsyncJob = cutestCatAsyncJob.flatMap(cat -> apiWrapper.store(cat));
        return storeUriAsyncJob;
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
