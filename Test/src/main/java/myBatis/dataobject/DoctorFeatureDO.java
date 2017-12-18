package myBatis.dataobject;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/18 15:47
 */
public class DoctorFeatureDO {
    private Long id;
    private String areaId;
    private String areaName;
    private Long doctorUseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getDoctorUseId() {
        return doctorUseId;
    }

    public void setDoctorUseId(Long doctorUseId) {
        this.doctorUseId = doctorUseId;
    }

    @Override
    public String toString() {
        return "DoctorFeatureDO{" +
                "id=" + id +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", doctorUseId=" + doctorUseId +
                '}';
    }
}
