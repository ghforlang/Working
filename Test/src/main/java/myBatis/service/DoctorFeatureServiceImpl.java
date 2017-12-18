package myBatis.service;

import myBatis.dataobject.DoctorFeatureDO;
import myBatis.manager.DoctorFeatureManager;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/18 16:11
 */
public class DoctorFeatureServiceImpl implements DoctorFeatureService {

    private static DoctorFeatureManager doctorFeatureManager = new DoctorFeatureManager();

    public static void main(String[] args){
        DoctorFeatureDO result = doctorFeatureManager.getById();

        if(result == null){
            System.out.println("result = null");
        }else{
            System.out.println(result);
        }
    }

    @Override
    public DoctorFeatureDO getById(Long id) {
        return null;
    }
}
