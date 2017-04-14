package paginator.util;

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

    private static final String MYBATIS_CONFIG = "paginator/mybatis-config.xml";

    public static SqlSession getSession() throws IOException {
        return getSqlSessioinFactory() == null ? null : getSqlSessioinFactory().openSession();
    }

    public static SqlSessionFactory getSqlSessioinFactory() throws IOException {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } finally{
                if(inputStream != null){
                    inputStream.close();
                }
        }
        return sqlSessionFactory;
    }
}
