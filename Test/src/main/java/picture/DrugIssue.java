package picture;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 15:02
 */
public class DrugIssue {
    /**
     * 标准药品名
     */
    private String drugStandName;
    /**
     * 单位药品规格（单位g）
     */
    private String specification;
    /**
     * 盒装、袋装unit数
     */
    private Integer unitsPerBox;
    /**
     * 规格单位（片、颗、粒）
     */
    private String unit;
    /**
     * 医嘱（继用、孕妇忌用、儿童忌用）
     */
    private String doctorAdvice;
    /**
     * 用法（口服、注射）
     */
    private String usage;
    /**
     * 日服次数
     */
    private String daliyTimes;
    /**
     * 每次用量
     */
    private Integer dosagePerTime;
    /**
     * 服用天数
     */
    private Integer drugDays;
    /**
     * 药品总量
     */
    private Integer total;
    /**
     * 药品总量单位（盒，袋）
     */
    private String totalUnit;

    public String getDrugStandName() {
        return drugStandName;
    }

    public void setDrugStandName(String drugStandName) {
        this.drugStandName = drugStandName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getUnitsPerBox() {
        return unitsPerBox;
    }

    public void setUnitsPerBox(Integer unitsPerBox) {
        this.unitsPerBox = unitsPerBox;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDaliyTimes() {
        return daliyTimes;
    }

    public void setDaliyTimes(String daliyTimes) {
        this.daliyTimes = daliyTimes;
    }

    public Integer getDosagePerTime() {
        return dosagePerTime;
    }

    public void setDosagePerTime(Integer dosagePerTime) {
        this.dosagePerTime = dosagePerTime;
    }

    public Integer getDrugDays() {
        return drugDays;
    }

    public void setDrugDays(Integer drugDays) {
        this.drugDays = drugDays;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTotalUnit() {
        return totalUnit;
    }

    public void setTotalUnit(String totalUnit) {
        this.totalUnit = totalUnit;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }
}
