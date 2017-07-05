package myBatis.po;

import java.io.Serializable;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-05 18:17
 *  
 */
public class EmployeeCard implements Serializable{

    private static final long serialVersionUID = 5123036774744089746L;

    private Integer empId;
    private Integer cardNo;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }
}
