package mtc.ad.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-25 13:14
 *  
 */
public class AdDoctorDO implements Serializable {
    private Long id;
    /**
     * 医生用户Id
     */
    private Long doctorUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
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
     * 状态，上线-1，下线-0
     */
    private Integer state;
    /**
     * 关联医联体Id
     */
    private Long mtcId;
    /**
     * 排序号
     */
    private Integer sortNo;
    /**
     * 是否已删除1-是，0-否，默认未删除
     */
    private Integer isDeleted;

    public Long getDoctorUserId() {
        return doctorUserId;
    }

    public void setDoctorUserId(Long doctorUserId) {
        this.doctorUserId = doctorUserId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getMtcId() {
        return mtcId;
    }

    public void setMtcId(Long mtcId) {
        this.mtcId = mtcId;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
