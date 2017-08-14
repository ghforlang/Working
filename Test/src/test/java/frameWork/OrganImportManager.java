package frameWork;

import com.sun.rowset.internal.Row;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-14 17:13
 *  
 */
public class OrganImportManager {
    public  List<OrganImportParam> batchImport(List<OrganImportParam> paramList){
        List<OrganImportParam> failList = new ArrayList<>();

        List<String> existIds = null;
        List<String> organIds = new ArrayList<>();
        if(CollectionUtils.isEmpty(paramList)){
            paramList.forEach(param ->{
                organIds.add(param.getOrganUuid());
            });
            Map<String,OrganDetailMessage> map = generateOrganByOrganIdsSearch(1,organIds);
            paramList.forEach(param ->{
                if(existIds.contains(param.getOrganUuid())){
                    param.setMessage("机构{}已存在");
                    failList.add(param);
                }
                if(map.get(param.getOrganUuid()) == null){
                    param.setMessage("机构Id{}无效，请确认后输入");
                    failList.add(param);
                }
                if(!failList.contains(param)){
                    //执行插入数据库操作
                    param.setImported(true);
                }
            });

        }
        return failList;
    }

    public Map<String, OrganDetailMessage> generateOrganByOrganIdsSearch(Integer organType, List<String> organIds){
        Map<String,OrganDetailMessage> map = new HashMap<>();

        return map;
    }

    public void generateErrorSheet(HttpServletResponse response , List<OrganImportParam> paramList) throws IOException, WriteException {
        WritableWorkbook outPutWorkbook = Workbook.createWorkbook(new File("out.xls"));

        WritableSheet sheet = outPutWorkbook.createSheet("第一页", 0);
        Label label1 = new Label(0,0,"机构类型");
        Label label2 = new Label(1,0,"机构id");
        Label label3 = new Label(2,0,"机构级别");
        Label label4 = new Label(3,0,"机构管理员账户");
        Label label5 = new Label(4,0,"机构管理员姓名");
        Label label6 = new Label(5,0,"备注");
        sheet.addCell(label1);
        sheet.addCell(label2);
        sheet.addCell(label3);
        sheet.addCell(label4);
        sheet.addCell(label5);
        sheet.addCell(label6);

        OrganImportParam param = null;
        for (int i = 0; i < paramList.size() ; i++) {
            Row row = new Row(i+1);
            param = paramList.get(i);
            row.setColumnObject(0,param.getOrganType());
            row.setColumnObject(1,param.getOrganUuid());
            row.setColumnObject(2,param.getOrganLevel());
            row.setColumnObject(3,param.getAdminAccout());
            row.setColumnObject(4,param.getAdminName());
            row.setColumnObject(5,param.getMessage());
//            sheet.insertRow(row);
        }
    }

}
