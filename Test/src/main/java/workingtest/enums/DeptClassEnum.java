package workingtest.enums;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-20 17:44
 *  
 */
public enum DeptClassEnum {
    //内科
    PHYSICIANS(1,0,"内科",1),
    CARDIOVASCULAR(1,1,"心血管内科",2),
    RESPIRATORY(1,2,"呼吸内科",3),
    DIGESTION(1,3,"消化内科",4),
    NEUROLOGY(1,4,"神经内科",5),
    HEMATOLOGY(1,5,"血液科",6),
    NEPHROLOGY(1,6,"肾内科",7),
    ONCOLOGY(1,7,"肿瘤内科",8),
    RHEUMATOLOGY(1,8,"风湿免疫科",9),
    ENDOCRINOLOGY(1,9,"内分泌科",10),
    INFECTIONDEPT(1,10,"感染科",11),
    REHABILITATION(1,11,"康复科",12),

    //外科
    SURGERY(2,0,"外科",13),
    GENERALSUGERY(2,1,"普外科",14),
    ORTHOPEDICS(2,2,"骨科",15),
    THORACICSURGERY(2,3,"胸外科",16),
    NEUROSURGERY(2,4,"神经外科",17),
    UROLOGY(2,5,"泌尿外科",18),
    PLASTICSURGERY(2,6,"整形外科",19),

    //妇儿
    GYNECOLOGYPEDIATRICSDEPT(3,0,"妇儿",21),
    GYNECOLOGY(3,0,"妇科",22),
    OBSTETRICS(3,0,"产科",23),
    PEDIATRICMEDICINE(3,0,"小儿内科",24),
    PEDIATRICSURGERY(3,0,"小儿外科",25),
    REPRODUCTOCENTRIC(3,0,"生殖中心",26),

    //全科
    GENERALPRACTICE(4,0,"全科",27),
    CLINICALTRAINING(4,1,"临床培训",28),
    GENERALTEST(4,2,"全科考试",29),
    CULTIVATIONOFGT(4,3,"全科",30),
    HUMANITIES(4,4,"人文素养",31),

    //综合医学科
    INTEGRATEDMEDICINE(5,0,"综合医学科",32),
    DERMATOLOGY(5,1,"皮肤科",33),
    STOMATOLOGY(5,2,"口腔科",34),
    OTOLARYNGOLOGY(5,3,"耳鼻喉科",35),
    OPHTHALMOLOGY(5,4,"眼科",36),
    EMERGENCY(5,5,"急诊科",37),
    PSYCHIATRY(5,6,"精神科",38);
    /**
     * 一级分类
     */
    private Integer firstStage;
    /**
     *
     */
    private Integer secondStage;
    private String desc;
    private Integer type;


    DeptClassEnum(Integer firstStage, Integer secondStage, String desc, Integer type) {
        this.firstStage = firstStage;
        this.secondStage = secondStage;
        this.desc = desc;
        this.type = type;
    }

    public static DeptClassEnum getByType(Integer typeCode){
        if(null == typeCode){
            return null;
        }
        DeptClassEnum[] values = DeptClassEnum.values();
        for(DeptClassEnum value : values){
            if(typeCode.equals(value.getType())){
                return value;
            }
        }
        return null;
    }

    public static List<DeptClassEnum> getByFirstStage(Integer firstStage){
        if(null == firstStage){
            return null;
        }
        List<DeptClassEnum> firstStageDept = new LinkedList<>();
        DeptClassEnum[] values = DeptClassEnum.values();
        for(DeptClassEnum value : values){
            if(firstStage.equals(value.getFirstStage())){
                firstStageDept.add(value);
            }
        }
        return firstStageDept;
    }

    public Integer getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(Integer firstStage) {
        this.firstStage = firstStage;
    }

    public Integer getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(Integer secondStage) {
        this.secondStage = secondStage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
