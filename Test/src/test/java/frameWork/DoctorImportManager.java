package frameWork;

import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-15 11:38
 *  
 */
public class DoctorImportManager {
    public List<DoctorImportParam> batchImport(List<DoctorImportParam> paramList,Long organId, HttpServletResponse response){
        List<DoctorImportParam> failParam = new ArrayList<>();

        List<Long> doctorIds = new ArrayList<>();
        paramList.forEach(param ->{
            doctorIds.add(param.getDoctorUserId());
        });
        List<Long> existIds = checkExists();
        if(!CollectionUtils.isEmpty(paramList)){
            paramList.forEach(param ->{
                if(existIds.contains(param.getDoctorUserId())){
                    param.setImported(false);
                    param.setMessage("该医生已存在");
                    failParam.add(param);
                }

            });
        }
        return null;
    }

    private List<Long> checkExists(){
        return null;
    }
}
