package workingtest.biz.service;

import workingtest.biz.dto.RemoteBannerDTO;
import workingtest.enums.BannerEnum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-20 15:46
 *  
 */
public class RemoteBannerServiceImpl implements RemoteBannerService{
    private static List<RemoteBannerDTO> fixedBannerList = new ArrayList<RemoteBannerDTO>(9);

    @Override
    public boolean addOrUpdateBanner(RemoteBannerDTO bannerDTO) {
        if(bannerDTO == null){
            bannerDTO = new RemoteBannerDTO();
        }
        BannerEnum bannerEnumNow = bannerDTO.getBannerEnum();
        if(bannerEnumNow == null){
            bannerEnumNow = BannerEnum.getAvaliableBanner();
        }
        if(null == bannerEnumNow){
            throw new IllegalArgumentException("banner数不能超过9");
        }
        bannerDTO.setBannerEnum(bannerEnumNow);
        buildRemoteBanner(bannerDTO);
        if(fixedBannerList.size() >= 9){
            throw new IllegalArgumentException("banner数不能超过9");
        }else{
            fixedBannerList.add(bannerDTO);
        }
        return true;
    }

    public static List<RemoteBannerDTO> getFixedBannerList(){
        return fixedBannerList;
    }

    @Override
    public void batchSave(List<RemoteBannerDTO> dtoList) {
        //db实现
    }

    private void buildRemoteBanner(RemoteBannerDTO bannerDTO){
        Long id = 1L;
        bannerDTO.setIsDeleted(0);
        bannerDTO.setBannerName(bannerDTO.getBannerEnum().getDesc());
        bannerDTO.setCreateTime(Calendar.getInstance().getTime());
        bannerDTO.setCreateUserId(1L);
        bannerDTO.setModifyUserId(1L);
        bannerDTO.setModifyTime(Calendar.getInstance().getTime());
        bannerDTO.setId(id);
        bannerDTO.setPictureUrl("joajojogjoa");
        bannerDTO.setUrl("xoojogjoajojgoa");
        bannerDTO.setBannerKey(id + "xxxx");
        bannerDTO.getBannerEnum().setBannerId(id);
    }

}
