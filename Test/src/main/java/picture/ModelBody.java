package picture;

import java.util.Date;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 14:56
 */
public class ModelBody {
    /**
     * 处方开具时间
     */
    private Date prescriptionCreateDate;
    /**
     * 处方单号
     */
    private String prescriptionOrderNO;
    /**
     * 诊断医师
     */
    private String doctorName;
    /**
     * 初步诊断
     */
    private String firstDiagnosis;
    /**
     * 药品信息
     */
    private List<DrugIssue> drugInfos;
    /**
     * 处理意见
     */
    private String suggestion;

    public Date getPrescriptionCreateDate() {
        return prescriptionCreateDate;
    }

    public void setPrescriptionCreateDate(Date prescriptionCreateDate) {
        this.prescriptionCreateDate = prescriptionCreateDate;
    }

    public String getPrescriptionOrderNO() {
        return prescriptionOrderNO;
    }

    public void setPrescriptionOrderNO(String prescriptionOrderNO) {
        this.prescriptionOrderNO = prescriptionOrderNO;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getFirstDiagnosis() {
        return firstDiagnosis;
    }

    public void setFirstDiagnosis(String firstDiagnosis) {
        this.firstDiagnosis = firstDiagnosis;
    }

    public List<DrugIssue> getDrugInfos() {
        return drugInfos;
    }

    public void setDrugInfos(List<DrugIssue> drugInfos) {
        this.drugInfos = drugInfos;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "ModelBody[" +
                "prescriptionCreateDate=" + prescriptionCreateDate +
                ", prescriptionOrderNO='" + prescriptionOrderNO + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", firstDiagnosis='" + firstDiagnosis + '\'' +
                ", drugInfos=" + drugInfos +
                ", suggestion='" + suggestion + '\'' +
                ']';
    }
}
