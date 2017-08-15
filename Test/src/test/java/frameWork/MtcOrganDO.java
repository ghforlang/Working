package frameWork;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-15 10:11
 *  
 */
public class MtcOrganDO implements Serializable {
    private Long id;
    /**
     * 机构类型

     */
    private Integer organType;
    /**
     * 主平台机构Id
     */
    private String organId;
    /**
     * 机构级别  2-10
     */
    private Integer organLevel;
    /**
     * 关联医联体Id
     */
    private Long mtcId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 创建用户Id
     */
    private Long createUserId;
    /**
     * 修改用户Id
     */
    private Long modifyUserId;
    /**
     * 是否已删除
     */
    private Integer isDeleted;
    /**
     * 机构名称
     */
    private String organName;
    /**
     * 医院等级（如一级甲等）
     */
    private String organCommonLevel;
    /**
     * 所在城市名称
     */
    private String cityName;
    /**
     * 状态：上线，下线
     */
    private Integer state;
    /**
     * 机构编号（页面展示用）
     */
    private String organSerialNo;
    /**
     * 唯一key
     */
    private String organKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrganType() {
        return organType;
    }

    public void setOrganType(Integer organType) {
        this.organType = organType;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public Integer getOrganLevel() {
        return organLevel;
    }

    public void setOrganLevel(Integer organLevel) {
        this.organLevel = organLevel;
    }

    public Long getMtcId() {
        return mtcId;
    }

    public void setMtcId(Long mtcId) {
        this.mtcId = mtcId;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganCommonLevel() {
        return organCommonLevel;
    }

    public void setOrganCommonLevel(String organCommonLevel) {
        this.organCommonLevel = organCommonLevel;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOrganSerialNo() {
        return organSerialNo;
    }

    public void setOrganSerialNo(String organSerialNo) {
        this.organSerialNo = organSerialNo;
    }

    public String getOrganKey() {
        return organKey;
    }

    public void setOrganKey(String organKey) {
        this.organKey = organKey;
    }

    @Override
    public String toString() {
        return "MtcOrganDO{" +
                "id=" + id +
                ", organType=" + organType +
                ", organId='" + organId + '\'' +
                ", organLevel=" + organLevel +
                ", mtcId=" + mtcId +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", createUserId=" + createUserId +
                ", modifyUserId=" + modifyUserId +
                ", isDeleted=" + isDeleted +
                ", organName='" + organName + '\'' +
                ", organCommonLevel='" + organCommonLevel + '\'' +
                ", cityName='" + cityName + '\'' +
                ", state=" + state +
                ", organSerialNo='" + organSerialNo + '\'' +
                ", organKey='" + organKey + '\'' +
                '}';
    }
}
