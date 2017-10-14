package workingtest.enums;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-15 10:49
 *  
 */
public enum BannerEnum {
    BANNERONE(1, "顶部 Banner-01", null,1),
    BANNERTWO(2, "顶部 Banner-02", null,1),
    BANNERTHREE(3, "顶部 Banner-03", null,1),
    BANNERFOUR(4, "顶部 Banner-04", null,1),
    ECONE(5, "精品课程-01", null,2),
    ECTWO(6, "精品课程-02", null,2),
    ECTHREE(7, "精品课程-03", null,2),
    ECFOUR(8, "精品课程-04", null,2),
    ECFIVE(9, "精品课程-05", null,2);

    /**
     * code
     */
    private Integer code;
    /**
     * banner描述
     */
    private String desc;
    /**
     * bannerId
     */
    private Long bannerId;
    /**
     * 类型
     */
    private Integer type;

    BannerEnum(Integer code, String desc, Long bannerId, Integer type) {
        this.code = code;
        this.desc = desc;
        this.bannerId = bannerId;
        this.type = type;
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

    public static List<BannerEnum> getByType(Integer type){
        if(null == type){
            return null;
        }
        BannerEnum[] values = BannerEnum.values();
        List<BannerEnum> bannerEnums = new LinkedList<>();
        for(BannerEnum value : values){
            if(type.equals(value.type)){
                bannerEnums.add(value);
            }
        }
        return bannerEnums;
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

    public static BannerEnum getByCode(Integer typeCode){
        if(null == typeCode){
            return null;
        }
        BannerEnum[] banners = BannerEnum.values();
        for(BannerEnum banner :  banners){
            if(typeCode.equals(banner.code)){
                return banner;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

}
