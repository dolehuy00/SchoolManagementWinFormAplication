
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoi {
        private static String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
  

    public static ResultSet queryData(String query) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {

        }
        return null;
    }
    
     public static void addData(String table,String value) {
        try {
            Connection conn=getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO "+ table+" VALUES ("+value+")");
            // get data from table 'student'
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
     public static void deleteData(String table, String idsp)
    {
          try {
              Connection conn=getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM "+ table+" WHERE "+idsp);
            // get data from table 'student'
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void update(String table, String value, String id)
    {
        try {
            Connection conn=getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE "+ table+" SET "+value+" WHERE "+ id+ "");
            // get data from table 'student'
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

 
    public static ResultSet search(String key)
    {
        try {
            Connection conn=getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(key); 
            return rs;    
        } catch (Exception e) {
            e.printStackTrace();
        }
          return null;
    }
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
        public static java.sql.Connection getConnection1() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/school";
    String username = "root";
    String password = "";
    java.sql.Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
}
}
