package GUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AccContent extends JPanel {
    private JPanel pnlIconSrc_Txt;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel pnlAccContentTitle;
    private JLabel lblAccContentTitle;
    private JPanel pnlSearchAcc;
    private JLabel lblSearchAcc;
    private JPanel pnlContentAccDetail;
    private JPanel pnlEdit_ListAcc;
    private JPanel pnlbtnEdit_ListAcc;
    private JPanel pnlEditAcc;
    private JScrollPane scrollFillInforAcc;
    private JPanel pnlFillAcc;
    private JPanel pnlIdAcc;
    private JLabel lblIdAcc;
    private JTextField txtIdAcc;
    private JPanel pnlUserNameAcc;
    private JLabel lblUserNameAcc;
    private JTextField txtUserNameAcc;
    private JPanel pnlPassAcc;
    private JLabel lblPassAcc;
    private JTextField txtPassAcc;
    private JPanel pnlPermissionAcc;
    private JLabel lblPermissionAcc;
    private JComboBox cbxPermissionAcc;
    private JPanel pnlButtonAcc;
    private JButton btnAddAcc;
    private JButton btnDeleteAcc;
    private JPanel pnlListAcc;
    private JButton btnEditTour;
    private JButton btnRefreshAcc;
    private JPanel pnlFullName;
    private JPanel pnlEmpOld;
    private JPanel pnlEmpGender;
    private JPanel pnlEmpTel;
    private JLabel lblFullName;
    private JTextField txtEmpName;
    private JLabel lblEmpOld;
    private JLabel lblEmpGender;
    private JTextField txtEmpTel;
    private JLabel lblEmpTel;
    private ButtonGroup bgGenderEmp;
    private JRadioButton rdbtnMaleEmp;
    private JRadioButton rdbtnFemaleEmp;
    private JDateChooser OldEmp;
    private JScrollPane sclListAcc;
    private JTable accListTable;
    private JTextField txtSearchAcc;

    private JButton btnEditAcc;
    private JButton btnListAcc;
    private JPanel pnlEdit_ListAccDetail;
    private CardLayout cardLayoutEdit_ListAccDetail;
    public AccContent() {
        init();
    }

    private void init() {

        setLayout(new BorderLayout(0, 0));

        pnlAccContentTitle = new JPanel();
        pnlAccContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlAccContentTitle, BorderLayout.NORTH);
        pnlAccContentTitle.setLayout(new BorderLayout(0, 0));

        lblAccContentTitle = new JLabel("Account Manager");
        lblAccContentTitle.setPreferredSize(new Dimension(200, 50));
        lblAccContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlAccContentTitle.add(lblAccContentTitle, BorderLayout.NORTH);

        pnlSearchAcc = new JPanel();
        pnlSearchAcc.setPreferredSize(new Dimension(10, 60));
        pnlAccContentTitle.add(pnlSearchAcc, BorderLayout.CENTER);
        pnlSearchAcc.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchAcc.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchAcc = new JTextField();
        txtSearchAcc.setText("Search Account");
        pnlIconSrc_Txt.add(txtSearchAcc, BorderLayout.CENTER);
        txtSearchAcc.setMargin(new Insets(2, 10, 2, 10));
        txtSearchAcc.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchAcc.setText(null);
                txtSearchAcc.requestFocus();;
                Font font = txtSearchAcc.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchAcc.setFont(font);
                txtSearchAcc.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchAcc.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchAcc.setFont(font);
                txtSearchAcc.setForeground(Color.gray);
                txtSearchAcc.setText("Search Account");
            }
        });

        lblSearchAcc = new JLabel("");
        lblSearchAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchAcc, BorderLayout.EAST);
