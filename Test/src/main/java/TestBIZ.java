import workingtest.biz.dto.RemoteBannerDTO;
import workingtest.biz.service.RemoteBannerService;
import workingtest.biz.service.RemoteBannerServiceImpl;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-20 16:38
 *  
 */
public class TestBIZ {

    public static void main(String[] args) {
        RemoteBannerService serviceImpl = new RemoteBannerServiceImpl();
        for(int i=0;i<9;i++){
            serviceImpl.addOrUpdateBanner(null);
        }
        List<RemoteBannerDTO> dtoList = RemoteBannerServiceImpl.getFixedBannerList();
        for(RemoteBannerDTO dto : dtoList){
            System.out.println(dto);
        }
    }
}
