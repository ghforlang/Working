package workingtest.biz.service;

import workingtest.biz.dto.RemoteBannerDTO;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-20 15:40
 *  
 */
public interface RemoteBannerService {
    public boolean addOrUpdateBanner(RemoteBannerDTO bannerDTO);

    public void batchSave(List<RemoteBannerDTO> dtoList);
}
