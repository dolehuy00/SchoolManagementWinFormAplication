/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import BLL.DepartmentDTO;
import BLL.KhoaHocBLL;
import BLL.KhoaHocDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class KhoaHocGUI {
    JPanel pnl_input,pnl_tuongtac,top_content,pnl_contentbottom,pnl_information;
    private JPanel pnl_congcu,pnl_tk_kh,pnl_tkborder;
    
    private final String[] title_ifm_kh = {"TITLE", "CREDITS", "URL", "LOCATION", "COURSE ID"};
    private final JPanel[] ds_pnl_kh = new JPanel[title_ifm_kh.length];
    private final JTextField[] ds_input_kh = new JTextField[title_ifm_kh.length];
    
    private final String[] btn_congcu={"ADD","EDIT","DELETE","RESET", "CANCEL"};
    private final JLabel[] ds_lbl_congcu = new JLabel[btn_congcu.length];
    
    private JLabel lbl_timkiem_kh;
    private JTextField txt_timkiem_kh;
     
    private JTable tbl_kh;
    private DefaultTableModel tblm;
    
    private JComboBox cb_type, cb_department;
    
    private JRadioButton radioButtonMon, radioButtonTue, radioButtonWed, radioButtonThu,
            radioButtonFri, radioButtonSat, radioButtonSun, radioButtonAll;
    
    private JSpinner spnHours, spnMin, spnSec;
    
    public KhoaHocGUI(JPanel pnl_input, JPanel pnl_tuongtac, JPanel top_content,
        JPanel pnl_information,JPanel pnl_contentbottom) {
        
        this.pnl_input = pnl_input;
        this.pnl_tuongtac = pnl_tuongtac;
        this.top_content = top_content;
        this.pnl_congcu = pnl_congcu;
        this.pnl_information = pnl_information;
        this.pnl_contentbottom = pnl_contentbottom;
        init();
    }
     
    public void init(){
        CongCuKH();
        CourseTable();
    }
       
    public void CongCuKH(){
        // cac o nhap
        for(int i=0; i<title_ifm_kh.length;i++){
            ds_pnl_kh[i]=new JPanel();
            ds_pnl_kh[i].setBorder(BorderFactory.createTitledBorder(title_ifm_kh[i]));
            ds_pnl_kh[i].setBackground(null);
            ds_pnl_kh[i].setLayout(new FlowLayout());
            pnl_input.add(ds_pnl_kh[i]);

            ds_input_kh[i]=new JTextField();
            ds_input_kh[i].setBackground(null);
            ds_input_kh[i].setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 60)));
            ds_input_kh[i].setPreferredSize(new Dimension(110, 20));
            ds_pnl_kh[i].add(ds_input_kh[i]);
        }
        
        ds_pnl_kh[0].setBounds(150, 0, 145, 60);//title
        ds_pnl_kh[1].setBounds(295, 0, 145, 60);//credits
        ds_input_kh[1].setHorizontalAlignment(JTextField.CENTER);
        ds_pnl_kh[2].setBounds(165, 60, 420, 60);//url
        ds_input_kh[2].setPreferredSize(new Dimension(380, 20));
        ds_pnl_kh[3].setBounds(5, 120, 160, 60);//location
        ds_pnl_kh[4].setBounds(5, 0, 145, 60);//id
        ds_input_kh[4].setFont(new Font("Arial",Font.BOLD,20));
        ds_input_kh[4].setHorizontalAlignment(JTextField.CENTER);
        ds_pnl_kh[4].setEnabled(false);
        ds_input_kh[4].setEnabled(false);
        
        // panel time
        Font fPanelTime = new Font("Arial",Font.BOLD,15);
        JLabel lbHours = new JLabel("H");
        lbHours.setFont(fPanelTime);
        lbHours.setBounds(2, 0, 15, 25);
        JLabel lbMin = new JLabel("M");
        lbMin.setFont(fPanelTime);
        lbMin.setBounds(60, 0, 15, 25);
        JLabel lbSec = new JLabel("S");
        lbSec.setFont(fPanelTime);
        lbSec.setBounds(117, 0, 15, 25);
        
        spnHours = new JSpinner();
        SpinnerNumberModel spnHoursModel = new SpinnerNumberModel(0, 0, 23, 1);
        spnHours.setModel(spnHoursModel);
        spnHours.setBounds(15, 1, 40, 25);
        spnHours.setFont(fPanelTime);
        
        spnMin = new JSpinner();
        SpinnerNumberModel spnMinModel = new SpinnerNumberModel(0, 0, 59, 5);
        spnMin.setModel(spnMinModel);
        spnMin.setBounds(75, 1, 40, 25);
        spnMin.setFont(fPanelTime);
        
        spnSec = new JSpinner();
        SpinnerNumberModel spnSecModel = new SpinnerNumberModel(0, 0, 59, 5);
        spnSec.setModel(spnSecModel);
        spnSec.setBounds(130, 1, 40, 25);
        spnSec.setFont(fPanelTime);
         
        JPanel pnlTime = new JPanel();
        pnlTime.setBackground(null);
        pnlTime.setBounds(10, 23, 173, 26);
        pnlTime.setLayout(null);
        pnlTime.add(lbHours);
        pnlTime.add(lbMin);
        pnlTime.add(lbSec);
        pnlTime.add(spnHours);
        pnlTime.add(spnMin);
        pnlTime.add(spnSec);
        
        JPanel pnlTimeKH = new JPanel();
        pnlTimeKH.setBorder(BorderFactory.createTitledBorder("TIME"));
        pnlTimeKH.setBackground(null);
        pnlTimeKH.setLayout(null);
        pnlTimeKH.setBounds(395, 120, 190, 60);
        pnlTimeKH.add(pnlTime);
        pnl_input.add(pnlTimeKH);
        
        //panel day
        radioButtonMon = new JRadioButton("MON");
        radioButtonMon.setBounds(1, 1, 55, 18);
        radioButtonMon.setBackground(null);
        radioButtonTue = new JRadioButton("TUE");
        radioButtonTue.setBounds(57, 1, 55, 18);
        radioButtonTue.setBackground(null);
        radioButtonWed = new JRadioButton("WED");
        radioButtonWed.setBounds(113, 1, 55, 18);
        radioButtonWed.setBackground(null);
        radioButtonThu = new JRadioButton("THU");
        radioButtonThu.setBounds(169, 1, 55, 18);
        radioButtonThu.setBackground(null);
        radioButtonFri = new JRadioButton("FRI");
        radioButtonFri.setBounds(1, 21, 55, 18);
        radioButtonFri.setBackground(null);
        radioButtonSat = new JRadioButton("SAT");
        radioButtonSat.setBounds(57, 21, 55, 18);
        radioButtonSat.setBackground(null);
        radioButtonSat.setEnabled(false);
        radioButtonSun = new JRadioButton("SUN");
        radioButtonSun.setBounds(113, 21, 55, 18);
        radioButtonSun.setBackground(null);
        radioButtonSun.setEnabled(false);
        radioButtonAll = new JRadioButton("ALL");
        radioButtonAll.setBounds(169, 21, 55, 18);
        radioButtonAll.setBackground(null);
        
        JPanel panelDay = new JPanel();
        panelDay.setBackground(null);
        panelDay.setLayout(null);
        panelDay.setBounds(5, 15, 222, 40);
        panelDay.add(radioButtonMon);
        panelDay.add(radioButtonTue);
        panelDay.add(radioButtonWed);
        panelDay.add(radioButtonThu);
        panelDay.add(radioButtonFri);
        panelDay.add(radioButtonSat);
        panelDay.add(radioButtonSun);
        panelDay.add(radioButtonAll);
        
        JPanel pnlDayKH = new JPanel();
        pnlDayKH.setBorder(BorderFactory.createTitledBorder("DAY"));
        pnlDayKH.setBackground(null);
        pnlDayKH.setLayout(null);
        pnlDayKH.setBounds(165, 120, 230, 60);
        pnlDayKH.add(panelDay);
        pnl_input.add(pnlDayKH);
        
        //combobox type
        JPanel pnl_type=new JPanel();
        pnl_type.setBorder(BorderFactory.createTitledBorder("TYPE"));
        pnl_type.setBackground(null);
        pnl_type.setLayout(new FlowLayout());
        pnl_type.setBounds(5, 60, 160, 60);
        pnl_input.add(pnl_type);

        cb_type = new JComboBox();
        cb_type.addItem("Onsite");
        cb_type.addItem("Online");
        cb_type.setPreferredSize(new Dimension(130, 25));
        cb_type.setSelectedIndex(0);
        pnl_type.add(cb_type);

        ds_pnl_kh[2].setEnabled(false);
        ds_input_kh[2].setEnabled(false);
        
        // combobox department
        JPanel pnl_department = new JPanel();
        pnl_department.setBorder(BorderFactory.createTitledBorder("DEPARTMENT"));
        pnl_department.setBackground(null);
        pnl_department.setLayout(new FlowLayout());
        pnl_department.setBounds(440, 0, 145, 60);
        pnl_input.add(pnl_department);

        cb_department = new JComboBox();
        cb_department.setPreferredSize(new Dimension(120, 25));
        
        // lay du lieu department
        Object[] list_department = new KhoaHocBLL().getListDepartmentName();
        for (Object list_department1 : list_department) {
            cb_department.addItem(list_department1);
        }
        pnl_department.add(cb_department);
        
        // cong cu
        pnl_congcu=new JPanel();
        pnl_congcu.setBounds(580, 5, 140, 180);
        pnl_congcu.setBackground(null);
        pnl_input.add(pnl_congcu);
        for(int i=0;i<btn_congcu.length;i++){           
            ds_lbl_congcu[i]=new JLabel(btn_congcu[i],JLabel.CENTER);
            ds_lbl_congcu[i].setBackground(new Color(0, 0, 60));
            ds_lbl_congcu[i].setOpaque(true);
            ds_lbl_congcu[i].setForeground(Color.white);
            ds_lbl_congcu[i].setPreferredSize(new Dimension(100, 40));
            pnl_congcu.add(ds_lbl_congcu[i]);
        }
        ds_lbl_congcu[4].setVisible(false);
        
        // tim kiem
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
        
        // xu ly su kien radiobutton tat ca
        radioButtonAll.addActionListener((e)->{
            if(radioButtonAll.isSelected()){
                radioButtonMon.setSelected(true);
                radioButtonTue.setSelected(true);
                radioButtonWed.setSelected(true);
                radioButtonThu.setSelected(true);
                radioButtonFri.setSelected(true);
            }else{
                radioButtonMon.setSelected(false);
                radioButtonTue.setSelected(false);
                radioButtonWed.setSelected(false);
                radioButtonThu.setSelected(false);
                radioButtonFri.setSelected(false);
            }
        });
        
        // xu ly su kien them
        ds_lbl_congcu[0].addMouseListener(new ButtonAddListener());
        // xu ly su kien sua
        ds_lbl_congcu[1].addMouseListener(new ButtonEditListener());
        // xu ly su kien xoa
        ds_lbl_congcu[2].addMouseListener(new ButtonDeleteListener());
        // xu ly su kien lam moi
        ds_lbl_congcu[3].addMouseListener(new ButtonResetListener());
        // xu ly su kien huy bo
        ds_lbl_congcu[4].addMouseListener(new ButtonCancelListener());
        
        // xu ly su kien combobox type
        cb_type.addActionListener((ActionEvent e) -> {
            if(cb_type.getSelectedIndex()==0){
                ds_pnl_kh[2].setEnabled(false);ds_input_kh[2].setEnabled(false);
                ds_pnl_kh[3].setEnabled(true);ds_input_kh[3].setEnabled(true);
                radioButtonMon.setEnabled(true);radioButtonTue.setEnabled(true);
                radioButtonWed.setEnabled(true);radioButtonThu.setEnabled(true);
                radioButtonFri.setEnabled(true);radioButtonAll.setEnabled(true);
                pnlDayKH.setEnabled(true);  
                spnHours.setEnabled(true);spnMin.setEnabled(true);spnSec.setEnabled(true);
                lbHours.setEnabled(true);lbMin.setEnabled(true);lbSec.setEnabled(true);
                pnlTime.setEnabled(true);
            }
            if(cb_type.getSelectedIndex()==1){
                ds_pnl_kh[2].setEnabled(true);ds_input_kh[2].setEnabled(true);
                ds_pnl_kh[3].setEnabled(false);ds_input_kh[3].setEnabled(false);
                radioButtonMon.setEnabled(false);radioButtonTue.setEnabled(false);
                radioButtonWed.setEnabled(false);radioButtonThu.setEnabled(false);
                radioButtonFri.setEnabled(false);radioButtonAll.setEnabled(false);
                pnlDayKH.setEnabled(false);
                spnHours.setEnabled(false);spnMin.setEnabled(false);spnSec.setEnabled(false);
                lbHours.setEnabled(false);lbMin.setEnabled(false);lbSec.setEnabled(false);
                pnlTimeKH.setEnabled(false);
            }
        });

        // xu ly su kien nhan nut tim kiem
        lbl_timkiem_kh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                showDataTable(new KhoaHocBLL().searchCourse(txt_timkiem_kh.getText()), tblm);
            }
        });     
    }
     
    // table
    public void CourseTable(){
        String[] colum={"","COURSE ID","TITLE","CREDITS","DEPARTMENT", "TYPE", "LOCATION","DAY","TIME","URL"};
        tblm=new DefaultTableModel(null, colum);
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(SwingConstants.CENTER);
        tbl_kh=new JTable();
        tbl_kh.setModel(tblm);
        tbl_kh.setDefaultRenderer(Object.class, centerRender);
        tbl_kh.getColumnModel().getColumn(0).setPreferredWidth(40);//stt
        tbl_kh.getColumnModel().getColumn(1).setPreferredWidth(100);//id
        tbl_kh.getColumnModel().getColumn(2).setPreferredWidth(110);//title
        tbl_kh.getColumnModel().getColumn(3).setPreferredWidth(65);//credis
        tbl_kh.getColumnModel().getColumn(4).setPreferredWidth(110);//department
        tbl_kh.getColumnModel().getColumn(5).setPreferredWidth(60);//type
        tbl_kh.getColumnModel().getColumn(6).setPreferredWidth(100);//location
        tbl_kh.getColumnModel().getColumn(7).setPreferredWidth(60);//day
        tbl_kh.getColumnModel().getColumn(8).setPreferredWidth(55);//time
        tbl_kh.getColumnModel().getColumn(9).setPreferredWidth(250);//url
        
        tbl_kh.setRowHeight(30);
        tbl_kh.setLocation(50, 50);
        tbl_kh.setGridColor(new Color(0, 0, 60));
        tbl_kh.setAutoCreateRowSorter(true);
        tbl_kh.getTableHeader().setBackground(new Color(0, 0, 60));
        tbl_kh.getTableHeader().setForeground(Color.white);
        tbl_kh.setPreferredScrollableViewportSize(new Dimension(950, 310));
        pnl_information.add(new JScrollPane(tbl_kh));  
        
        // lay danh sach khoa hoc
        showDataTable(new KhoaHocBLL().getAllCourse(), tblm);
        
        // xu ly su kien nhan 1 dong trong bang
        tbl_kh.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tbl_kh.getSelectedRow();
                ds_input_kh[4].setText((String) tbl_kh.getValueAt(i,1));
                ds_input_kh[0].setText((String) tbl_kh.getValueAt(i, 2));
                ds_input_kh[1].setText((String) tbl_kh.getValueAt(i, 3));
                cb_department.setSelectedItem((String) tbl_kh.getValueAt(i, 4));
                if(tbl_kh.getValueAt(i, 5).equals("Online")){
                    cb_type.setSelectedItem((String) tbl_kh.getValueAt(i, 5));
                    ds_input_kh[2].setText((String) tbl_kh.getValueAt(i, 9));
                    ds_input_kh[3].setText(null);
                    setDayToForm(null);
                    setTimeToForm(null);
                }else{
                    cb_type.setSelectedItem((String) tbl_kh.getValueAt(i, 5));
                    ds_input_kh[3].setText((String) tbl_kh.getValueAt(i, 6));
                    setDayToForm((String) tbl_kh.getValueAt(i, 7));
                    setTimeToForm((String) tbl_kh.getValueAt(i, 8));
                    ds_input_kh[2].setText(null);
                }
            }
        });            
    } 
    
    private void showDataTable(ArrayList<KhoaHocDTO> list, DefaultTableModel tableModel){
        tableModel.setRowCount(0);
        for(int i=0;i<list.size();i++){
            tableModel.addRow(new Object[]{i+1,list.get(i).getId(),list.get(i).getTitle(),
                list.get(i).getCredits(),list.get(i).getDepartment(),
                list.get(i).getType(),list.get(i).getLocation(),list.get(i).getDay(),
                list.get(i).getTime(),list.get(i).getUrl()});
        }
        tableModel.fireTableDataChanged();
    }
    private String getDayInForm() {
        String day = "";
        if (radioButtonMon.isSelected()) {
            day+="M";
        }
        if (radioButtonTue.isSelected()) {
            day+="T";
        }
        if (radioButtonWed.isSelected()) {
            day+="W";
        }
        if (radioButtonThu.isSelected()) {
            day+="H";
        }
        if (radioButtonFri.isSelected()) {
            day+="F";
        }
        return day;
    }
    private void setDayToForm(String value) {
        radioButtonMon.setSelected(false);
        radioButtonTue.setSelected(false);
        radioButtonWed.setSelected(false);
        radioButtonThu.setSelected(false);
        radioButtonFri.setSelected(false);
        radioButtonAll.setSelected(false);
        if (value != null) {
            for(int i=0; i<value.length(); i++){
                if('M'==value.charAt(i)){
                    radioButtonMon.setSelected(true);
                }
                if('T'==value.charAt(i)){
                    radioButtonTue.setSelected(true);
                }
                if('W'==value.charAt(i)){
                    radioButtonWed.setSelected(true);
                }
                if('H'==value.charAt(i)){
                    radioButtonThu.setSelected(true);
                }
                if('F'==value.charAt(i)){
                    radioButtonFri.setSelected(true);
                }
            }
        }  
    }
    private String getTimeInForm() {
        String time = "";
        time += spnHours.getValue()+":"+spnMin.getValue()+":"+spnSec.getValue();
        return time;
    }
    private void setTimeToForm(String time) {
        if (time == null) {
            spnHours.setValue(0);
            spnMin.setValue(0);
            spnSec.setValue(0);
        }else{
            spnHours.setValue(Integer.valueOf(time.split(":")[0]));
            spnMin.setValue(Integer.valueOf(time.split(":")[1]));
            spnSec.setValue(Integer.valueOf(time.split(":")[2]));
        }
    }
    private void setNullAllInput(){
        for(int i=0; i<title_ifm_kh.length;i++){
            ds_input_kh[i].setText(null);   
        }
        setDayToForm(null);
        setTimeToForm(null);
    }
    private boolean checkIDExist(String id){
        for (int i = 0; i < tblm.getRowCount(); i++) {
            System.out.println(i);
            if (id.equals((String) tbl_kh.getValueAt(i,1))) {
                return true;
            }
        }
        return false;
    }
            
    private boolean checkDataInput(){
        if ("".equals(ds_input_kh[4].getText())) {
            JOptionPane.showMessageDialog(null, "Vui long nhap thong tin 'Course ID'");
            return false;
        }
        if(!(new KhoaHocBLL().isNumber(ds_input_kh[4].getText()))){
            JOptionPane.showMessageDialog(null, "Thong tin 'Course ID' phai la so");
            return false;
        }
        if(checkIDExist((String)ds_input_kh[4].getText())&& "ADD NEW".equals((String)ds_lbl_congcu[0].getText())){
            JOptionPane.showMessageDialog(null, "'Course ID' da ton tai");
            return false;
        }
        if ("".equals(ds_input_kh[0].getText())) {
            JOptionPane.showMessageDialog(null, "Vui long nhap thong tin 'Title'");
            return false;
        }
        if ("".equals(ds_input_kh[1].getText())) {
            JOptionPane.showMessageDialog(null, "Vui long nhap thong tin 'Credits'");
            return false;
        }
        if(!(new KhoaHocBLL().isNumber((String)ds_input_kh[1].getText()))){
            JOptionPane.showMessageDialog(null, "Thong tin 'Credits' phai la so");
            return false;
        }
        if (((String)cb_type.getSelectedItem()).equals("Online")) {
            if ("".equals(ds_input_kh[2].getText())) {
                JOptionPane.showMessageDialog(null, "Vui long nhap thong tin 'Url'");
                return false;
            }
        } else {
            if ("".equals(ds_input_kh[3].getText())) {
                JOptionPane.showMessageDialog(null, "Vui long nhap thong tin 'Location'");
                return false;
            }
            if (getDayInForm().equals("")) {
                JOptionPane.showMessageDialog(null, "Vui long nhap thong tin 'Day'");
                return false;
            }
            if (getTimeInForm().equals("0:0:0")) {
                JOptionPane.showMessageDialog(null, "Vui long nhap thong tin 'Time'");
                return false;
            }
        }
        return true;
    }
    private class ButtonAddListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(ds_lbl_congcu[0].getText().equals("ADD")){
                    setNullAllInput();
                    ds_input_kh[4].setEnabled(true);
                    ds_pnl_kh[4].setEnabled(true);
                    ds_lbl_congcu[0].setText("ADD NEW");
                    ds_lbl_congcu[0].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                    ds_lbl_congcu[1].setVisible(false);
                    ds_lbl_congcu[2].setVisible(false);
                    ds_lbl_congcu[4].setVisible(true);
                }else if (checkDataInput()){
                    KhoaHocDTO course = new KhoaHocDTO(ds_input_kh[4].getText(),
                        ds_input_kh[0].getText(),new KhoaHocBLL().getDepartmentID(
                        (String) cb_department.getSelectedItem()),
                        ds_input_kh[1].getText(), (String) cb_type.getSelectedItem(),
                        ds_input_kh[2].getText(), ds_input_kh[3].getText(),
                        getDayInForm(), getTimeInForm());
                    new KhoaHocBLL().addNewCourse(course);
                    showDataTable(new KhoaHocBLL().getAllCourse(), tblm);
                    setNullAllInput();
                    ds_lbl_congcu[0].setText("ADD");
                    ds_input_kh[4].setEnabled(false);
                    ds_pnl_kh[4].setEnabled(false);
                    ds_lbl_congcu[0].setBorder(null);
                    ds_lbl_congcu[1].setVisible(true);
                    ds_lbl_congcu[2].setVisible(true);
                    ds_lbl_congcu[4].setVisible(false);
                    JOptionPane.showMessageDialog(null,"Saved",
                        "Save",JOptionPane.PLAIN_MESSAGE);
                }
        }
    }
    private class ButtonEditListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(ds_lbl_congcu[1].getText().equals("EDIT")){
                ds_lbl_congcu[1].setText("SAVE CHANGE");
                ds_lbl_congcu[1].setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                ds_lbl_congcu[0].setVisible(false);
                ds_lbl_congcu[2].setVisible(false);
                ds_lbl_congcu[4].setVisible(true);
            }else{
                if(checkDataInput()){
                    KhoaHocDTO course = new KhoaHocDTO(ds_input_kh[4].getText(),
                        ds_input_kh[0].getText(), new KhoaHocBLL().getDepartmentID(
                        (String) cb_department.getSelectedItem()),
                        ds_input_kh[1].getText(), (String) cb_type.getSelectedItem(),
                        ds_input_kh[2].getText(), ds_input_kh[3].getText(),
                        getDayInForm(), getTimeInForm());
                    new KhoaHocBLL().updateCourse(course,
                        checkOldType((String)ds_input_kh[4].getText()));
                    showDataTable(new KhoaHocBLL().getAllCourse(), tblm);
                    setNullAllInput();
                    ds_lbl_congcu[1].setText("EDIT");
                    ds_lbl_congcu[1].setBorder(null);
                    ds_lbl_congcu[0].setVisible(true);
                    ds_lbl_congcu[2].setVisible(true);
                    ds_lbl_congcu[4].setVisible(false);
                    JOptionPane.showMessageDialog(null,"Saved",
                        "Save",JOptionPane.PLAIN_MESSAGE);
                } 
            }
        }
    }
    private class ButtonDeleteListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            int i=tbl_kh.getSelectedRow();
            if(i<0){
                JOptionPane.showMessageDialog(null, "Vui long chon khoa hoc can xoa tu bang!");
            }else{
                int dialog_del = JOptionPane.showConfirmDialog(null,
                    "Chac chan xoa?\n"+"ID: "+(String) tbl_kh.getValueAt(i,1)
                    +"\n"+"Title: "+(String) tbl_kh.getValueAt(i,2),"Delete",
                    JOptionPane.YES_NO_OPTION);
                if(dialog_del == JOptionPane.YES_OPTION){
                    new KhoaHocBLL().deleteCourse((String) tbl_kh.getValueAt(i,1),
                            (String) tbl_kh.getValueAt(i,5));
                    showDataTable(new KhoaHocBLL().getAllCourse(), tblm);
                    setNullAllInput();
                    JOptionPane.showMessageDialog(null, "Delete"); 
                }
            }
        }
    }
    private class ButtonResetListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (ds_lbl_congcu[0].getText().equals("ADD NEW")) {
                   setNullAllInput();
                }else if (ds_lbl_congcu[1].getText().equals("SAVE CHANGE")) {
                    ds_input_kh[0].setText(null);
                    ds_input_kh[1].setText(null);
                    ds_input_kh[2].setText(null);
                    ds_input_kh[3].setText(null);
                    setDayToForm(null);
                    setTimeToForm(null);
                }else{
                    setNullAllInput();
                    showDataTable(new KhoaHocBLL().getAllCourse(), tblm);
                }
        }
    }
    private class ButtonCancelListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (ds_lbl_congcu[0].getText().equals("ADD NEW")) {
                    ds_lbl_congcu[0].setText("ADD");
                    setNullAllInput();
                    ds_lbl_congcu[4].setVisible(false);
                    ds_lbl_congcu[0].setBorder(null);
                    ds_lbl_congcu[1].setVisible(true);
                    ds_lbl_congcu[2].setVisible(true);
                }else if (ds_lbl_congcu[1].getText().equals("SAVE CHANGE")) {
                    ds_lbl_congcu[1].setText("EDIT");
                    setNullAllInput();  
                    ds_lbl_congcu[4].setVisible(false);
                    ds_lbl_congcu[1].setBorder(null);
                    ds_lbl_congcu[0].setVisible(true);
                    ds_lbl_congcu[2].setVisible(true);
                }
        }
    }
    
    private String checkOldType(String id){
        for (int i = 0; i < tblm.getRowCount(); i++) {
            if (id.equals((String) tbl_kh.getValueAt(i,1))) {
                return (String) tbl_kh.getValueAt(i,5);
            }
        }
        return "";
    }
}
