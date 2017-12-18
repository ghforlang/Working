package myBatis.service;

import myBatis.dataobject.DoctorFeatureDO;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/18 16:11
 */
public interface DoctorFeatureService {
    DoctorFeatureDO getById(Long id);
}
