package main.java.common.enums;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-09-07 11:19
 *  
 */
public enum SubDeptInfoEnum {
    ;

    private Integer code;
    private String desc;

    public static SubDeptInfoEnum getByCode(Integer code){
        if(null == code){
            return null;
        }
        SubDeptInfoEnum[] subEnums = SubDeptInfoEnum.values();
        for(SubDeptInfoEnum subEnum : subEnums){
            if(code.equals(subEnum.code)){
                return subEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
