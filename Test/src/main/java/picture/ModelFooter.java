package picture;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 15:27
 */
public class ModelFooter {
    /**
     * 在线药诊店名称
     */
    private String appStoreOnlineName;
    /**
     * 线下药店名称
     */
    private String drugStoreName;
    /**
     * 固定文案1:您身边的健康专家
     */
    private String copyWriting1 ;
    /**
     * 二维码内容
     */
    private String qrCodeUrl;
    /**
     *扫一扫，快速复诊
     */
    private String copyWriting2;
    /**
     * 注意事项
     */
    private String note;

    public String getAppStoreOnlineName() {
        return appStoreOnlineName;
    }

    public void setAppStoreOnlineName(String appStoreOnlineName) {
        this.appStoreOnlineName = appStoreOnlineName;
    }

    public String getDrugStoreName() {
        return drugStoreName;
    }

    public void setDrugStoreName(String drugStoreName) {
        this.drugStoreName = drugStoreName;
    }

    public String getCopyWriting1() {
        return copyWriting1;
    }

    public void setCopyWriting1(String copyWriting1) {
        this.copyWriting1 = copyWriting1;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getCopyWriting2() {
        return copyWriting2;
    }

    public void setCopyWriting2(String copyWriting2) {
        this.copyWriting2 = copyWriting2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ModelFooter[" +
                "appStoreOnlineName='" + appStoreOnlineName + '\'' +
                ", drugStoreName='" + drugStoreName + '\'' +
                ", copyWriting1='" + copyWriting1 + '\'' +
                ", qrCodeUrl='" + qrCodeUrl + '\'' +
                ", copyWriting2='" + copyWriting2 + '\'' +
                ", note='" + note + '\'' +
                ']';
    }
}
