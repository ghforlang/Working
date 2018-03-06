//package frp.biz;
//
//import frp.AsynJob;
//import frp.Func;
//import frp.bean.LocationBean;
//import frp.wrapper.ApiWrapper;
//
///**
// * @author fanwh
// * @version v1.0
// * @decription
// * @create on 2018/2/24 17:12
// */
//public class LocationHelper {
//
//    private ApiWrapper api;
//    private static LocationHelper helper = new LocationHelper();
//
//    public LocationHelper() {
//        api = new ApiWrapper();
//    }
//
//    public static LocationHelper getHelper(){
//        return helper;
//    }
//
////    AsynJob<Void> commit(String address){
////        final AsynJob<LocationBean> locationJob = api.getLocation(address);
////
////        AsynJob<Void> submitJob = locationJob.map(new Func<LocationBean, AsynJob<Void>>() {
////            @Override
////            public AsynJob<Void> call(LocationBean bean) {
////                return api.submitLocation(bean);
////            }
////        });
////        return submitJob;
////        new AsynJob<Void>() {
////            @Override
////            public void start(final CallBack<Void> callBack) {
////                try{
////                    locationJob.start(new CallBack<LocationBean>() {
////                        @Override
////                        public void onResult(LocationBean result) {
////                            final AsynJob<Void> submitLocationJob = api.submitLocation(result);
////                            submitLocationJob.start(new CallBack<Void>() {
////                                @Override
////                                public void onResult(Void result) {
////                                    callBack.onResult(result);
////                                }
////
////                                @Override
////                                public void onError() {
////                                    callBack.onError();
////                                }
////                            });
////                        }
////
////                        @Override
////                        public void onError() {
////                            callBack.onError();
////                        }
////                    });
////                }catch (Exception e){
////                    e.printStackTrace();
////                }
////            }
////        };
//    }
//
////    public interface CommitCallBack{
////        void onCommitReceived();
////        void onError();
////    }
//
//
////    new Api.LocationCallBack() {
////        @Override
////        public void onLocationReceived(LocationBean bean) {
////            api.submitLocation(bean, new Api.SubmitCallBack() {
////                @Override
////                public void onSubmitReceived() {
////                    callBack.onCommitReceived();
////                    System.out.println("onSubmitReceived");
////                }
////
////                @Override
////                public void onError() {
////                    callBack.onError();
////                    System.out.println("onSubmitReceived onError");
////                }
////            });
////            System.out.println("onLocationReceived");
////        }
////
////        @Override
////        public void onError() {
////            callBack.onError();
////            System.out.println("locationCallBack onError");
////        }
////    }
//}
