package workingtest.enums;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-15 10:49
 *  
 */
public enum BannerEnum {
    BANNERONE(1, "顶部 Banner-01", null),
    BANNERTWO(2, "顶部 Banner-02", null),
    BANNERTHREE(3, "顶部 Banner-03", null),
    BANNERFOUR(4, "顶部 Banner-04", null),
    ECONE(5, "精品课程-01", null),
    ECTWO(6, "精品课程-02", null),
    ECTHREE(7, "精品课程-03", null),
    ECFOUR(8, "精品课程-04", null),
    ECFIVE(9, "精品课程-05", null);

    /**
     * 类型码
     */
    private Integer typeCode;
    /**
     * banner描述
     */
    private String desc;
    private Long bannerId;

    BannerEnum(Integer typeCode, String desc, Long bannerId) {
        this.typeCode = typeCode;
        this.desc = desc;
        this.bannerId = bannerId;
    }

    public static BannerEnum getAvaliableBanner(){
        BannerEnum[] banners = BannerEnum.values();
        for(BannerEnum banner : banners){
            if(null == banner.getBannerId()){
                return banner;
            }
        }
        return null;
    }

    public static BannerEnum getByBannerId(Long bannerId){
        if(null == bannerId){
            return null;
        }
        BannerEnum[] banners = BannerEnum.values();
        for(BannerEnum banner : banners){
            if(bannerId.equals(banner.getBannerId())){
                return banner;
            }
        }
        return null;
    }

    public static BannerEnum getByTypeCode(Integer typeCode){
        if(null == typeCode){
            return null;
        }
        BannerEnum[] banners = BannerEnum.values();
        for(BannerEnum banner :  banners){
            if(typeCode.equals(banner.typeCode)){
                return banner;
            }
        }
        return null;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getBannerId() {
        return bannerId;
    }

    public void setBannerId(Long bannerId) {
        this.bannerId = bannerId;
    }

    @Override
    public String toString() {
        return "BannerEnum[" +
                "typeCode=" + typeCode +
                ", desc='" + desc + '\'' +
                ", bannerId=" + bannerId +
                ']';
    }
}
