package myBatis.dao;

import myBatis.po.EmployeeCard;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 10:15
 *  
 */
public interface EmployeeCardMapper {
    EmployeeCard getEmployeeCardByEmpId(Integer id);
}
