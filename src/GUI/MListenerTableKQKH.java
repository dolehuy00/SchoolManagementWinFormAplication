/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.KhoaHocDTO;
import BLL.HocSinhDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MListenerTableKQKH extends MouseAdapter {
    KQKhoaHocGUI kqkh;

    public MListenerTableKQKH(KQKhoaHocGUI kqkh) {
        this.kqkh = kqkh;
    }
    
     @Override
                public void mouseClicked(MouseEvent e)
                {
                    String idkqkh=(String) kqkh.tbl_kqkh.getModel().getValueAt(kqkh.tbl_kqkh.getSelectedRow(),0);
                    String student=(String) kqkh.tbl_kqkh.getModel().getValueAt(kqkh.tbl_kqkh.getSelectedRow(),1);
                    String course=(String) kqkh.tbl_kqkh.getModel().getValueAt(kqkh.tbl_kqkh.getSelectedRow(),2);
                    String grade=(String) kqkh.tbl_kqkh.getModel().getValueAt(kqkh.tbl_kqkh.getSelectedRow(),3);
                    String department=(String) kqkh.tbl_kqkh.getModel().getValueAt(kqkh.tbl_kqkh.getSelectedRow(),4);

                     kqkh.ds_cbb_kqkh[0].setSelectedItem(student);
                     kqkh.ds_input_kh[0].setText(grade);
                     kqkh.ds_input_kh[1].setText(department);
                     
                     
                    for (KhoaHocDTO item : kqkh.cbbkqkhKH) {
                         String idkh = item.getId();
                            String namekh = item.getTitle();
                        kqkh.ds_cbb_kqkh[1].addItem(idkh + "-" + namekh);
                            if (namekh.equals(course)) {
                            kqkh.ds_cbb_kqkh[1].setSelectedItem(idkh + "-" + namekh);
                             }
                        }
                    kqkh.lbl_idkh.setText(idkqkh);
                    
                               for (HocSinhDTO item : kqkh.cbbkqkhHS) {
                         String idHS = item.getId();
                            String nameHS = item.getLastName();
                        kqkh.ds_cbb_kqkh[0].addItem(idHS + "-" + nameHS);
                            if (nameHS.equals(student)) {
                            kqkh.ds_cbb_kqkh[0].setSelectedItem(idHS + "-" + nameHS);
                             }
                        }


                }
    
}
