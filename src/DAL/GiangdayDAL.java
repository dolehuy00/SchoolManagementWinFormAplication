package DAL;

import BLL.GiangDayDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class GiangdayDAL {

    GiangDayDTO gd = new GiangDayDTO();

    public void loadDataFromDatabaseIntoComboBoxperson(JComboBox<String> comboBox, String tableName, String columnName) {
        comboBox.removeAllItems();
        String query = "SELECT " + columnName + " FROM " + tableName + " WHERE EnrollmentDate IS NULL";
        try {
            Connection conn = (Connection) KetNoi.getConnection();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                comboBox.addItem(rs.getString(columnName));
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadDataFromDatabaseIntoComboBoxcourse(JComboBox<String> comboBox, String tableName, String columnName) {
        comboBox.removeAllItems();
        String query = "SELECT " + columnName + " FROM " + tableName;
        try {
            Connection conn = (Connection) KetNoi.getConnection();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                comboBox.addItem(rs.getString(columnName));
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getcombobox_nameperson(String id) {
        String fullName = null;
        String query = "SELECT LastName, FirstName FROM person WHERE PersonID = ?";
        try {
            Connection conn = (Connection) KetNoi.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                fullName = lastName + " " + firstName;
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fullName;
    }

    public String getcombobox_namecourse(String id) {
        String name = null;
        String query = "SELECT Title FROM course WHERE CourseID = ?";
        try {
            Connection conn = (Connection) KetNoi.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                name = rs.getString("Title");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return name;
    }

    public List<Object[]> getData() {
        List<Object[]> data = new ArrayList<>();

        try {
            Connection conn = KetNoi.getConnection();
            String query = "SELECT courseinstructor.CourseID, courseinstructor.PersonID, course.Title, CONCAT(person.Lastname, ' ', person.Firstname) AS person_name, \n"
                    + "       CASE WHEN onlinecourse.CourseID IS NOT NULL THEN 'X' ELSE '' END AS online, \n"
                    + "       CASE WHEN onsitecourse.CourseID IS NOT NULL THEN 'X' ELSE '' END AS onsite \n"
                    + "FROM courseinstructor\n"
                    + "JOIN course ON courseinstructor.CourseID = course.CourseID\n"
                    + "JOIN person ON courseinstructor.PersonID = person.PersonID\n"
                    + "LEFT JOIN onlinecourse ON courseinstructor.CourseID = onlinecourse.CourseID\n"
                    + "LEFT JOIN onsitecourse ON courseinstructor.CourseID = onsitecourse.CourseID\n"
                    + "WHERE courseinstructor.PersonID IS NOT NULL\n"
                    + "ORDER BY CourseID;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[6];

                row[0] = rs.getInt("CourseID");
                row[1] = rs.getString("Title");
                row[2] = rs.getInt("PersonID");
                row[3] = rs.getString("person_name");
                row[4] = rs.getString("online");
                row[5] = rs.getString("onsite");
                data.add(row);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public boolean addcourseinsreuctor(GiangDayDTO gd) {
        boolean success = false;
        try {
            Connection conn = (Connection) KetNoi.getConnection();
            Statement stmt = conn.createStatement();

            // Kiểm tra số lượng bản ghi có CourseID bằng với gd.CourseID
            String countSql = "SELECT COUNT(*) FROM courseinstructor WHERE CourseID = '" + gd.CourseID + "'";
            ResultSet countResult = stmt.executeQuery(countSql);
            countResult.next();
            int count = countResult.getInt(1);

            if (count == 0) {
                // Chèn bản ghi mới nếu CourseID chưa có PersonID nào được chọn
                String insertSql = "INSERT INTO courseinstructor (CourseID, PersonID) VALUES ('" + gd.CourseID + "', '" + gd.PersonID + "')";
                int rows = stmt.executeUpdate(insertSql);
                if (rows > 0) {
                    success = true;
                }
            } else {

                success = false;

            }

            conn.close();
        } catch (Exception ex) {
            System.out.println("");
        }
        return success;
    }

    public boolean updateCourseInstructor(GiangDayDTO gd) {
        boolean success = false;
        try {
            Connection conn = KetNoi.getConnection();
            String sql = "UPDATE courseinstructor SET PersonID = ? WHERE CourseID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, gd.PersonID);
            stmt.setInt(2, gd.CourseID);
            int rows = stmt.executeUpdate();
            conn.close();
            if (rows > 0) {
                success = true;
            }
        } catch (Exception ex) {
            System.out.println("Error updating course instructor: " + ex.getMessage());
        }
        return success;
    }

    public boolean deleteCourseInstructor(GiangDayDTO gd) {
        boolean success = false;
        try {
            Connection conn = KetNoi.getConnection();
            String sql = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, gd.CourseID);
            stmt.setInt(2, gd.PersonID);
            int rows = stmt.executeUpdate();
            conn.close();
            if (rows > 0) {
                success = true;
            }
        } catch (Exception ex) {
            System.out.println("Error deleting course instructor: " + ex.getMessage());
        }
        return success;
    }

    public List<Object[]> search(String keyword) {
        List<Object[]> data = new ArrayList<>();

        try {
            Connection conn = KetNoi.getConnection();
            String query = "SELECT ci.personid, ci.courseid, c.title, CONCAT(p.lastname, ' ', p.firstname) AS person_name, "
                    + "CASE WHEN oc.CourseID IS NOT NULL THEN 'X' ELSE '' END AS online, "
                    + "CASE WHEN sc.CourseID IS NOT NULL THEN 'X' ELSE '' END AS onsite "
                    + "FROM courseinstructor ci "
                    + "JOIN course c ON ci.courseid = c.courseid "
                    + "JOIN person p ON ci.personid = p.personid "
                    + "LEFT JOIN onlinecourse oc ON ci.courseid = oc.CourseID "
                    + "LEFT JOIN onsitecourse sc ON ci.courseid = sc.CourseID "
                    + "WHERE ci.personid = ? OR ci.courseid = ? OR c.title LIKE ? OR CONCAT(p.lastname, ' ', p.firstname) LIKE ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, keyword);
            pstmt.setString(2, keyword);
            pstmt.setString(3, "%" + keyword + "%");
            pstmt.setString(4, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[6];

                row[0] = rs.getInt("courseid");
                row[1] = rs.getString("title");
                row[2] = rs.getInt("personid");
                row[3] = rs.getString("person_name");
                row[4] = rs.getString("online");
                row[5] = rs.getString("onsite");
                data.add(row);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

}
