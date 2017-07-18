package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-18 14:43
 *  
 */
public class JDBCtest {
    public static void main(String[] args) throws  Exception{
        String sql = " select * from user where id = 70";
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet result = null;
        try{
            long startTime = System.currentTimeMillis();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","fanwenhao","123456");

            stat = conn.prepareStatement(sql);
            result = stat.executeQuery();
            long   endTime = System.currentTimeMillis();
            System.out.println("time cost : " + (endTime - startTime) + "ms");
        }finally {
            if(result != null){
                result.close();
            }
            if(stat != null){
                stat.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
}
