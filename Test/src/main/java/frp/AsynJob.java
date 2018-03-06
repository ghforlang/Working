//package frp;
//
//import frp.demo1.CallBack;
//
///**
// * @author fanwh
// * @version v1.0
// * @decription
// * @create on 2018/2/26 9:39
// */
//public abstract class AsynJob<T> {
//    public abstract void start(CallBack<T> callBack);
//
//    public <R> AsynJob<R> map(final Func<T,AsynJob<R>> func){
//        final AsynJob<T> source = this;
//        return new AsynJob<R>() {
//            @Override
//            public void start(final CallBack<R> callBack) {
//                source.start(new CallBack<T>(){
//
//                     @Override
//                     public void onResult(T result) {
//                         AsynJob<R> mapped = func.call(result);
//                         mapped.start(new CallBack<R>() {
//                             @Override
//                             public void onResult(R result) {
//                                callBack.onResult(result);
//                             }
//
//                             @Override
//                             public void onError() {
//                                callBack.onError();
//                             }
//                         });
//                     }
//
//                     @Override
//                     public void onError() {
//                        callBack.onError();
//                     }}
//                );
//            }
//        };
//    }
//}
