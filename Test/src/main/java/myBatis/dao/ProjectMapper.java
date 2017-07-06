package myBatis.dao;

import myBatis.po.Project;

import java.util.List;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 10:22
 *  
 */
public interface ProjectMapper {
    List<Project> findProjectByEmpId(Integer empId);
}
