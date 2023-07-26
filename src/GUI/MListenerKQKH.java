/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.KQKhoaHocBLL;
import BLL.KQKhoaHocDTO;
import DAL.KQKhoaHocDAL;
import GUI.KQKhoaHocGUI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author DELL
 */
public class MListenerKQKH implements MouseListener {
        KQKhoaHocGUI kqkh;
        KQKhoaHocBLL kqkhBLL = new KQKhoaHocBLL();
        int d=0;

    public MListenerKQKH(KQKhoaHocGUI kqkh) {
        this.kqkh = kqkh;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
         String idkqkh = kqkh.lbl_idkh.getText();

         String grade = kqkh.ds_input_kh[0].getText();
         String department = kqkh.ds_input_kh[1].getText();
         
        String oj_idhs=(String) kqkh.ds_cbb_kqkh[0].getSelectedItem();
            String idhs = oj_idhs.substring(0, oj_idhs.indexOf("-")).trim();
        String oj_idkh=(String) kqkh.ds_cbb_kqkh[1].getSelectedItem();
        String idkh = oj_idkh.substring(0, oj_idkh.indexOf("-")).trim();
        
         String oj_namehs=(String) kqkh.ds_cbb_kqkh[0].getSelectedItem().toString();
            String namehs = oj_namehs.substring(oj_namehs.indexOf("-") + 1).trim();
            
           String oj_namekh=(String) kqkh.ds_cbb_kqkh[1].getSelectedItem().toString();
            String namekh = oj_namekh.substring(oj_namekh.indexOf("-") + 1).trim();
              
                     KQKhoaHocDAL kqkhDAL = new KQKhoaHocDAL(kqkh);
              if(e.getSource().equals(kqkh.ds_lbl_congcu[0]))
        {

            if(!idkqkh.equals("")&&!idhs.equals("")&&!idkh.equals("")&&!grade.equals("")&&!department.equals(""))
            {
                int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn thêm kết quả của học sinh này không?","Xác nhận thêm nhân viên",JOptionPane.YES_NO_OPTION);
                if(result==0)
                {
                  if(Float.parseFloat(grade) < 0 || Float.parseFloat(grade) >= 10){
                     showMessageDialog(null, "Điểm phải nhỏ hơn 10 và lớn hơn 0");
                    }else{
                    for(KQKhoaHocDTO o: kqkh.KQKH){
                        if(o.getNameCourse().equals(namekh) && o.getNameStudent().equals(namehs)){
                       showMessageDialog(null, "Học sinh này đã có điểm của môn này rồi");
                       d=1;
                      break;
                   } 
                }if(d==0){
                    kqkh.tblm.setRowCount(0);
                    KQKhoaHocDTO kqkhDTO=new KQKhoaHocDTO(idkqkh,idhs,idkh,grade,department);
                    kqkhDTO.setId(idkqkh);
                    kqkhDTO.setNameCourse(idkh);
                    kqkhDTO.setNameStudent(idhs);
                    kqkhDTO.setGrade(grade);
                    kqkhDTO.setDepartment(department);
                    kqkhBLL.addCustomer(kqkhDTO);
                    showMessageDialog(null, "Thêm thành công");
                    kqkh.ds_input_kh[0].setText("");
                    kqkh.ds_input_kh[1].setText("");
                    kqkh.lbl_idkh.setText(kqkhDAL.idkh() + "");
                    kqkh.loadKQKH();
                 }
                d=0;
                }
                }else{
                showMessageDialog(null, "Thêm thất bại");
            }
            }else{
                showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
            }
        }
            if(e.getSource().equals(kqkh.ds_lbl_congcu[1]))
        {
            if(!idkqkh.equals("")&&!idhs.equals("")&&!idkh.equals("")&&!grade.equals(""))
            {
                int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn sửa kết quả của học sinh này không?","Xác nhận sửa kết quả",JOptionPane.YES_NO_OPTION);
                if(result==0)
                {
                    if(Float.parseFloat(grade) < 0 || Float.parseFloat(grade) >= 10){
                     showMessageDialog(null, "Điểm phải nhỏ hơn 10 và lớn hơn 0");
                    }else{
                    for(KQKhoaHocDTO o: kqkh.KQKH){
                        if(o.getNameCourse().equals(namekh) && o.getNameStudent().equals(namehs)){
                       showMessageDialog(null, "Học sinh này đã có điểm của môn này rồi");
                       d=1;
                      break;
                   } }if(d==0){
                    kqkh.tblm.setRowCount(0);
                    KQKhoaHocDTO kqkhDTO=new KQKhoaHocDTO(idkqkh,idhs,idkh,grade,department);
                    kqkhDTO.setId(idkqkh);
                    kqkhDTO.setNameCourse(idkh);
                    kqkhDTO.setNameStudent(idhs);
                    kqkhDTO.setGrade(grade);
                    kqkhDTO.setDepartment(department);
                    kqkhBLL.editCustomer(kqkhDTO);
                    showMessageDialog(null, "Sửa thành công");
                    kqkh.ds_input_kh[0].setText("");
                    kqkh.ds_input_kh[1].setText("");
                    kqkh.lbl_idkh.setText(kqkhDAL.idkh() + "");
                    kqkh.loadKQKH();
                    } 
                    }
                    }
                else{
                showMessageDialog(null, "Sửa thất bại");
            }
            }else{
                showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
            }
            
            
            }if(e.getSource().equals(kqkh.ds_lbl_congcu[2]))
        {

            if(!idkqkh.equals("")&&!idhs.equals("")&&!idkh.equals("")&&!grade.equals(""))
            {
                int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa kết quả của học sinh này không?","Xác nhận xóa kết quả",JOptionPane.YES_NO_OPTION);
                if(result==0)
                {
                    kqkh.tblm.setRowCount(0);
                    KQKhoaHocDTO kqkhDTO=new KQKhoaHocDTO(idkqkh,idhs,idkh,grade.toString(),department);
                   kqkhDTO.setId(idkqkh);
                    kqkhDTO.setNameCourse(idkh);
                    kqkhDTO.setNameStudent(idhs);
                    kqkhDTO.setGrade(grade.toString());
                    kqkhDTO.setDepartment(department);
                    kqkhBLL.deleteKQKH(kqkhDTO);
                    showMessageDialog(null, "Xóa thành công");
                    kqkh.lbl_idkh.setText(kqkhDAL.idkh() + "");
                    kqkh.ds_input_kh[0].setText("");
                    kqkh.ds_input_kh[1].setText("");
                    kqkh.loadKQKH();

                }else{
                showMessageDialog(null, "Xóa thất bại");
            }
            }else{
                showMessageDialog(null, "Hãy nhập đầy đủ thông tin");
            }
        }
         else if(e.getSource().equals(kqkh.lbl_timkiem_kh))
        {   
            int d=0;
            kqkh.tblm.setRowCount(0);
            for(KQKhoaHocDTO o:kqkh.KQKH)
            {
                if(o.getId().contains(kqkh.txt_timkiem_kh.getText()) || o.getNameCourse().contains(kqkh.txt_timkiem_kh.getText()) || o.getNameStudent().contains(kqkh.txt_timkiem_kh.getText()) || o.getGrade().contains(kqkh.txt_timkiem_kh.getText()) || o.getDepartment().contains(kqkh.txt_timkiem_kh.getText())){
                    kqkh.tblm.addRow(new Object[]{o.getId(),o.getNameCourse(),o.getNameStudent(),o.getGrade(),o.getDepartment()});
                    d++;
                }
            }
            if(d==0){
                    showMessageDialog(null, "Không tìm thấy kết quả bạn cần tìm");
                    kqkh.loadKQKH();
                }
        } else if(e.getSource().equals(kqkh.ds_lbl_congcu[3])){
                kqkh.lbl_idkh.setText(kqkhDAL.idkh() + "");
                kqkh.ds_input_kh[0].setText("");
                kqkh.ds_input_kh[1].setText("");
                kqkh.txt_timkiem_kh.setText("");
                kqkh.loadKQKH();
        }
        
    }
    
    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
   
}

    

