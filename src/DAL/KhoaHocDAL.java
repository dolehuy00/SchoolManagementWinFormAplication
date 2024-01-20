package DAL;

import BLL.DepartmentDTO;
import BLL.KhoaHocDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhoaHocDAL extends KetNoi{

    public ArrayList getAllCourse(){
        try {
            ArrayList<KhoaHocDTO> list = new ArrayList<>();
            String query = "SELECT course.CourseID, course.Title, course.Credits,"
                + " course.DepartmentID, department.Name, onlinecourse.url,"
                + " onsitecourse.Location, onsitecourse.Days, onsitecourse.Time\n" +
                "FROM course\n" +
                "LEFT JOIN department ON course.DepartmentID = department.DepartmentID\n" +
                "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n" +
                "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID";
            ResultSet rs = KetNoi.queryData(query);
            while(rs.next()){
                KhoaHocDTO course = new KhoaHocDTO();
                course.setId(rs.getString("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getString("Credits"));
                course.setDepartment(rs.getString("Name"));
                if(rs.getString("url") == null){
                    course.setType("Onsite");
                    course.setLocation(rs.getString("Location"));
                    course.setDay(rs.getString("Days"));
                    course.setTime(rs.getString("Time"));
                    
                }else{
                    course.setType("Online");
                    course.setUrl(rs.getString("url"));
                }
                list.add(course);
            }
            rs.close();
            return list;
        }catch (SQLException e1){
            System.out.println(e1);
        }
        return null;
    }
    public void changeOnsiteToOnlineCourse(KhoaHocDTO course){
        String value ="`Title` = '"+course.getTitle()+"', `Credits` = '"+course.getCredits()+
        "', `DepartmentID` = '"+course.getDepartment()+"'";
        KetNoi.deleteData("onsitecourse", "onsitecourse.CourseID = "+course.getId());
        KetNoi.update("course", value, "course.CourseID = "+course.getId());
        KetNoi.addData("onlinecourse", "'"+course.getId()+"','"+course.getUrl()+"'");
    }
    public void changeOnlineToOnsiteCourse(KhoaHocDTO course){
        String value ="`Title` = '"+course.getTitle()+"', `Credits` = '"+course.getCredits()+
        "', `DepartmentID` = '"+course.getDepartment()+"'";
        KetNoi.deleteData("onlinecourse", "onlinecourse.CourseID = "+course.getId());
        KetNoi.update("course", value, "course.CourseID = "+course.getId());
        KetNoi.addData("onsitecourse", "'"+course.getId()+"','"+course.getLocation()
            +"','"+course.getDay()+"','"+course.getTime()+"'");
    }
    public ArrayList searchByName(String keyword){
        try {
            String query = "SELECT course.CourseID, course.Title, course.Credits,"
                + " department.Name, onlinecourse.url,"
                + " onsitecourse.Location, onsitecourse.Days, onsitecourse.Time\n" +
                "FROM course \n" +
                "LEFT JOIN department ON course.DepartmentID = department.DepartmentID\n" +
                "LEFT JOIN onlinecourse ON course.CourseID = onlinecourse.CourseID\n" +
                "LEFT JOIN onsitecourse ON course.CourseID = onsitecourse.CourseID\n" +
                "WHERE course.Title LIKE '%"+keyword+"%' OR course.CourseID LIKE '%"+keyword+"%'";
            ResultSet rs = KetNoi.queryData(query);
            ArrayList<KhoaHocDTO> list = new ArrayList<>();
            while(rs.next()){
                KhoaHocDTO course = new KhoaHocDTO();
                course.setId(rs.getString("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getString("Credits"));
                course.setDepartment(rs.getString("Name"));
                if(rs.getString("url") == null){
                    course.setType("Onsite");
                    course.setLocation(rs.getString("Location"));
                    course.setDay(rs.getString("Days"));
                    course.setTime(rs.getString("Time"));
                    
                }else{
                    course.setType("Online");
                    course.setUrl(rs.getString("url"));
                }
                list.add(course);
            }
            rs.close();
            return list;
        }catch (SQLException e1){
            System.out.println(e1);
        }
        return null;
    }
    public ArrayList getDepartment(){
        try {
            String query = "SELECT DepartmentID, Name FROM department";
            ResultSet rs = KetNoi.queryData(query);
            ArrayList<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
            while(rs.next()){
                list.add(new DepartmentDTO(rs.getString("DepartmentID"), rs.getString("Name")));
            }
            rs.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KhoaHocDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void deleteOnlineCourse(String idKH){
        KetNoi.deleteData("onlinecourse", "onlinecourse.CourseID = "+idKH);
        KetNoi.deleteData("course", "course.CourseID = "+idKH);
    }
    public void deleteOnsiteCourse(String idKH){
        KetNoi.deleteData("onsitecourse", "onsitecourse.CourseID = "+idKH);
        KetNoi.deleteData("course", "course.CourseID = "+idKH);
    }
    public void insertOnlineCourse(KhoaHocDTO course){
        String value ="'"+course.getId()+"','"+course.getTitle()+"','"
            +course.getCredits()+"','"+course.getDepartment()+"'";
        KetNoi.addData("course", value);
        KetNoi.addData("onlinecourse", "'"+course.getId()+"','"+course.getUrl()+"'");
    }
    public void insertOnsiteCourse(KhoaHocDTO course){
        String value ="'"+course.getId()+"','"+course.getTitle()+"','"+
        course.getCredits()+"','"+course.getDepartment()+"'";
        KetNoi.addData("course", value);
        KetNoi.addData("onsitecourse", "'"+course.getId()+"','"+course.getLocation()
            +"','"+course.getDay()+"','"+course.getTime()+"'");
    }
    public void updateOnlineCourse(KhoaHocDTO course){
        String value ="`Title` = '"+course.getTitle()+"', `Credits` = '"+course.getCredits()+
        "', `DepartmentID` = '"+course.getDepartment()+"'";
        KetNoi.update("onlinecourse", "`url` = '"+course.getUrl()+"'", "onlinecourse.CourseID = "+course.getId());
        KetNoi.update("course", value, "course.CourseID = "+course.getId());
    }
    public void updateOnsiteCourse(KhoaHocDTO course){
        String value ="`Title` = '"+course.getTitle()+"', `Credits` = '"+course.getCredits()+
        "', `DepartmentID` = '"+course.getDepartment()+"'";
        KetNoi.update("onsitecourse", "`Location` = '"+course.getLocation()+"', `Days` = '"+
            course.getDay()+"', `Time` = '"+course.getTime()+"'", "onsitecourse.CourseID = "+course.getId());
        KetNoi.update("course", value, "course.CourseID = "+course.getId());
    }
}
