package myBatis.cascade;

import myBatis.dao.EmployeeMapper;
import myBatis.po.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import util.JsonUtils;
import util.MyBatisUtils;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-06 14:12
 *  
 */
public class TestCascade {
    Logger LOGGER = Logger.getLogger(TestCascade.class);


    @Test
    public void testCascade(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            long firstTime = System.currentTimeMillis();
            Employee emp = employeeMapper.getEmployee(1);
            long secondTime = System.currentTimeMillis();
//            sqlSession.clearCache();;//可手动清理cache（达到禁用一级缓存的目的）
            System.out.println("firstTime: " + (secondTime - firstTime));
            long thirdTime = System.currentTimeMillis();
            emp = employeeMapper.getEmployee(1);
            long endTime = System.currentTimeMillis();
            System.out.println("secondTime: " + (endTime - thirdTime));
            LOGGER.info(JsonUtils.toJSon(emp));
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    @Test
    public void testCache(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSessioinFactory().openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            //使用缓存
            long firstTime = System.currentTimeMillis();
            Employee emp = employeeMapper.getEmployee(1);
            long secondTime = System.currentTimeMillis();
            System.out.println("firstTime: " + (secondTime - firstTime));
            employeeMapper.update(emp.getId());
            long thirdTime = System.currentTimeMillis();
            emp = employeeMapper.getEmployee(1);
            long endTime = System.currentTimeMillis();
            System.out.println("secondTime: " + (endTime - thirdTime));
            LOGGER.info(JsonUtils.toJSon(emp));
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
