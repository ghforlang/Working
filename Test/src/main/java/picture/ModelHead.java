package picture;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 14:45
 */
public class ModelHead {
    /**
     * 名称
     */
    private String title;
    /**
     * 品牌标志url
     */
    private String brandUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }

    @Override
    public String toString() {
        return "ModelHead[" +
                "title='" + title + '\'' +
                ", brandUrl='" + brandUrl + '\'' +
                ']';
    }
}
