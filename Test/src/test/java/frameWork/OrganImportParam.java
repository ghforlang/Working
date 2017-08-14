package frameWork;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-14 17:08
 *  
 */
public class OrganImportParam {
    /**
     * 机构类型
     */
    private Integer organType;
    /**
     * 机构uuid（主平台一致）
     */
    private String organUuid;
    /**
     * 机构级别
     */
    private Integer organLevel;
    /**
     * 管理员账户
     */
    private String adminAccout;
    /**
     * 管理员姓名
     */
    private String adminName;
    /**
     * 行号
     */
    private Integer lineNum;
    /**
     * 是否已成功导入
     */
    private Boolean imported = false;

    private String message;
    public Integer getOrganType() {
        return organType;
    }

    public void setOrganType(Integer organType) {
        this.organType = organType;
    }

    public String getOrganUuid() {
        return organUuid;
    }

    public void setOrganUuid(String organUuid) {
        this.organUuid = organUuid;
    }

    public Integer getOrganLevel() {
        return organLevel;
    }

    public void setOrganLevel(Integer organLevel) {
        this.organLevel = organLevel;
    }

    public String getAdminAccout() {
        return adminAccout;
    }

    public void setAdminAccout(String adminAccout) {
        this.adminAccout = adminAccout;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
