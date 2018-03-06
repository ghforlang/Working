package frp.demo2;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/26 17:58
 */
public abstract class AsyncJob<T> {
    public abstract void start(CallBack<T> callBack);

    public <R> AsyncJob<R> map(Func<T,R> func){
        final AsyncJob<T> source = this;

        return new AsyncJob<R>() {
            @Override
            public void start(CallBack<R> callBack) {
                source.start(new CallBack<T>() {
                    @Override
                    public void onResult(T result) {
                        R mapped = func.call(result);
                        callBack.onResult(mapped);
                    }

                    @Override
                    public void onError(Exception ex) {
                        callBack.onError(ex);
                    }
                });
            }
        };
    }

    public <R> AsyncJob<R> flatMap(Func<T,AsyncJob<R>> func){
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(CallBack<R> callBack) {
                source.start(new CallBack<T>() {
                    @Override
                    public void onResult(T result) {
                        AsyncJob<R> mapped = func.call(result);
                        mapped.start(new CallBack<R>() {
                            @Override
                            public void onResult(R result) {
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


}
