/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.KhoaHocDTO;
import BLL.HocSinhDTO;
import BLL.KQKhoaHocBLL;
import BLL.KQKhoaHocDTO;
import DAL.KQKhoaHocDAL;
import GUI.Imgs;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class KQKhoaHocGUI {
      JPanel pnl_input,pnl_tuongtac,top_content,pnl_contentbottom,pnl_information;
    public  JPanel pnl_congcu,pnl_tk_kh,pnl_tkborder;
    public  String[] title_cbb_kqkh={"Student","Course"};
        public  JPanel[] ds_pnl_cbbkqkh=new JPanel[title_cbb_kqkh.length];

    
    public  String[] title_ifm_kh={"Grade","Department"};
    public  JPanel[] ds_pnl_kh=new JPanel[title_ifm_kh.length];
    public  JTextField[] ds_input_kh= new JTextField[title_ifm_kh.length];
    
    public  String[] btn_congcu={"Thêm","Sửa","Xóa","Reset"};
    public  JLabel[] ds_lbl_congcu=new JLabel[btn_congcu.length];
    public ArrayList<KQKhoaHocDTO> KQKH = new ArrayList<KQKhoaHocDTO>();
    public ArrayList<KQKhoaHocDTO> searchKQKH = new ArrayList<KQKhoaHocDTO>();
    public ArrayList<HocSinhDTO> cbbkqkhHS = new ArrayList<HocSinhDTO>();
     public ArrayList<KhoaHocDTO> cbbkqkhKH = new ArrayList<KhoaHocDTO>();
    
     public  JComboBox[] ds_cbb_kqkh= new JComboBox[title_cbb_kqkh.length];
    KQKhoaHocDAL kqkhDAL = new KQKhoaHocDAL(this);
    
    public  JLabel lbl_timkiem_kh,lbl_idkh,lbl_typekh;
    public  JTextField txt_timkiem_kh;
    
    
     public String idkh,idhs;
     
    public  JTable tbl_kqkh;
    public  DefaultTableModel tblm;
    
    public JLabel anh;
    public ImageIcon anhkh;
    public Image ic;
    public int trangthai=0;
    public int d=0;
    
     public KQKhoaHocGUI(JPanel pnl_input, JPanel pnl_tuongtac, JPanel top_content, JPanel pnl_information,JPanel pnl_contentbottom) {
        this.pnl_input = pnl_input;
        this.pnl_tuongtac = pnl_tuongtac;
        this.top_content = top_content;
        this.pnl_congcu = pnl_congcu;
        this.pnl_information = pnl_information;
        this.pnl_contentbottom = pnl_contentbottom;
        init();
    }
     
       public void init(){
       congcukh();
       inner_imgkh();
        KQKH= KQKhoaHocBLL.getData();
        cbbkqkhHS = KQKhoaHocBLL.getDataCBBHS();
        cbbkqkhKH = KQKhoaHocBLL.getDataCBBKH();
        inner_combobox();
        KhachHangTBL();
    }
       
        public void congcukh(){
              MouseListener ml=new MListenerKQKH(this);
         for(int i=0; i<title_ifm_kh.length;i++)
            {
                ds_pnl_kh[i]=new JPanel();
                ds_pnl_kh[i].setBorder(BorderFactory.createTitledBorder(title_ifm_kh[i]));
                ds_pnl_kh[i].setBackground(null);
                ds_pnl_kh[i].setLayout(new FlowLayout());
                pnl_input.add(ds_pnl_kh[i]);
                
                
                
                ds_input_kh[i]=new JTextField();
                ds_input_kh[i].setBackground(null);
                ds_input_kh[i].setBorder(new MatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
                ds_input_kh[i].setPreferredSize(new Dimension(120, 20));
                ds_pnl_kh[i].add(ds_input_kh[i]);
            }
            ds_pnl_kh[0].setBounds(380, 90, 150, 60);
            ds_pnl_kh[1].setBounds(380, 10, 150, 60);
            ds_input_kh[1].setEditable(false);
            
            
            
            lbl_idkh=new JLabel(kqkhDAL.idkh()+"",JLabel.CENTER);
            lbl_idkh.setBounds(20, 10, 200, 60);
            lbl_idkh.setBackground(null);
            lbl_idkh.setBorder(BorderFactory.createTitledBorder("COURSE ID"));
            pnl_input.add(lbl_idkh);
                        
            pnl_congcu=new JPanel();
            pnl_congcu.setBounds(560, 5, 140, 180);
            pnl_congcu.setBackground(null);
            pnl_input.add(pnl_congcu);
            
            for(int i=0;i<btn_congcu.length;i++)
            {           
                ds_lbl_congcu[i]=new JLabel(btn_congcu[i],JLabel.CENTER);
                ds_lbl_congcu[i].setBackground(new Color(0, 0, 60));
                ds_lbl_congcu[i].setOpaque(true);
                ds_lbl_congcu[i].setForeground(Color.white);
                ds_lbl_congcu[i].setPreferredSize(new Dimension(100, 40));
                pnl_congcu.add(ds_lbl_congcu[i]);
                ds_lbl_congcu[i].addMouseListener(ml);
            }
            
            pnl_tkborder=new JPanel();
            pnl_tkborder.setBackground(null);
            pnl_tkborder.setBorder(new MatteBorder(2, 0, 0, 0, new Color(0, 0, 60)));
            pnl_tkborder.setBounds(0, 190, 700, 70);
            pnl_input.add(pnl_tkborder);
            
            pnl_tk_kh=new JPanel();
            pnl_tk_kh.setPreferredSize(new Dimension(280,60));
            pnl_tk_kh.setBackground(null);
            pnl_tk_kh.setBorder(BorderFactory.createTitledBorder("Tìm kiếm khóa học"));
            pnl_tkborder.add(pnl_tk_kh);
            
            txt_timkiem_kh=new JTextField();
            txt_timkiem_kh.setPreferredSize(new Dimension(260, 30));
            txt_timkiem_kh.setBackground(null);
            txt_timkiem_kh.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
            pnl_tk_kh.add(txt_timkiem_kh);
            
            lbl_timkiem_kh=new JLabel("Tìm kiếm",JLabel.CENTER);
            lbl_timkiem_kh.setBackground(new Color(0, 0, 60));
            lbl_timkiem_kh.setOpaque(true);
            lbl_timkiem_kh.setForeground(Color.white);
            lbl_timkiem_kh.setPreferredSize(new Dimension(100, 40));
            pnl_tkborder.add(lbl_timkiem_kh);
            lbl_timkiem_kh.addMouseListener(ml);
    }
    
   
     public void inner_imgkh(){
            Imgs im=new Imgs();
            anhkh = new ImageIcon(im.imgs(""));
            ic = anhkh.getImage().getScaledInstance(260, 260, Image.SCALE_AREA_AVERAGING);
            anhkh = new ImageIcon(ic);
            anh=new JLabel(anhkh,JLabel.CENTER);
            anh.setBounds(0, 0, 260, 260);
            pnl_tuongtac.add(anh);
           }
     
      public void inner_combobox(){
        for(int i=0; i<title_cbb_kqkh.length;i++)
            {
                ds_pnl_cbbkqkh[i]=new JPanel();
                ds_pnl_cbbkqkh[i].setBorder(BorderFactory.createTitledBorder(title_cbb_kqkh[i]));
                ds_pnl_cbbkqkh[i].setBackground(null);
                ds_pnl_cbbkqkh[i].setLayout(new FlowLayout());
                pnl_input.add(ds_pnl_cbbkqkh[i]);
                
            ds_cbb_kqkh[i]=new JComboBox();
                ds_cbb_kqkh[i].setBackground(null);
                ds_cbb_kqkh[i].setBorder(new MatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
                
                ds_cbb_kqkh[i].setPreferredSize(new Dimension(135, 30));
                ds_pnl_cbbkqkh[i].add(ds_cbb_kqkh[i]);
            }
        ds_cbb_kqkh[0].addItem("Choose Student");
        for (HocSinhDTO item : cbbkqkhHS) {
            String idhs = item.getId();
            String namehs = item.getLastName();
            ds_cbb_kqkh[0].addItem(idhs + "-" + namehs);
        }

            ds_cbb_kqkh[1].addItem("Choose Course");
           for (KhoaHocDTO item : cbbkqkhKH) {
            String idkh = item.getId();
            String namekh = item.getTime();
            ds_cbb_kqkh[1].addItem(idkh + "-" + namekh);
        }
           ds_cbb_kqkh[1].setSelectedIndex(0);
          ds_cbb_kqkh[1].addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            String selectedOption = (String) ds_cbb_kqkh[1].getSelectedItem();
            if (selectedOption != null) {
                String namekh = selectedOption.substring(selectedOption.indexOf("-") + 1).trim();
                for (KQKhoaHocDTO o : KQKH) {
                    if (namekh.equals(o.getNameCourse())) {
                        ds_input_kh[1].setText(o.getDepartment());
                    }
                }
            }
        }
    }
        });
          

            ds_pnl_cbbkqkh[0].setBounds(20, 90, 150, 60);
            ds_pnl_cbbkqkh[1].setBounds(190, 90, 150, 60);
     }
     
    public void KhachHangTBL(){
            String[] colum={"ID","Course","Student","Grade","Department"};
            String[][] row={};
            tblm=new DefaultTableModel(row, colum);
            tbl_kqkh=new JTable();
            tbl_kqkh.setModel(tblm);
            tbl_kqkh.setRowHeight(30);
            tbl_kqkh.setGridColor(new Color(0, 0, 60));
            tbl_kqkh.setAutoCreateRowSorter(true);
            tbl_kqkh.getTableHeader().setBackground(new Color(0, 0, 60));
            tbl_kqkh.getTableHeader().setForeground(Color.white);
            tbl_kqkh.setPreferredScrollableViewportSize(new Dimension(970, 270));
            pnl_information.add(new JScrollPane(tbl_kqkh));   
            loadKQKH();
            MouseAdapter mls_tblKQKH=new MListenerTableKQKH(this);
            tbl_kqkh.addMouseListener(mls_tblKQKH);
            }
    
      public void loadKQKH(){
          tblm.setRowCount(0);
          KQKH = kqkhDAL.table_nv();
        for(KQKhoaHocDTO kqkh: KQKH){
            tblm.addRow(new Object[]{kqkh.getId(),kqkh.getNameStudent(),kqkh.getNameCourse(),kqkh.getGrade(),kqkh.getDepartment()});
        }
    }
}
