package annotation;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-08-23 13:47
 *  
 */
public enum EnumTrafficLamp {
    RED(0,"red"),GREEN(2,"green"),YELLOW(3,"yellow");

    private Integer code;
    private String color;

    EnumTrafficLamp(Integer code,String color) {
        this.color = color;
        this.code = code;
    }

    public static EnumTrafficLamp getByCode(Integer code){
        if(null == code){
            return null;
        }
        EnumTrafficLamp[] enums = EnumTrafficLamp.values();
        for(EnumTrafficLamp lamp : enums){
            if(lamp.code.equals(code)){
                return lamp;
            }
        }
        return null;
    }
}
