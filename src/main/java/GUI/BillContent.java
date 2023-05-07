package GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BillContent extends JPanel {

    private JPanel pnlBillContentTitle;
    private JLabel lblBillContentTitle;
    private JPanel pnlSearchBill;
    private JLabel lblSearchBill;
    private JPanel pnlContentBillDetail;
    private JPanel pnlEdit_ListBill;
    private JPanel pnlbtnEdit_ListBill;
    private JPanel pnlEditBill;
    private JScrollPane scrollFillInforBill;
    private JPanel pnlFillBill;
    private JPanel pnlIdBill;
    private JLabel lblIdBill;
    private JTextField txtIdBill;
    private JPanel pnlNumOfCus;
    private JLabel lblNumOfCus;
    private JTextField txtNumOfCus;
    private JPanel pnlListBill_Ser;
    private JPanel pnlButtonBill;
    private JButton btnAddBill;
    private JButton btnDeleteBill;

    private JButton btnRefreshBill;

    private JPanel pnlIdTourOfBill;
    private JLabel lblTourNameOfBill;
    private JPanel pnlTotalPrice;
    private JLabel lblTotalPrice;
    private JTextField textField;
    private JPanel pnlIdSerOfBill;
    private JLabel lblSerNameOfBill;
    private JComboBox cbxTourNameOfBill;
    private JTextField txtCusNameOfBill;
    private JPanel pnlSclSerNameOfBill;
    private JScrollPane scrollSerName;
    private JPanel pnlSerDetail;
    private JCheckBox chckbxNewCheckBox;
    private JCheckBox chckbxNewCheckBox_1;
    private JCheckBox chckbxNewCheckBox_2;
    private JCheckBox chckbxNewCheckBox_3;

    private JPanel pnlIconSrc_Txt;
    private JTextField txtSearchBill;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JButton btnEditBill;
    private JButton btnListBill;
    private JPanel pnlEdit_ListBillDetail;
    private JPanel pnlCusName;

    private JLabel lblCusName;

    private JPanel pnlBillContent;
    private JScrollPane sclListSer1;
    private JPanel pnlListBill;
    private JPanel pnlListSer1;
    private JTable ser1ListTable;
    private JScrollPane sclListBill;
    private JTable billListTable;
    private CardLayout cardLayoutEdit_ListBillDetail;
    private JButton btnUpdateBill;

    public BillContent() {
        init();
    }

    private void init() {

        setLayout(new BorderLayout(0, 0));

        pnlBillContentTitle = new JPanel();
        pnlBillContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlBillContentTitle, BorderLayout.NORTH);
        pnlBillContentTitle.setLayout(new BorderLayout(0, 0));

        lblBillContentTitle = new JLabel("Bill Manager");
        lblBillContentTitle.setPreferredSize(new Dimension(200, 50));
        lblBillContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblBillContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlBillContentTitle.add(lblBillContentTitle, BorderLayout.NORTH);

        pnlSearchBill = new JPanel();
        pnlSearchBill.setPreferredSize(new Dimension(10, 60));
        pnlBillContentTitle.add(pnlSearchBill, BorderLayout.CENTER);
        pnlSearchBill.setLayout(new BorderLayout(0, 0));

        pnlIconSrc_Txt = new JPanel();
        pnlSearchBill.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        txtSearchBill = new JTextField();
        txtSearchBill.setText("Search Bill");
        pnlIconSrc_Txt.add(txtSearchBill, BorderLayout.CENTER);
        txtSearchBill.setMargin(new Insets(2, 10, 2, 10));
        txtSearchBill.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtSearchBill.setText(null);
                txtSearchBill.requestFocus();;
                Font font = txtSearchBill.getFont();
                font = font.deriveFont(Font.PLAIN|Font.BOLD);
                txtSearchBill.setFont(font);
                txtSearchBill.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = txtSearchBill.getFont();
                font = font.deriveFont(Font.ITALIC);
                txtSearchBill.setFont(font);
                txtSearchBill.setForeground(Color.gray);
                txtSearchBill.setText("Search Bill");
            }
        });

        lblSearchBill = new JLabel("");
        lblSearchBill.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchBill, BorderLayout.EAST);
