package myBatis.dao;

import myBatis.po.Employee;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 10:12
 *  
 */
public interface EmployeeMapper {
    Employee getEmployee(Integer empId);

    void update(Integer empId);
}
