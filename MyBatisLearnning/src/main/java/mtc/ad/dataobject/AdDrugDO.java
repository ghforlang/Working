package mtc.ad.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-25 11:27
 *  
 */
public class AdDrugDO implements Serializable {

    private static final long serialVersionUID = -5492780578772361450L;

    private Long id;
    /**
     * 药品编号
     */
    private String SerialNo;
    /**
     * 药品名称
     */
    private String drugName;
    /**
     * 药品通用名
     */
    private String commonName;
    /**
     * 规格
     */
    private String specification;
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
     * 创建用户Id
     */
    private Long createUserId;
    /**
     * 修改用户Id
     */
    private Long modifyUserId;
    /**
     * 排序号
     */
    private Integer sortNo;
    /**
     * 关联医联体Id
     */
    private Long mitId;

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Long getMitId() {
        return mitId;
    }

    public void setMitId(Long mitId) {
        this.mitId = mitId;
    }
}
