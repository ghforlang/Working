package picture;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 16:37
 */
public class Constants {

    //字体常量
    public static final Font TITLE_FONT = new Font("黑体",Font.BOLD,28);
    public static final Font CONTENT_FONT = new Font("宋体",Font.PLAIN,14);
    public static final Font HEAD_BODY_LINE = new Font("黑体",Font.BOLD,50);
    public static final Font BODY_LINE = new Font("黑体",Font.BOLD,30);
    public static final Font FOOTER_FONT = new Font("黑体",Font.BOLD,18);

    //处方签常量
    public static final String TITLE_COMMON = "处方药品明细单";
    public static final String PRESCRIPTION_CREATED_DATE = "处方日期: ";
    public static final String PRESCRIPTION_ORDER_NO = "处方单号: ";
    public static final String DIAGNOSIS_DOCTOR = "诊断医师: ";
    public static final String FIRST_DIGAGNOSIS = "初步诊断: ";
    public static final String SUGGESTION = "处理建议: ";
    public static final String COPYWRITTING_ONE = "您身边的健康专家";
    public static final String COPYWRITTING_TWO = "扫一扫，快速复诊";
    public static final String FOOTER_NOTE = "注: ";
    public static final String FOOTER_NOTE_CONTENT = "本明细单仅作为处方药品展示，不可作为乌镇互联网医院正式处方签使用";
    public static final String DEFAULT_SOTORE_DIR = "D:\\tools\\picture";
    public static final String USEAGE_MARK = "用法用量: ";

    //行距常量
    public static final int LINE_DISTANCE_COMMON = 20;

    //测试数据
    public static final String PICTURE_URL_TEST = "D:\\tools\\picture";
    public static final String FIRST_DIAGNOSIS_CONTENT = "上呼吸道感染，扁桃体炎症,诊断内容测试长度了简欧公司及福利解耦股睡懒觉浏览记录";
    public static final String DIAGNOSIS_DOCTOR_CONTENT = "李小青";
    public static final String SUGGESTION_CONTENT = "多喝水，注意休息骄傲是奇偶股就阿里奇偶及欧洲奇偶哦啊是奇偶高瑟吉欧机构阿俊啊啥奇偶股就奥数佛教我就偶奇偶洗剪吹哦啊欧挂失";
    public static final String PRESCRIPTION_ORDER_NO_CONTENT = "201707080012";
    public static final String APP_ONLINE_STORE_NAME = "乌镇互联网医院药诊店";
    public static final String DRUG_STORE_NAME = "老百姓大药房杭州建设一路店";
    private static final List<DrugIssue> TEST_DRUG_LIST = new ArrayList<>(3);
    static{
        DrugIssue issue1 = new DrugIssue();
        issue1.setDaliyTimes("一日一次");
        issue1.setDoctorAdvice("继用");
        issue1.setDosagePerTime(1);
        issue1.setDrugDays(7);
        issue1.setDrugStandName("阿莫西林胶囊");
        issue1.setSpecification("0.25");
        issue1.setUnit("粒");
        issue1.setUsage("口服");
        issue1.setUnitsPerBox(24);
        issue1.setTotal(2);
        issue1.setTotalUnit("盒");
        TEST_DRUG_LIST.add(issue1);

        DrugIssue issue2 = new DrugIssue();
        issue2.setDaliyTimes("一日一次");
        issue2.setDoctorAdvice("继用");
        issue2.setDosagePerTime(3);
        issue2.setDrugDays(7);
        issue2.setDrugStandName("盐酸莫西沙星片");
        issue2.setSpecification("0.3");
        issue2.setUnit("片");
        issue2.setUsage("口服");
        issue2.setUnitsPerBox(3);
        issue2.setTotal(2);
        issue2.setTotalUnit("盒");
        TEST_DRUG_LIST.add(issue2);


    }

    public static List<DrugIssue>  getDrugListTest(){
        return TEST_DRUG_LIST;
    }
}
