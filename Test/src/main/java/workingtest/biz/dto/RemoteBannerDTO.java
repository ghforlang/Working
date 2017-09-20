package workingtest.biz.dto;

import workingtest.enums.BannerEnum;

import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-20 15:27
 *  
 */
//远程培训banner
public class RemoteBannerDTO {
    /**
     * id
     */
    private Long id;
    /**
     * key： key + code
     */
    private String bannerKey;
    /**
     * 名称
     */
    private String bannerName;
    /**
     * banner图片url
     */
    private String pictureUrl;
    /**
     * 指向url；
     */
    private String url;
    /**
     * 是否已删除
     */
    private Integer isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 创建用户id
     */
    private Long createUserId;
    /**
     * 修改用户id
     */
    private Long modifyUserId;
    /**
     * banner枚举
     */
    private BannerEnum bannerEnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerKey() {
        return bannerKey;
    }

    public void setBannerKey(String bannerKey) {
        this.bannerKey = bannerKey;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public BannerEnum getBannerEnum() {
        return bannerEnum;
    }

    public void setBannerEnum(BannerEnum bannerEnum) {
        this.bannerEnum = bannerEnum;
    }

    @Override
    public String toString() {
        return "RemoteBannerDTO[" +
                "id=" + id +
                ", bannerKey='" + bannerKey + '\'' +
                ", bannerName='" + bannerName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", url='" + url + '\'' +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", createUserId=" + createUserId +
                ", modifyUserId=" + modifyUserId +
                ", bannerEnum=" + bannerEnum +
                ']';
    }
}
