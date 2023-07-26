/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.MenuLeftBLL;
import GUI.Imgs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author DELL
 */
public class MenuLeft {
     public String [] danhmuc={"Quản lý khóa học","Quản lý giảng dạy","Quản lý KQ học"};
    public JLabel[] btn= new JLabel[danhmuc.length];
    JLabel user;
    JPanel pnl_menuleft;
    ImageIcon iconuser;
    Image ic;
    String[] danhmuc_img={
        "study_96px.png",
        "training_96px.png",
        "pass_fail_96px.png"};
    ImageIcon[] ImageIcon=new ImageIcon[danhmuc_img.length];
    Image[] Icon=new Image[danhmuc_img.length];
    

    public MenuLeft(JFrame frame)
    {
        Imgs im=new Imgs();
        MouseListener ml=new MenuLeftBLL(this);
        pnl_menuleft=new JPanel();
        pnl_menuleft.setBackground(new Color(0, 0, 60));
        pnl_menuleft.setOpaque(true);
        pnl_menuleft.setPreferredSize(new Dimension(220, 0));
        pnl_menuleft.setLayout(new FlowLayout());
        frame.add(pnl_menuleft, BorderLayout.LINE_START);
        
        iconuser=new ImageIcon(im.imgs("profile_150px.png"));
        user=new JLabel(iconuser,JLabel.CENTER);
        user.setBorder(new EmptyBorder(20, 0, 20, 0));
        pnl_menuleft.add(user);
        
        for(int i=0;i<danhmuc.length;i++)
        {
            ImageIcon[i]=new ImageIcon(im.imgs(danhmuc_img[i]));
            Icon[i]=ImageIcon[i].getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING);
            ImageIcon[i]=new ImageIcon(Icon[i]);       
            
            btn[i]=new JLabel(danhmuc[i],ImageIcon[i],JLabel.LEFT);
            btn[i].setForeground(Color.white);
            btn[i].setPreferredSize(new Dimension(220, 50));
            btn[i].setBorder(new EmptyBorder(0, 25, 0, 0));
            pnl_menuleft.add(btn[i]);
            btn[i].addMouseListener(ml);
        }
    }
}
