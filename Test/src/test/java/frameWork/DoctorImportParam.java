package frameWork;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-15 11:36
 *  
 */
public class DoctorImportParam {
    /**
     * 医生用户id
     */
    private Long doctorUserId;
    /**
     * 行号
     */
    private Integer lineNum;
    /**
     * 是否已成功导入
     */
    private Boolean imported = false;
    /**
     * 导入错误信息
     */
    private String message;

    public Long getDoctorUserId() {
        return doctorUserId;
    }

    public void setDoctorUserId(Long doctorUserId) {
        this.doctorUserId = doctorUserId;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
