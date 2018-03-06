//package frp.wrapper;
//
//import frp.AsynJob;
//import frp.demo1.Api;
//import frp.demo1.CallBack;
//import frp.demo1.impl.DefaultApi;
//import frp.bean.LocationBean;
//
///**
// * @author fanwh
// * @version v1.0
// * @decription
// * @create on 2018/2/24 17:54
// */
//public class ApiWrapper {
//
//    Api api;
//
//    public ApiWrapper() {
//        api = new DefaultApi();
//    }
//
//    public AsynJob<LocationBean> getLocation(String address){
//        return new AsynJob<LocationBean>() {
//            @Override
//            public void start(final CallBack<LocationBean> callBack) {
//                api.getLocation(address, new Api.LocationCallBack() {
//                    @Override
//                    public void onLocationReceived(LocationBean bean) {
//                        callBack.onResult(bean);
//                    }
//
//                    @Override
//                    public void onError() {
//                        callBack.onError();
//                    }
//                });
//            }
//        };
//    }
//
//    public AsynJob<Void> submitLocation(LocationBean bean){
//        return new AsynJob<Void>() {
//            @Override
//            public void start(CallBack<Void> callBack) {
//                api.submitLocation(bean, new Api.SubmitCallBack() {
//                    @Override
//                    public void onSubmitReceived() {
//                        callBack.onResult(null);
//                    }
//
//                    @Override
//                    public void onError() {
//                        callBack.onError();
//                    }
//                });
//            }
//        };
//    }
//}
