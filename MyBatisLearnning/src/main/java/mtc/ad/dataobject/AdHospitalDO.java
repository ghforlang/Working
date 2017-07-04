package mtc.ad.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-24 14:21
 *  
 */
public class AdHospitalDO implements Serializable{
    private static final long serialVersionUID = 70231280632187278L;
    /**
     * 自增id
     */
    private Long id;
    /**
     * 医院编号
     */
    private String hospitalId;
    /**
     * 状态 1-在线，0下线
     */
    private Integer state;
    /**
     * 是否已删除
     */
    private Integer isDeleted;
    /**
     * 关联医联体Id
     */
    private Long mtcId;
    /**
     * 排序号
     */
    private Integer sortNo;
    /**
     * 创建者Id
     */
    private Long createUserId;
    /**
     * 修改者Id
     */
    private Long modifyUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date modifyTime;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