//		lblSearchAcc.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("../images/search.png"))));
        lblSearchAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchAcc.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchAcc.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchAcc.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchAcc.add(panel_6, BorderLayout.WEST);

        pnlContentAccDetail = new JPanel();
        add(pnlContentAccDetail, BorderLayout.CENTER);
        pnlContentAccDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListAcc = new JPanel();
        pnlContentAccDetail.add(pnlEdit_ListAcc, BorderLayout.CENTER);
        pnlEdit_ListAcc.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListAcc = new JPanel();
        pnlbtnEdit_ListAcc.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListAcc.add(pnlbtnEdit_ListAcc, BorderLayout.NORTH);
        pnlbtnEdit_ListAcc.setLayout(new BoxLayout(pnlbtnEdit_ListAcc, BoxLayout.X_AXIS));

        btnEditAcc = new JButton("Edit Account");
        btnEditAcc.setContentAreaFilled(false);
        btnEditAcc.setFocusPainted(false);
        btnEditAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListAcc.add(btnEditAcc);
        btnEditAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListAccDetail.show(pnlEdit_ListAccDetail,"pnlEditAcc");
            }
        });

        btnListAcc = new JButton("List Acccount");
        btnListAcc.setContentAreaFilled(false);
        btnListAcc.setFocusPainted(false);
        btnListAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListAcc.add(btnListAcc);
        btnListAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListAccDetail.show(pnlEdit_ListAccDetail,"pnlListAcc");
            }
        });

        pnlEdit_ListAccDetail = new JPanel();
        pnlEdit_ListAcc.add(pnlEdit_ListAccDetail, BorderLayout.CENTER);
        pnlEdit_ListAccDetail.setLayout(new CardLayout(0, 0));

        pnlEditAcc = new JPanel();
        pnlEdit_ListAccDetail.add(pnlEditAcc, "pnlEditAcc");
        pnlEditAcc.setLayout(new BorderLayout(0, 0));

        scrollFillInforAcc = new JScrollPane();
        scrollFillInforAcc.setBorder(new TitledBorder(null, "Edit Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditAcc.add(scrollFillInforAcc, BorderLayout.CENTER);

        pnlFillAcc = new JPanel();
        pnlFillAcc.setBorder(null);
        scrollFillInforAcc.setViewportView(pnlFillAcc);
        pnlFillAcc.setLayout(new GridLayout(8, 1, 0, 0));

        pnlIdAcc = new JPanel();
        pnlIdAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlIdAcc);
        pnlIdAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIdAcc = new JLabel("ID Account");
        lblIdAcc.setPreferredSize(new Dimension(125, 25));
        pnlIdAcc.add(lblIdAcc);

        txtIdAcc = new JTextField();
        txtIdAcc.setPreferredSize(new Dimension(100, 25));
        pnlIdAcc.add(txtIdAcc);
        txtIdAcc.setColumns(20);

        pnlUserNameAcc = new JPanel();
        pnlUserNameAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlUserNameAcc);
        pnlUserNameAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblUserNameAcc = new JLabel("User name");
        lblUserNameAcc.setPreferredSize(new Dimension(125, 25));
        pnlUserNameAcc.add(lblUserNameAcc);

        txtUserNameAcc = new JTextField();
        txtUserNameAcc.setPreferredSize(new Dimension(100, 25));
        txtUserNameAcc.setColumns(20);
        pnlUserNameAcc.add(txtUserNameAcc);

        pnlPassAcc = new JPanel();
        pnlPassAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlPassAcc);
        pnlPassAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblPassAcc = new JLabel("Password");
        lblPassAcc.setPreferredSize(new Dimension(125, 25));
        pnlPassAcc.add(lblPassAcc);

        txtPassAcc = new JTextField();
        txtPassAcc.setPreferredSize(new Dimension(100, 25));
        txtPassAcc.setColumns(20);
        pnlPassAcc.add(txtPassAcc);

        pnlPermissionAcc = new JPanel();
        pnlPermissionAcc.setPreferredSize(new Dimension(320, 35));
        pnlFillAcc.add(pnlPermissionAcc);
        pnlPermissionAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblPermissionAcc = new JLabel("Permission");
        lblPermissionAcc.setPreferredSize(new Dimension(125, 25));
        pnlPermissionAcc.add(lblPermissionAcc);

        cbxPermissionAcc = new JComboBox();
        cbxPermissionAcc.setPreferredSize(new Dimension(225, 25));
        cbxPermissionAcc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cbxPermissionAcc.setModel(new DefaultComboBoxModel(new String[]{"Admin", "Customer management staff", "Tour management staff", "Accountant"}));
        pnlPermissionAcc.add(cbxPermissionAcc);

        pnlFullName = new JPanel();
        pnlFillAcc.add(pnlFullName);

        lblFullName = new JLabel("Employee name");
        lblFullName.setPreferredSize(new Dimension(125, 25));
        pnlFullName.add(lblFullName);

        txtEmpName = new JTextField();
        txtEmpName.setPreferredSize(new Dimension(100, 25));
        txtEmpName.setColumns(20);
        pnlFullName.add(txtEmpName);

        pnlEmpOld = new JPanel();
        pnlFillAcc.add(pnlEmpOld);

        lblEmpOld = new JLabel("Date of birth");
        lblEmpOld.setPreferredSize(new Dimension(125, 25));
        pnlEmpOld.add(lblEmpOld);

        OldEmp = new JDateChooser();
        OldEmp.setPreferredSize(new Dimension(225, 25));
        pnlEmpOld.add(OldEmp);

        pnlEmpGender = new JPanel();
        pnlFillAcc.add(pnlEmpGender);
        pnlEmpGender.setLayout(new FlowLayout(FlowLayout.CENTER, 85, 5));

        lblEmpGender = new JLabel("Gender");
        lblEmpGender.setPreferredSize(new Dimension(43, 25));
        pnlEmpGender.add(lblEmpGender);

        bgGenderEmp = new ButtonGroup();
        rdbtnMaleEmp = new JRadioButton("Male");
        rdbtnMaleEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnMaleEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnMaleEmp.setFocusPainted(false);
        rdbtnMaleEmp.setPreferredSize(new Dimension(72, 25));
        pnlEmpGender.add(rdbtnMaleEmp);
        bgGenderEmp.add(rdbtnMaleEmp);

        rdbtnFemaleEmp = new JRadioButton("Female");
        rdbtnFemaleEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rdbtnFemaleEmp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        rdbtnFemaleEmp.setFocusPainted(false);
        rdbtnFemaleEmp.setPreferredSize(new Dimension(73, 25));
        pnlEmpGender.add(rdbtnFemaleEmp);
        bgGenderEmp.add(rdbtnFemaleEmp);

        pnlEmpTel = new JPanel();
        pnlFillAcc.add(pnlEmpTel);

        lblEmpTel = new JLabel("Phone number");
        lblEmpTel.setPreferredSize(new Dimension(125, 25));
        pnlEmpTel.add(lblEmpTel);

        txtEmpTel = new JTextField();
        txtEmpTel.setPreferredSize(new Dimension(100, 25));
        txtEmpTel.setColumns(20);
        pnlEmpTel.add(txtEmpTel);

        pnlButtonAcc = new JPanel();
        pnlButtonAcc.setPreferredSize(new Dimension(10, 40));
        pnlEditAcc.add(pnlButtonAcc, BorderLayout.SOUTH);
        pnlButtonAcc.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddAcc = new JButton("Add");
        btnAddAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddAcc.setFocusPainted(false);
        btnAddAcc.setBackground(new Color(66, 165, 243));
        btnAddAcc.setPreferredSize(new Dimension(100, 25));
        pnlButtonAcc.add(btnAddAcc);

        btnDeleteAcc = new JButton("Delete");
        btnDeleteAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteAcc.setFocusPainted(false);
        btnDeleteAcc.setBackground(new Color(66, 165, 243));
        btnDeleteAcc.setPreferredSize(new Dimension(100, 25));
        pnlButtonAcc.add(btnDeleteAcc);

        btnRefreshAcc = new JButton("Refresh");
        btnRefreshAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshAcc.setFocusPainted(false);
        btnRefreshAcc.setBackground(new Color(66, 165, 243));
        btnRefreshAcc.setPreferredSize(new Dimension(100, 25));
        pnlButtonAcc.add(btnRefreshAcc);

        pnlListAcc = new JPanel();
        pnlListAcc.setBorder(new TitledBorder(null, "List Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListAcc.setBackground(new Color(240, 240, 240));
        pnlEdit_ListAccDetail.add(pnlListAcc, "pnlListAcc");
        pnlListAcc.setLayout(new BorderLayout(0, 0));

        sclListAcc = new JScrollPane();
        pnlListAcc.add(sclListAcc, BorderLayout.CENTER);

        Object[][] data7 = {{"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}, {"111", "Nha Trang", "Miền Trung", "20", "20", "20", "20"}

        };

        String[] items7 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
        accListTable = new JTable(data7, items7);
        sclListAcc.setViewportView(accListTable);

        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentAccDetail.add(panel_3, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentAccDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentAccDetail.add(panel_5, BorderLayout.SOUTH);

        // change form
        cardLayoutEdit_ListAccDetail = (CardLayout) (pnlEdit_ListAccDetail.getLayout());
    }
}
