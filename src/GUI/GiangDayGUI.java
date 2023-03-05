/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import BLL.GiangDayBLL;
import BLL.GiangDayDTO;
import DAL.GiangdayDAL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class GiangDayGUI {
    
    JPanel pnl_input, pnl_tuongtac, top_content, pnl_contentbottom, pnl_information;
    public JPanel pnl_congcu, pnl_tk_kh, pnl_tkborder;

    public String[] btn_congcu = {"Thêm", "Sửa", "Xóa", "Reset"};
    public JLabel[] ds_lbl_congcu = new JLabel[btn_congcu.length];

    public JLabel lbl_timkiem_kh, lbl_coursename, lbl_personname, lbl_typekh;
    public JTextField txt_timkiem_kh;

    public JComboBox<String> courseComboBox;
    public JComboBox<String> personComboBox;

    public String idkh;

    public JTable tbl_kh;
    public DefaultTableModel tblm;

    public JLabel anh;
    public ImageIcon anhkh;
    public Image ic;
    public int trangthai = 0;
    public int d = 0;

    public GiangDayGUI(JPanel pnl_input, JPanel pnl_tuongtac, JPanel top_content, JPanel pnl_information, JPanel pnl_contentbottom) {
        this.pnl_input = pnl_input;
        this.pnl_tuongtac = pnl_tuongtac;
        this.top_content = top_content;
        this.pnl_congcu = pnl_congcu;
        this.pnl_information = pnl_information;
        this.pnl_contentbottom = pnl_contentbottom;
        init();
    }

    public void init() {
        congcukh();
        event_btn();
        KhachHangTBL();
        getDataForTable();

    }

    public void congcukh() {

        lbl_coursename = new JLabel();
        lbl_coursename.setBounds(20, 0, 200, 60);
        lbl_coursename.setBackground(null);
        lbl_coursename.setBorder(BorderFactory.createTitledBorder("COURSE_NAME"));
        pnl_input.add(lbl_coursename);

        lbl_personname = new JLabel();
        lbl_personname.setBounds(20, 80, 200, 60);
        lbl_personname.setBackground(null);
        lbl_personname.setBorder(BorderFactory.createTitledBorder("PERSON_NAME"));
        pnl_input.add(lbl_personname);

        lbl_coursename.setText("Calculus");
        lbl_personname.setText("Abercrombie Kim");

        courseComboBox = new JComboBox<>();

        GiangDayBLL gaddal = new GiangDayBLL();

        personComboBox = new JComboBox<>();
        gaddal.loadDataIntoComboBoxperson(personComboBox, "person", "PersonID");
        gaddal.loadDataIntoComboBoxcourse(courseComboBox, "course", "CourseID");

        personComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị được chọn trên combobox
                String selectedId = personComboBox.getSelectedItem().toString();

                // Thực hiện truy vấn để lấy tên tương ứng của id đó từ database
                String ten = gaddal.getcombobox_nameperson(selectedId); // Hàm này bạn phải tự viết để lấy tên tương ứng

                // Hiển thị tên tương ứng lên label
                lbl_personname.setText(ten);
            }
        });

        courseComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị được chọn trên combobox
                String selectedId = courseComboBox.getSelectedItem().toString();

                // Thực hiện truy vấn để lấy tên tương ứng của id đó từ database
                String ten = gaddal.getcombobox_namecoure(selectedId); // Hàm này bạn phải tự viết để lấy tên tương ứng

                // Hiển thị tên tương ứng lên label
                lbl_coursename.setText(ten);
            }
        });
        ;

        courseComboBox.setBounds(260, 0, 200, 60);
        courseComboBox.setBorder(BorderFactory.createTitledBorder("COURSE_ID"));
        pnl_input.add(courseComboBox);

        personComboBox.setBounds(260, 80, 200, 60);
        personComboBox.setBorder(BorderFactory.createTitledBorder("PERSON_ID"));
        pnl_input.add(personComboBox);

        pnl_congcu = new JPanel();
        pnl_congcu.setBounds(560, 5, 140, 180);
        pnl_congcu.setBackground(null);
        pnl_input.add(pnl_congcu);

        for (int i = 0; i < btn_congcu.length; i++) {
            ds_lbl_congcu[i] = new JLabel(btn_congcu[i], JLabel.CENTER);
            ds_lbl_congcu[i].setBackground(new Color(0, 0, 60));
            ds_lbl_congcu[i].setOpaque(true);
            ds_lbl_congcu[i].setForeground(Color.white);
            ds_lbl_congcu[i].setPreferredSize(new Dimension(100, 40));
            pnl_congcu.add(ds_lbl_congcu[i]);
        }

        pnl_tkborder = new JPanel();
        pnl_tkborder.setBackground(null);
        pnl_tkborder.setBorder(new MatteBorder(2, 0, 0, 0, new Color(0, 0, 60)));
        pnl_tkborder.setBounds(0, 190, 700, 70);
        pnl_input.add(pnl_tkborder);

        pnl_tk_kh = new JPanel();
        pnl_tk_kh.setPreferredSize(new Dimension(280, 60));
        pnl_tk_kh.setBackground(null);
        pnl_tk_kh.setBorder(BorderFactory.createTitledBorder("Tìm kiếm khóa học"));
        pnl_tkborder.add(pnl_tk_kh);

        txt_timkiem_kh = new JTextField();
        txt_timkiem_kh.setPreferredSize(new Dimension(260, 30));
        txt_timkiem_kh.setBackground(null);
        txt_timkiem_kh.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 0, 60)));
        pnl_tk_kh.add(txt_timkiem_kh);

        lbl_timkiem_kh = new JLabel("Tìm kiếm", JLabel.CENTER);
        lbl_timkiem_kh.setBackground(new Color(0, 0, 60));
        lbl_timkiem_kh.setOpaque(true);
        lbl_timkiem_kh.setForeground(Color.white);
        lbl_timkiem_kh.setPreferredSize(new Dimension(100, 40));
        pnl_tkborder.add(lbl_timkiem_kh);

    }

    public void event_btn() {
        int idcourse = Integer.parseInt(courseComboBox.getSelectedItem().toString());
        int idperson = Integer.parseInt(personComboBox.getSelectedItem().toString());
        GiangDayDTO gd = new GiangDayDTO(idcourse, idperson);
        GiangDayBLL gaddal = new GiangDayBLL();

        ds_lbl_congcu[0].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
//                int idcourse = Integer.parseInt(courseComboBox.getSelectedItem().toString());
//                int idperson = Integer.parseInt(personComboBox.getSelectedItem().toString());
                boolean isSuccess = gaddal.addcourseinsreuctor(gd);
                getDataForTable();

                System.out.println(isSuccess);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(null, "Thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "add Khóa đã tồn tại, xin bạn chọn khóa khác");

                }

            }
        });

        ds_lbl_congcu[1].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int idcourse = Integer.parseInt(courseComboBox.getSelectedItem().toString());
                int idperson = Integer.parseInt(personComboBox.getSelectedItem().toString());
                GiangDayDTO gdupdate = new GiangDayDTO(idcourse, idperson);
                System.out.println(idcourse + "" + idperson);
                boolean isSuccess = gaddal.updatecourseinsreuctor(gdupdate);
                getDataForTable();
                System.out.println(isSuccess);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(null, " UPDATE Thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "update Khóa đã tồn tại, xin bạn chọn khóa khác");

                }

            }
        });

        ds_lbl_congcu[2].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
