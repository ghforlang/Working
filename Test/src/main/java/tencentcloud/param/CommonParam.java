package tencentcloud.param;

import com.qcloud.QcloudApiModuleCenter;
import tencentcloud.constant.QCloudConstants;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/11/10 16:04
 */
public class CommonParam {
    /**
     * 具体操作的指令接口名称
     */
    private String action;
    /**
     * 区域标识，用于标识希望操作哪个区域的实例
     */
    private String region;
    /**
     * 时间戳，对应Uint类型
     */
    private Long timestamp;
    /**
     * 随机正整数，与 Timestamp 联合起来, 用于防止重放攻击
     */
    private Long nonce;
    /**
     * SECRETID
     */
    private String secretId;
    /**
     * 请求签名，用来验证此次请求的合法性，需要用户根据实际的输入参数计算得出
     */
    private String signature;
    /**
     * 签名方式，目前支持HmacSHA256和HmacSHA1
     */
    private String signatureMethod;

}
