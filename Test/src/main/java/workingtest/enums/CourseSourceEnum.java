package workingtest.enums;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-22 09:24
 *  
 */
public enum CourseSourceEnum {
    YILIN(1,"医邻网");
    private Integer sourceType;
    private String desc;

    CourseSourceEnum(Integer sourceType, String desc) {
        this.sourceType = sourceType;
        this.desc = desc;
    }

    public CourseSourceEnum getByType(Integer sourceType){
        if(null == sourceType){
            return null;
        }
        CourseSourceEnum[] sourceEnums = CourseSourceEnum.values();
        for(CourseSourceEnum source : sourceEnums){
            if(sourceType.equals(source.sourceType)){
                return source;
            }
        }
        return null;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
