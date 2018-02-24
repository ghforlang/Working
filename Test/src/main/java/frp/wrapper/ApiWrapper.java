package frp.wrapper;

import frp.api.Api;
import frp.api.CallBack;
import frp.api.impl.DefaultApi;
import frp.bean.LocationBean;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/24 17:54
 */
public class ApiWrapper {

    Api api;

    public ApiWrapper() {
        api = new DefaultApi();
    }

    public void getLocation(String address, final CallBack<LocationBean> callBack){
        api.getLocation(address, new Api.LocationCallBack() {
            @Override
            public void onLocationReceived(LocationBean bean) {
                callBack.onResult(bean);
            }

            @Override
            public void onError() {
                callBack.onError();
            }
        });
    }

    public void submitLocation(LocationBean bean,final CallBack<Void> callBack){
        api.submitLocation(bean, new Api.SubmitCallBack() {
            @Override
            public void onSubmitReceived() {
                callBack.onResult(null);
            }

            @Override
            public void onError() {
                callBack.onError();
            }
        });
    }
}
