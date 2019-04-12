//package utils;
//
//import java.sql.*;
//import java.util.ResourceBundle;
//
//public class DBUltis {
//    private static String url=null;
//    private static String user=null;
//    private static String password=null;
//    private static String driver=null;
//
//
//    public static Connection startConnect() throws Exception{
//        ResourceBundle rb = ResourceBundle.getBundle("db");
//        url=rb.getString("url");
//        user=rb.getString("user");
//        password=rb.getString("password");
//        driver=rb.getString("driver");
//
//        Class.forName("org.gjt.mm.mysql.Driver");
//        Connection connection=DriverManager.getConnection(url,user,password);
//        return connection;
//    }
//
//    public static void disConnect(Connection connection, Statement stmt, ResultSet rs){
//        if(connection!=null){
//            try{
//                connection.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//        if(stmt!=null){
//            try{
//                stmt.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//        if(rs!=null){
//            try{
//                rs.close();
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
package utils;

import java.sql.*;
import java.util.ResourceBundle;
import java.sql.Connection;

public class DBUltis {
    private static ResourceBundle rs=ResourceBundle.getBundle("db");

    private static String user="root";
//    private static String password="";
    private static String driver="com.mysql.jdbc.Driver";

    public static Connection startConnect() throws Exception{
        Class.forName(driver);
        String url=rs.getString("url");
        String password=rs.getString("password");
        Connection connection=DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static void disConnect(Connection connection, Statement stmt, ResultSet rs){
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