//		lblSearchBill.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("search.png"))));
        lblSearchBill.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchBill.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchBill.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchBill.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchBill.add(panel_6, BorderLayout.WEST);

        pnlContentBillDetail = new JPanel();
        add(pnlContentBillDetail, BorderLayout.CENTER);
        pnlContentBillDetail.setLayout(new BorderLayout(0, 0));

        pnlEdit_ListBill = new JPanel();
        pnlContentBillDetail.add(pnlEdit_ListBill, BorderLayout.CENTER);
        pnlEdit_ListBill.setLayout(new BorderLayout(0, 0));

        pnlbtnEdit_ListBill = new JPanel();
        pnlbtnEdit_ListBill.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListBill.add(pnlbtnEdit_ListBill, BorderLayout.NORTH);
        pnlbtnEdit_ListBill.setLayout(new BoxLayout(pnlbtnEdit_ListBill, BoxLayout.X_AXIS));

        btnEditBill = new JButton("Edit Bill");
        btnEditBill.setContentAreaFilled(false);
        btnEditBill.setFocusPainted(false);
        btnEditBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListBill.add(btnEditBill);
        btnEditBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListBillDetail.show(pnlEdit_ListBillDetail,"pnlEditBill");
            }
        });

        btnListBill = new JButton("List Bill");
        btnListBill.setContentAreaFilled(false);
        btnListBill.setFocusPainted(false);
        btnListBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListBill.add(btnListBill);
        btnListBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListBillDetail.show(pnlEdit_ListBillDetail,"pnlListBill");
            }
        });

        pnlEdit_ListBillDetail = new JPanel();
        pnlEdit_ListBill.add(pnlEdit_ListBillDetail, BorderLayout.CENTER);
        pnlEdit_ListBillDetail.setLayout(new CardLayout(0, 0));

        pnlEditBill = new JPanel();
        pnlEdit_ListBillDetail.add(pnlEditBill, "pnlEditBill");
        pnlEditBill.setLayout(new BorderLayout(0, 0));

        scrollFillInforBill = new JScrollPane();
        scrollFillInforBill.setBorder(new TitledBorder(null, "Edit Bill", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditBill.add(scrollFillInforBill, BorderLayout.CENTER);

        pnlFillBill = new JPanel();
        pnlFillBill.setBorder(null);
        scrollFillInforBill.setViewportView(pnlFillBill);
        pnlFillBill.setLayout(new GridLayout(0, 2, 0, 0));

        pnlIdBill = new JPanel();
        pnlIdBill.setPreferredSize(new Dimension(320, 35));
        pnlFillBill.add(pnlIdBill);

        lblIdBill = new JLabel("ID Bill");
        lblIdBill.setPreferredSize(new Dimension(125, 25));
        pnlIdBill.add(lblIdBill);

        txtIdBill = new JTextField();
        txtIdBill.setPreferredSize(new Dimension(100, 25));
        pnlIdBill.add(txtIdBill);
        txtIdBill.setColumns(20);

        pnlIdTourOfBill = new JPanel();
        pnlFillBill.add(pnlIdTourOfBill);
        lblTourNameOfBill = new JLabel("Tour name");
        lblTourNameOfBill.setPreferredSize(new Dimension(126, 25));
        pnlIdTourOfBill.add(lblTourNameOfBill);

        cbxTourNameOfBill = new JComboBox();
        cbxTourNameOfBill.setPreferredSize(new Dimension(225, 25));
        pnlIdTourOfBill.add(cbxTourNameOfBill);

        pnlIdSerOfBill = new JPanel();
        pnlFillBill.add(pnlIdSerOfBill);
        lblSerNameOfBill = new JLabel("Service name");
        lblSerNameOfBill.setPreferredSize(new Dimension(125, 25));
        pnlIdSerOfBill.add(lblSerNameOfBill);

        pnlSclSerNameOfBill = new JPanel();
        pnlSclSerNameOfBill.setPreferredSize(new Dimension(225, 25));
        pnlIdSerOfBill.add(pnlSclSerNameOfBill);
        pnlSclSerNameOfBill.setLayout(new BorderLayout(0, 0));

        scrollSerName = new JScrollPane();
        pnlSclSerNameOfBill.add(scrollSerName, BorderLayout.CENTER);

        pnlSerDetail = new JPanel();

        scrollSerName.setViewportView(pnlSerDetail);
        pnlSerDetail.setLayout(new GridLayout(0, 1, 0, 0));

        chckbxNewCheckBox = new JCheckBox("New check box");

        pnlSerDetail.add(chckbxNewCheckBox);

        chckbxNewCheckBox_1 = new JCheckBox("New check box");
        pnlSerDetail.add(chckbxNewCheckBox_1);

        chckbxNewCheckBox_2 = new JCheckBox("New check box");
        pnlSerDetail.add(chckbxNewCheckBox_2);

        chckbxNewCheckBox_3 = new JCheckBox("New check box");
        pnlSerDetail.add(chckbxNewCheckBox_3);

        pnlCusName = new JPanel();
        pnlFillBill.add(pnlCusName);
        lblCusName = new JLabel("Customer name");
        lblCusName.setPreferredSize(new Dimension(125, 25));
        pnlCusName.add(lblCusName);

        txtCusNameOfBill = new JTextField();
        txtCusNameOfBill.setPreferredSize(new Dimension(100, 25));
        txtCusNameOfBill.setColumns(20);
        pnlCusName.add(txtCusNameOfBill);

        pnlNumOfCus = new JPanel();
        pnlNumOfCus.setPreferredSize(new Dimension(320, 35));
        pnlFillBill.add(pnlNumOfCus);


        lblNumOfCus = new JLabel("Number of customers");
        lblNumOfCus.setPreferredSize(new Dimension(125, 25));
        pnlNumOfCus.add(lblNumOfCus);

        txtNumOfCus = new JTextField();
        txtNumOfCus.setPreferredSize(new Dimension(100, 25));
        txtNumOfCus.setColumns(20);
        pnlNumOfCus.add(txtNumOfCus);

        pnlTotalPrice = new JPanel();
        pnlFillBill.add(pnlTotalPrice);

        lblTotalPrice = new JLabel("Total price");
        lblTotalPrice.setPreferredSize(new Dimension(125, 25));
        pnlTotalPrice.add(lblTotalPrice);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 25));
        textField.setColumns(20);
        pnlTotalPrice.add(textField);

        pnlButtonBill = new JPanel();
        pnlButtonBill.setPreferredSize(new Dimension(10, 40));
        pnlEditBill.add(pnlButtonBill, BorderLayout.SOUTH);
        pnlButtonBill.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        btnAddBill = new JButton("Add");
        btnAddBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddBill.setBackground(new Color(66, 165, 243));
        btnAddBill.setFocusPainted(false);
        btnAddBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnAddBill);

        btnUpdateBill = new JButton("Update");
        btnUpdateBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdateBill.setBackground(new Color(66, 165, 243));
        btnUpdateBill.setFocusPainted(false);
        btnUpdateBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnUpdateBill);

        btnDeleteBill = new JButton("Delete");
        btnDeleteBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteBill.setBackground(new Color(66, 165, 243));
        btnDeleteBill.setFocusPainted(false);
        btnDeleteBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnDeleteBill);

        btnRefreshBill = new JButton("Refresh");
        btnRefreshBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshBill.setBackground(new Color(66, 165, 243));
        btnRefreshBill.setFocusPainted(false);
        btnRefreshBill.setPreferredSize(new Dimension(100, 25));
        pnlButtonBill.add(btnRefreshBill);

        // Tạo pnlListBill_Ser gồm pnlListBill ở vị trí Center và pnlListSer1 ở vị trí South
        pnlListBill_Ser = new JPanel();
        pnlListBill_Ser.setBackground(new Color(240, 240, 240));
        pnlEdit_ListBillDetail.add(pnlListBill_Ser, "pnlListBill");
        pnlListBill_Ser.setLayout(new GridLayout(2, 1, 0, 30));
        
        // Tạo JPanel list Bill
        pnlListBill = new JPanel();
        pnlListBill.setBorder(new TitledBorder(null, "List Bill", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListBill_Ser.add(pnlListBill);
        pnlListBill.setLayout(new BorderLayout(0, 0));
        // Tạo Scroll cho list bill
        sclListBill = new JScrollPane();
        pnlListBill.add(sclListBill);

        Object [][] data4 = {
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"}


        };

        String [] items4 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
        billListTable = new JTable(data4,items4);
        sclListBill.setViewportView(billListTable);

        // Tạo JPanel list ser1
        pnlListSer1 = new JPanel();
        pnlListBill_Ser.add(pnlListSer1);
        pnlListSer1.setLayout(new BorderLayout(0, 0));

        sclListSer1 = new JScrollPane();
        sclListSer1.setBorder(new TitledBorder(null, "List Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListSer1.add(sclListSer1);

        Object [][] data10 = {
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},


        };
        String [] items10 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
        ser1ListTable = new JTable(data10,items10);
        sclListSer1.setViewportView(ser1ListTable);

        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentBillDetail.add(panel_3, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentBillDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentBillDetail.add(panel_5, BorderLayout.SOUTH);

        // change form

        cardLayoutEdit_ListBillDetail = (CardLayout)(pnlEdit_ListBillDetail.getLayout());

    }
}
