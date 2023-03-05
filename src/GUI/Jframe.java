/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author DELL
 */
public class Jframe extends JFrame {
     JFrame f;
    public Jframe(){
        init();
    }
    public void init()
    {
        f=new JFrame();
        f.setSize(1240,720);
        f.setLayout(new BorderLayout(0, 0));
        new Header(f);
        new MenuLeft(f);
        new Content(f);
        f.setUndecorated(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
    }
    public void goi(){
        
    }
    public static void main(String[] args) {
        new Jframe();
    }


}
