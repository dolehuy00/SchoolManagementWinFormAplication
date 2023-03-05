/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import BLL.KhoaHocDTO;
import BLL.HocSinhDTO;
import DAL.KetNoi;
import BLL.KQKhoaHocDTO;
import static DAL.KetNoi.getConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import GUI.KQKhoaHocGUI;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class KQKhoaHocDAL {
    KQKhoaHocGUI kqkh;
            private static String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public KQKhoaHocDAL() {
    }

    public KQKhoaHocDAL(KQKhoaHocGUI kqkh) {
        this.kqkh = kqkh;
    }
        public int idkh(){
        int idkh=0;
        ResultSet rs = KetNoi.queryData("SELECT EnrollmentID FROM studentgrade");
        try {
            while (rs.next()) {
                idkh=Integer.parseInt(rs.getString(1));
            }         
        } catch (SQLException e) {
//            Logger.getLogger(mls_nhanvien.class.getName()).log(Level.SEVERE, null, e);
        }
        return idkh+1;
    }
    
     public static ArrayList<KQKhoaHocDTO> table_nv() {
        ArrayList<KQKhoaHocDTO> kqs = new ArrayList<KQKhoaHocDTO>();
        String query = "SELECT studentgrade.EnrollmentID as id,course.Title as courseName,person.Lastname as studentName,studentgrade.Grade as grade,department.Name as department FROM studentgrade,department,course,person WHERE studentgrade.CourseID = course.CourseID AND studentgrade.StudentID = person.PersonID AND course.DepartmentID = department.DepartmentID ORDER BY id";
        ResultSet rs = KetNoi.queryData(query);
        try {
            while (rs.next()) {
                KQKhoaHocDTO nhanviens = new KQKhoaHocDTO(rs.getString(1) + "", rs.getString(2), rs.getString(3) + "", rs.getString(4) + "",rs.getString(5) + "");
                kqs.add(nhanviens);
                }
                
            
            
        } catch (Exception e) {

        }
        return kqs;
    }
     
        public static ArrayList<HocSinhDTO> table_cbbHS() 
    {
        ArrayList<HocSinhDTO> kqhs = new ArrayList<HocSinhDTO>();
        String query = "SELECT * FROM person WHERE HireDate IS NULL";
        ResultSet rs = KetNoi.queryData(query);
        try {
            while (rs.next()) {
                HocSinhDTO kqkhHS = new HocSinhDTO(rs.getString(1) + "", rs.getString(2)  , rs.getString(3) + "", rs.getString(4) + "",rs.getString(5) + "");
                String id = rs.getString("PersonID");
                String name = rs.getString("Lastname");
                kqhs.add(kqkhHS);
                }
        } catch (Exception e) {

    }
        return kqhs;
    }
        
            public static ArrayList<KhoaHocDTO> table_cbbKH() 
    {
        ArrayList<KhoaHocDTO> kqkh = new ArrayList<KhoaHocDTO>();
        String query = "SELECT CourseID,Title FROM course";
        ResultSet rs = KetNoi.queryData(query);
        try {
            while (rs.next()) {
                KhoaHocDTO kqkhHS = new KhoaHocDTO(rs.getString(1) + "", rs.getString(2)+ "");
                kqkh.add(kqkhHS);
                }
        } catch (Exception e) {

    }
        return kqkh;
    }
        
   public void addKQKH(KQKhoaHocDTO KQKH) {
        try {
            Connection conn=getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `studentgrade`(`EnrollmentID`, `CourseID`, `StudentID`, `Grade`) VALUES ('"+KQKH.getId()+"','"+KQKH.getNameCourse()+"','"+KQKH.getNameStudent()+"','"+KQKH.getGrade()+"')");
            // get data from table 'student'
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
   
   public void deleteKQKH(KQKhoaHocDTO KQKH){
       try {
            Connection conn=getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            stmt.execute("DELETE FROM `studentgrade` WHERE `EnrollmentID`='"+KQKH.getId()+"'");
            // get data from table 'student'
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
   
    public void editKQKH(KQKhoaHocDTO KQKH) {
        try {
            Connection conn=getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `studentgrade` SET `EnrollmentID`='"+KQKH.getId()+"',`CourseID`='"+KQKH.getNameCourse()+"',`StudentID`='"+KQKH.getNameStudent()+"',`Grade`='"+KQKH.getGrade()+"' WHERE `EnrollmentID`='"+KQKH.getId()+"'");
            // get data from table 'student'
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
}
        
    

