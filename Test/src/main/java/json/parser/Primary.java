package json.parser;

/**
 * Primary Discription
 *
 * @author fanwh
 * @create 2017-04-01 17:42
 **/
public class Primary implements Json,Value {

    private String value;

    public Primary(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString(){
        return  value;
    }

    @Override
    public Object value() {
        return value;
    }
}
