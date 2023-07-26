/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.MenuLeftBLL;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class InnerContent {
    public  JPanel pnl_input,pnl_tuongtac,top_content;
    public  JPanel pnl_information,pnl_contentbottom;
    
    public  JPanel pnl_contentmenu_ncc;
    
    
    public InnerContent()
    {
            top_content= new JPanel();
            top_content.setBounds(20, 20, 980, 260);
            top_content.setBackground(null);
            top_content.setLayout(null);
            Content.pnl_content.add(top_content);

            pnl_input=new JPanel();
            pnl_input.setBackground(Color.white);
            pnl_input.setOpaque(true);
            pnl_input.setLayout(null);
            pnl_input.setBounds(0, 0, 700, 260);
            top_content.add(pnl_input);
            
            pnl_tuongtac=new JPanel();
            pnl_tuongtac.setBackground(Color.white);
            pnl_tuongtac.setOpaque(true);
            pnl_tuongtac.setLayout(null);
            pnl_tuongtac.setBounds(720, 0, 260, 260);
            top_content.add(pnl_tuongtac);
            
            pnl_contentbottom=new JPanel();
            pnl_contentbottom.setBounds(20, 300, 980, 350);
            pnl_contentbottom.setBackground(null);
            pnl_contentbottom.setLayout(null);
            Content.pnl_content.add(pnl_contentbottom);
            
            pnl_information=new JPanel();
            pnl_information.setBounds(0, 0, 980, 350);
            pnl_information.setBackground(Color.white);
            pnl_information.setLayout(null);
            pnl_information.setOpaque(true);
            pnl_information.setLayout(new FlowLayout());
            pnl_contentbottom.add(pnl_information);
         if(MenuLeftBLL.flag == 1){
            new KhoaHocGUI( pnl_input,  pnl_tuongtac,  top_content,  pnl_information, pnl_contentbottom);
        }        else if(MenuLeftBLL.flag == 2){
        new GiangDayGUI( pnl_input,  pnl_tuongtac,  top_content,  pnl_information, pnl_contentbottom);
        }
        if(MenuLeftBLL.flag == 3){
        new KQKhoaHocGUI( pnl_input,  pnl_tuongtac,  top_content,  pnl_information, pnl_contentbottom);
        }
        
    }
}


