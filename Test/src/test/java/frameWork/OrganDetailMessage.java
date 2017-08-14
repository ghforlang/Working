package frameWork;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-14 17:29
 *  
 */
public class OrganDetailMessage {
    private String organId;
    private String organName;
    private String organCommonLevel;
    private String createTime;
    private String cityName;

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganCommonLevel() {
        return organCommonLevel;
    }

    public void setOrganCommonLevel(String organCommonLevel) {
        this.organCommonLevel = organCommonLevel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
