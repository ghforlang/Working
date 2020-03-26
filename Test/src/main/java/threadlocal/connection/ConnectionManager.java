package threadlocal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2018/5/14 19:15
 */
public class ConnectionManager {
   private static Connection conn = null;

   public static Connection openConnection() throws SQLException {
       if(Objects.isNull(conn)){
           conn = DriverManager.getConnection("");
       }
       return conn;
   }

   public static void closeConnection() throws SQLException {
       if(Objects.nonNull(conn)){
           conn.close();
       }
   }
}
