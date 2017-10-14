package workingtest.api;

import workingtest.api.param.QueryBannerListParam;
import workingtest.biz.dto.RemoteBannerDTO;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-22 14:19
 *  
 */
public interface MtcOperationService {
    List<RemoteBannerDTO> getRemoteBanners(QueryBannerListParam param);

}