//                int idcourse = Integer.parseInt(courseComboBox.getSelectedItem().toString());
//                int idperson = Integer.parseInt(personComboBox.getSelectedItem().toString());
                boolean isSuccess = gaddal.deletecourseinsreuctor(gd);
                getDataForTable();
                System.out.println(isSuccess);
                if (isSuccess) {
                    JOptionPane.showMessageDialog(null, " DELETE Thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "delete Khóa đã tồn tại, xin bạn chọn khóa khác");

                }

            }
        });

        ds_lbl_congcu[3].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                getDataForTable();
                txt_timkiem_kh.setText("");
                courseComboBox.setSelectedIndex(0);
                personComboBox.setSelectedIndex(0);

            }
        });

        lbl_timkiem_kh.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String keyword = txt_timkiem_kh.getText();
                GiangDayBLL bus = new GiangDayBLL();
                List<Object[]> data = bus.search(keyword);
                updateTableData(data);
            }
        });
    }

    public void inner_imgkh() {
        Imgs im = new Imgs();
        anhkh = new ImageIcon(im.imgs(""));
        ic = anhkh.getImage().getScaledInstance(260, 260, Image.SCALE_AREA_AVERAGING);
        anhkh = new ImageIcon(ic);
        anh = new JLabel(anhkh, JLabel.CENTER);
        anh.setBounds(0, 0, 260, 260);
        pnl_tuongtac.add(anh);
    }

    public void getDataForTable() {
        GiangDayBLL bus = new GiangDayBLL();
        List<Object[]> data = bus.getData();
        updateTableData(data);
    }

    public void KhachHangTBL() {
        String[] colum = {"CourID", "Title", "PersonID", "person_name","online","onsite"};
        Object[][] row = new Object[0][4];
        tblm = new DefaultTableModel(row, colum);
        tbl_kh = new JTable();
        tbl_kh.setModel(tblm);
        tbl_kh.setRowHeight(30);
        tbl_kh.setGridColor(new Color(0, 0, 60));
        tbl_kh.setAutoCreateRowSorter(true);
        tbl_kh.getTableHeader().setBackground(new Color(0, 0, 60));
        tbl_kh.getTableHeader().setForeground(Color.white);
        tbl_kh.setPreferredScrollableViewportSize(new Dimension(970, 270));
        pnl_information.add(new JScrollPane(tbl_kh));
        ListSelectionModel selectionModel = tbl_kh.getSelectionModel();
        selectionModel.addListSelectionListener(selectionListener);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_kh.setDefaultRenderer(Object.class, centerRenderer);

    }

    public void updateTableData(List<Object[]> data) {
        String[] colum = {"CourID", "Title", "PersonID", "person_name","online","onsite"};
        Object[][] row = new Object[data.size()][6];

        for (int i = 0; i < data.size(); i++) {
            row[i][0] = data.get(i)[0];
            row[i][1] = data.get(i)[1];
            row[i][2] = data.get(i)[2];
            row[i][3] = data.get(i)[3];
            row[i][4] = data.get(i)[4];
            row[i][5] = data.get(i)[5];
        }

        tblm.setDataVector(row, colum);
    }

    ListSelectionListener selectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có đang được thay đổi hay không
                int selectedRow = tbl_kh.getSelectedRow(); // Lấy số thứ tự dòng được chọn
                if (selectedRow != -1) { // Nếu có dòng được chọn
                    String courseID = tbl_kh.getValueAt(selectedRow, 0).toString(); // Lấy giá trị của cột Course ID
                    String personID = tbl_kh.getValueAt(selectedRow, 2).toString(); // Lấy giá trị của cột Person ID
                    courseComboBox.setSelectedItem(courseID); // Đưa Course ID vào JComboBox tương ứng
                    personComboBox.setSelectedItem(personID); // Đưa Person ID vào JComboBox tương ứng
                }
            }
        }
    };
}
