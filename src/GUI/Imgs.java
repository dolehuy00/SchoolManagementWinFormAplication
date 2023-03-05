/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author DELL
 */
public class Imgs {
        public Imgs() {
       
    }
    public String imgs(String img)
    {  
        String hinh = this.getClass().getClassLoader().getResource("./img/").getPath() + img;
        return hinh;
    }
}
