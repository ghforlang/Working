package myBatis.po;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 09:55
 *  
 */
public class FemaleEmployee extends Employee implements Serializable {

    private static final long serialVersionUID = -5363828665184444292L;

    private List<String> uterusList;

    public List<String> getUterusList() {
        return uterusList;
    }

    public void setUterusList(List<String> uterusList) {
        this.uterusList = uterusList;
    }
}
