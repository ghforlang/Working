package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-04 16:50
 *  
 */
public class MyBatisUtils {
    private static final String DEFAULT_CONFIT_FILE = "config.xml";


    public static SqlSessionFactory getSqlSessioinFactory(){
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            try {
                inputStream = Resources.getResourceAsStream(DEFAULT_CONFIT_FILE);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally{
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
}
