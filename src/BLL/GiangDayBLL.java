/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import BLL.GiangDayDTO;
import java.util.ArrayList;
import DAL.GiangdayDAL;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author DELL
 */
public class GiangDayBLL {

    GiangdayDAL dal = new GiangdayDAL();
    GiangDayDTO gd = new GiangDayDTO();

    public void loadDataIntoComboBoxperson(JComboBox<String> comboBox, String tableName, String columnName) {
        dal.loadDataFromDatabaseIntoComboBoxperson(comboBox, tableName, columnName);
    }

    public void loadDataIntoComboBoxcourse(JComboBox<String> comboBox, String tableName, String columnName) {
        dal.loadDataFromDatabaseIntoComboBoxcourse(comboBox, tableName, columnName);
    }

    public String getcombobox_nameperson(String id) {
        return dal.getcombobox_nameperson(id);
    }

    public String getcombobox_namecoure(String id) {
        return dal.getcombobox_namecourse(id);
    }

    public List<Object[]> getData() {
        List<Object[]> data = dal.getData();
        return data;
    }
    
    public List<Object[]> search(String keyword) {
        List<Object[]> datasearch = dal.search(keyword);
        return datasearch;
    }

    public boolean addcourseinsreuctor(GiangDayDTO gd) {
        return dal.addcourseinsreuctor(gd);
    }

    public boolean updatecourseinsreuctor(GiangDayDTO gd) {
        System.out.println(gd.CourseID+""+ gd.PersonID);
        return dal.updateCourseInstructor(gd);
    }

    public boolean deletecourseinsreuctor(GiangDayDTO gd) {
        return dal.deleteCourseInstructor(gd);
    }

}

