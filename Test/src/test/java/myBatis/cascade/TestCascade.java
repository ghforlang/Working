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
            Employee emp = employeeMapper.getEmployee(1);
            LOGGER.info(JsonUtils.toJSon(emp));
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
