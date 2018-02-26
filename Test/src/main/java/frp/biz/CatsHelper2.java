package frp.biz;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;
import frp.demo2.ApiWrapper;
import frp.demo2.CallBack;

import java.util.Collections;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 17:44
 */
public class CatsHelper2 {

    ApiWrapper apiWrapper;

    public interface CutestCatCallBack{
        void onCutestCatSaved(Uri uri);
        void onQueryFailed(Exception ex);
    }

    public void saveTheCutestCat(String query,final CallBack<Uri> uriCallBack){
        apiWrapper.queryCats(query, new CallBack<List<Cat>>() {
            @Override
            public void onResult(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                apiWrapper.store(cutest,uriCallBack);
            }

            @Override
            public void onError(Exception ex) {
                uriCallBack.onError(ex);
            }
        });
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
