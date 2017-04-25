package util;

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
 * @create 2017-04-08 13:48
 *  
 */
public class JDBCUtils {

    private static final String MYBATIS_CONFIG = "";

    public static SqlSession getSession(String configFile) throws IOException {
        return getSqlSessioinFactory(configFile) == null ? null : getSqlSessioinFactory(configFile).openSession();
    }


    public static SqlSessionFactory getSqlSessioinFactory(String configFile) throws IOException {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            inputStream = Resources.getResourceAsStream(configFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } finally{
                if(inputStream != null){
                    inputStream.close();
                }
        }
        return sqlSessionFactory;
    }
}
