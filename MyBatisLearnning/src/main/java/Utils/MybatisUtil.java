package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-19 10:12
 *  
 */
public class MybatisUtil {
    private static final String resourceLoc = "mybatis-config.xml";

    private static SqlSessionFactory createSqlSessionFactory(){
        InputStream inputStream = null;
        SqlSessionFactory  sqlSessionFactory = null;
        try {
            inputStream = Resources.getResourceAsStream(resourceLoc);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession(){
        SqlSession sqlSession = null;
        SqlSessionFactory sessionFactory = createSqlSessionFactory();
        if(sessionFactory != null){
            sqlSession = sessionFactory.openSession();
        }
        return sqlSession;
    }
}
