package myBatis.po;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 09:53
 *  
 */
public class MaleEmployee extends Employee {
    private List<String> prostateList;

    public List<String> getProstateList() {
        return prostateList;
    }

    public void setProstateList(List<String> prostateList) {
        this.prostateList = prostateList;
    }
}
