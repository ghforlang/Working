package frp.biz;

import frp.api.CallBack;
import frp.bean.LocationBean;
import frp.wrapper.ApiWrapper;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/24 17:12
 */
public class LocationHelper {

    private ApiWrapper api;
    private static LocationHelper helper = new LocationHelper();

    public LocationHelper() {
        api = new ApiWrapper();
    }

    public static LocationHelper getHelper(){
        return helper;
    }

    void commit(String address, final CallBack<Void> callBack){
        try{
            api.getLocation(address, new CallBack<LocationBean>() {
                @Override
                public void onResult(LocationBean result) {
                    api.submitLocation(result,callBack);
                }

                @Override
                public void onError() {
                    callBack.onError();
                }
            });


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public interface CommitCallBack{
        void onCommitReceived();
        void onError();
    }


//    new Api.LocationCallBack() {
//        @Override
//        public void onLocationReceived(LocationBean bean) {
//            api.submitLocation(bean, new Api.SubmitCallBack() {
//                @Override
//                public void onSubmitReceived() {
//                    callBack.onCommitReceived();
//                    System.out.println("onSubmitReceived");
//                }
//
//                @Override
//                public void onError() {
//                    callBack.onError();
//                    System.out.println("onSubmitReceived onError");
//                }
//            });
//            System.out.println("onLocationReceived");
//        }
//
//        @Override
//        public void onError() {
//            callBack.onError();
//            System.out.println("locationCallBack onError");
//        }
//    }
}
