/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class Content {
        public static JPanel pnl_content;
    
    public Content(JFrame Frame)
    {
        pnl_content=new JPanel();
        pnl_content.setBackground(new Color(220, 220, 220));
        pnl_content.setOpaque(true);
        pnl_content.setLayout(null);
        Frame.add(pnl_content);
    }
}
