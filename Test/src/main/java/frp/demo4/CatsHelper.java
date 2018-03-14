package frp.demo4;

import com.sun.jndi.toolkit.url.Uri;
import frp.bean.Cat;
import rx.Observable;
import rx.functions.Func1;

import java.util.Collections;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/3/14 9:43
 */
public class CatsHelper {
    ApiWarapper apiWarapper;

    public Observable<Uri> saveTheCutestCat(String query){
        Observable<List<Cat>> catsListObservable = apiWarapper.queryCats(query);
        Observable<Cat> cutestCatObservable = catsListObservable.map(new Func1<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return CatsHelper.this.findCutest(cats);
            }
        });

        Observable<Uri> storedUriObservable = cutestCatObservable.flatMap(new Func1<Cat, Observable<? extends Uri>>() {
            @Override
            public Observable<? extends Uri> call(Cat cat) {
                return apiWarapper.store(cat);
            }
        });
        return storedUriObservable;
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
