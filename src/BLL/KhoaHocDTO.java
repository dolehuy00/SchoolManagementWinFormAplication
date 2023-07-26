/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author DELL
 */
public class KhoaHocDTO {
     private String id;
    private String title;
    private String credits;
    private String department;
    private String type;
    private String url;
    private String location;
    private String day;
    private String time;

    public KhoaHocDTO() {
        
    }

    public KhoaHocDTO(String id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public KhoaHocDTO(String id, String title, String department, String credits,
        String type, String url, String location, String day, String time) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.credits = credits;
        this.type = type;
        this.url = url;
        this.location = location;
        this.day = day;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getCredits() {
        return credits;
    } 

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
