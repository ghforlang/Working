package mtc.ad.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-24 14:10
 *  
 */
public class AdBannerDO implements Serializable{
    private static final long serialVersionUID = -4463491499543673101L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * banner名
     */
    private String bannerName;
    /**
     * 图片url
     */
    private String picture;
    /**
     * 指向URL
     */
    private String url;
    /**
     * 关联医联体id
     */
    private String mtcId;
    /**
     * 是否已删除
     */
    private boolean isDeleted;
    /**
     * 在线状态（1-上线，0-下线）
     */
    private boolean state;
    /**
     * 排序号
     */
    private Integer sortNo;

    /**
     * 创建者Id
     */
    private Long createUserId;
    /**
     * 修改用户Id
     */
    private Long modifyUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 有效期开始时间
     */
    private Date validStartTime;
    /**
     * 有效期结束时间
     */
    private Date validEndTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMtcId() {
        return mtcId;
    }

    public void setMtcId(String mtcId) {
        this.mtcId = mtcId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Date getValidStartTime() {
        return validStartTime;
    }

    public void setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }
}
