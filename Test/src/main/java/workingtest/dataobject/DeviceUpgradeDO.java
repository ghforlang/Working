package workingtest.dataobject;

import java.util.Date;

/**
 * @author fanwh
 * @version v1.0
 * @decription 移动设备信息表
 * @create on 2017/12/9 11:04
 */
public class DeviceUpgradeDO {
    /**
     * 唯一id
     */
    private Long id;
    /**
     * 随机码
     */
    private String authCode;

    //用户信息
    private Long userId;
    /**
     * 登陆ip
     */
    private String ip;
    /**
     * 登陆ip所属地址
     */
    private String localAddress;
    /**
     * 下载url
     */
    private String downUrl;
    /**
     * 应用版本
     */
    private String appVersion;
    /**
     * 操作结果类型（0-升级成功，1-下载失败，2-安装失败）
     */
    private Integer optResult;
    /**
     * 操作结果描述
     */
    private String optResultDesc;


    //设备信息
    /**
     * appId
     */
    private String appId;
    /**
     * 设备来源: iphone、android
     */
    private String deviceOS;
    /**
     * 设备型号
     */
    private String deviceModel;
    /**
     * 网络状况：4G、WIFI
     */
    private String netWork;
    /**
     * 设备唯一标识
     */
    private String osTokenId;
    /**
     * 上一次更新时间
     */
    private Date lastOptTime;
    /**
     * 是否已删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date gmtCreated;
    /**
     * 修改时间
     */
    private Date gmtModified;
}
