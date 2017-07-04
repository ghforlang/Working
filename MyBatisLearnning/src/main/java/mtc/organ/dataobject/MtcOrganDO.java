package mtc.organ.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-25 13:39
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
    private Date ModifyTime;
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
        return ModifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        ModifyTime = modifyTime;
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
}
