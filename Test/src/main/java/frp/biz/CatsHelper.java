package frp.biz;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;
import frp.demo2.Api;

import java.util.Collections;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 16:47
 */
public class CatsHelper {

    public interface CutestCatCallBack{
        void onCutestCatSaved(Uri uri);
        void onQueryFailed(Exception ex);
    }

    Api api;

    public void saveTheCutestCat(String query,final CutestCatCallBack callBack){
        api.queryCats(query,new Api.CatsQueryCallBack(){
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                Uri saveUri = api.store(cutest, new Api.StoreCallBack(){
                    @Override
                    public void onCatStored(Uri uri) {
                        callBack.onCutestCatSaved(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception ex) {
                        callBack.onQueryFailed(ex);
                    }
                });
            }

            @Override
            public void onError(Exception ex) {
                callBack.onQueryFailed(ex);
            }
        });
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
