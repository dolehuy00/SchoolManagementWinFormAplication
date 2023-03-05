/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author DELL
 */
public class Exit implements MouseListener {
    private Header d;
    public Exit(Header d)
    {
       this.d=d;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i=0;i<d.img.length;i++)
        {
            if(e.getSource().equals(d.lbl_back[1]))
            {
                System.exit(0);
            }else if(e.getSource().equals(d.lbl_back[0]))
            {
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }
    
}
