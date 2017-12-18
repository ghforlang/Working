package myBatis.manager;

import myBatis.dao.DoctorFeatureMapper;
import myBatis.dao.UserMapper;
import myBatis.dataobject.DoctorFeatureDO;
import myBatis.po.User;
import org.apache.ibatis.session.SqlSession;
import util.JDBCUtils;

import java.io.IOException;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/18 16:07
 */
public class DoctorFeatureManager {

    private static final String RESOURCE = "config.xml";

    public static SqlSession getSession() throws IOException {
        return JDBCUtils.getSession(RESOURCE);
    }

    public DoctorFeatureDO getById(){
        DoctorFeatureDO result = null;
        try {
            SqlSession session = getSession();
            DoctorFeatureMapper doctorFeatureMapper = session.getMapper(DoctorFeatureMapper.class);
            result =  doctorFeatureMapper.getById(4L);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
;