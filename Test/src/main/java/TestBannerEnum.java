import workingtest.enums.BannerEnum;

import java.math.BigInteger;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-15 11:06
 *  
 */
public class TestBannerEnum {
    public static void main(String[] args) {
        setEnumValues();
        BigInteger bi = BigInteger.valueOf(123);
    }

    public static void setEnumValues(){
        BannerEnum[] bannerEnums = BannerEnum.values();
        long num = 1200L;
        for(BannerEnum bannerEnum : bannerEnums){
            bannerEnum.setBannerId(num++);
        }

        for(BannerEnum bannerEnum : bannerEnums){
            System.out.println(bannerEnum);
        }
    }

}
