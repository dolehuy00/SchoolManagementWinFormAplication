
package BLL;

import BLL.DepartmentDTO;
import DAL.KhoaHocDAL;
import java.util.ArrayList;

public class KhoaHocBLL {
    
    public KhoaHocBLL() {
    }
    
    public String getDepartmentID(String name){
        ArrayList<DepartmentDTO> list = new KhoaHocDAL().getDepartment(); 
        for(int i=0;i<list.size();i++){
            if((list.get(i).getName()).equals(name)){   
                return list.get(i).getId();
            }  
        }
        return "";
    }
    public void updateCourse(KhoaHocDTO course, String oldType){
        if(course.getType().equals("Online") && oldType.equals("Online")){
            new KhoaHocDAL().updateOnlineCourse(course);
        }if(course.getType().equals("Onsite") && oldType.equals("Onsite")){
            new KhoaHocDAL().updateOnsiteCourse(course);
        }if(course.getType().equals("Onsite") && oldType.equals("Online")){
            new KhoaHocDAL().changeOnlineToOnsiteCourse(course);
        }if(course.getType().equals("Online") && oldType.equals("Onsite")){
            new KhoaHocDAL().changeOnsiteToOnlineCourse(course);
        }  
    }
    public String getDepartmentName(int id){
        ArrayList<DepartmentDTO> list = new KhoaHocDAL().getDepartment(); 
        for(int i=0;i<list.size();i++){
            if((list.get(i).getId()).equals(id)){   
                return list.get(i).getName();
            }  
        }
        return null;
    }
    public Object[] getListDepartmentName(){
        ArrayList<DepartmentDTO> department = new KhoaHocDAL().getDepartment();
        ArrayList<String> list = new ArrayList();
        for(int i=0;i<department.size();i++){
            list.add(department.get(i).getName());
        }
        return list.toArray();
    }
    public void addNewCourse(KhoaHocDTO course){
        if(course.getType().equals("Online")){
            new KhoaHocDAL().insertOnlineCourse(course);
        }else{
            new KhoaHocDAL().insertOnsiteCourse(course);
        }
    }
    public void deleteCourse(String id, String type){
        if (type.equals("Online")) {
            new KhoaHocDAL().deleteOnlineCourse(id);
        }else{
            new KhoaHocDAL().deleteOnsiteCourse(id);
        }
    }
    public void updateCourse(KhoaHocDTO course){
        if(course.getType().equals("Online")){
            new KhoaHocDAL().updateOnlineCourse(course);
        }else{
            new KhoaHocDAL().updateOnsiteCourse(course);
        }
    }
    public ArrayList searchCourse(String keyword){
        return new KhoaHocDAL().searchByName(keyword);
    }
    public ArrayList getAllCourse(){
        return new KhoaHocDAL().getAllCourse();
    }
    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        } 
    }


}
