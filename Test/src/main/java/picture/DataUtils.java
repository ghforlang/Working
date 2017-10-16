package picture;

import java.util.Date;
import java.util.List;

/**
 * @author fanwh
 * @version v1.0
 * @create on 2017/10/14 16:21
 */
public class DataUtils {

    public static DataModel getDataModel(){

        DataModel model = new DataModel();

        ModelHead head = new ModelHead();
        head.setBrandUrl(Constants.PICTURE_URL_TEST);
        head.setTitle(Constants.TITLE_COMMON);
        model.setHead(head);

        ModelBody body = new ModelBody();
        body.setDoctorName(Constants.DIAGNOSIS_DOCTOR_CONTENT);
        body.setFirstDiagnosis(Constants.FIRST_DIAGNOSIS_CONTENT);
        body.setPrescriptionCreateDate(new Date());
        body.setPrescriptionOrderNO(Constants.PRESCRIPTION_ORDER_NO_CONTENT);
        body.setFirstDiagnosis(Constants.FIRST_DIAGNOSIS_CONTENT);
        body.setSuggestion(Constants.SUGGESTION_CONTENT);
        body.setDrugInfos(Constants.getDrugListTest());
        model.setBody(body);

        ModelFooter footer = new ModelFooter();
        footer.setCopyWriting1(Constants.COPYWRITTING_ONE);
        footer.setCopyWriting2(Constants.COPYWRITTING_TWO);
        footer.setAppStoreOnlineName(Constants.APP_ONLINE_STORE_NAME);
        footer.setDrugStoreName(Constants.DRUG_STORE_NAME);
        footer.setQrCodeUrl("http://blog.csdn.net/qq_19707521/article/details/69568566");
        footer.setNote(Constants.FOOTER_NOTE_CONTENT);
        model.setFooter(footer);

        return model;
    }

}
