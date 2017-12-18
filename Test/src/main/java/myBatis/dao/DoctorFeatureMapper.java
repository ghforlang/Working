package myBatis.dao;

import myBatis.dataobject.DoctorFeatureDO;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/18 15:46
 */
public interface DoctorFeatureMapper {

   public DoctorFeatureDO getById(Long id);
}
