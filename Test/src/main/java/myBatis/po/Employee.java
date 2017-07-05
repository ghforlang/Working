package myBatis.po;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-05 18:16
 *  
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 5355641652334210408L;

    private Integer id;
    private String empName;
    private Integer sex;
    //员工卡，一对一关联
    private EmployeeCard employeeCard;
    //项目，一对多关联
    private List<Project> projectList;


}
