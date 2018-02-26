package frp.demo1;

import frp.bean.LocationBean;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/2/24 17:10
 */
public interface Api {

    /**
     * 地址反转成经纬度
     * @param address
     * @param callBack
     */
    void getLocation(String address,LocationCallBack callBack);

    /**
     * 提交经纬度信息
     * @param bean
     * @param callBack
     */
    void submitLocation(LocationBean bean,SubmitCallBack callBack);

    interface LocationCallBack{
        void onLocationReceived(LocationBean bean);
        void onError();
    }

    interface SubmitCallBack{
        void onSubmitReceived();
        void onError();
    }

}
