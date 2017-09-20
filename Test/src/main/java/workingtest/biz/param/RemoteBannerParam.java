package workingtest.biz.param;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-20 15:43
 *  
 */
public class RemoteBannerParam {
    /**
     * id
     */
    private Long id;
    /**
     * bannerName
     */
    private String bannerName;
    /**
     * 图片url
     */
    private String pictureUrl;
    /**
     * url
     */
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
