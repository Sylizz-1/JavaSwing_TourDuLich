package GUI;

import com.toedter.calendar.JDateChooser;
import controller.ManagerControl;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

public class TourContent extends JPanel{
    
    private JPanel pnlTourContentTitle;
    private JLabel lblTourContentTitle;
    private CardLayout cardLayoutEdit_ListTourDetail;

    private JPanel pnlSearchTour;
    private JPanel pnlIconSrc_Txt;
    private JLabel lblSearchTour;
    private JTextField txtSearchTour;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_6;
    private JPanel pnlContentTourDetail;
    private JPanel pnlEdit_ListTour;
    private JPanel pnlbtnEdit_ListTour;
    private JButton btnListTour;
    private JPanel pnlEdit_ListTourDetail;
    public JPanel getPnlEdit_ListTourDetail() {
        return pnlEdit_ListTourDetail;
    }
    private JPanel pnlEditTour;
    private JScrollPane scrollFillInforTour;
    private JPanel pnlFillTour;
    private JPanel pnlIdTour;
    private JLabel lblIdTour;
    private JTextField txtIdTour;
    private JPanel pnlNameTour;
    private JLabel lblNameTour;
    private JTextField txtNameTour;
    private JPanel pnlDesTour;
    private JLabel lblDesTour;
    private JComboBox cbxDesTour;
    private JPanel pnlNumOfPeople;
    private JLabel lblNumOfPeople;
    private JComboBox cbxNumOfPeople;
    private JPanel pnlButtonTour;
    private JButton btnAddTour;
    private JButton btnDeleteTour;
    private JPanel pnlListTour;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;

    private JButton btnEditTour;

    private JPanel pnlPriceTour;
    private JPanel pnlStartDay;
    private JPanel pnlEndDay;
    private JPanel pnlDepTour;
    private JLabel lblPriceTour;
    private JTextField txtPriceTour;
    private JLabel lblDepTour;
    private JDateChooser StartDay;
    private JLabel lblStartDay;
    private JLabel lblEndDay;
    private JDateChooser EndDay;

    private JButton btnRefreshTour;

    private JPanel pnlSchedule;
    private JLabel lblSchedule;
    private JTextField txtSchedule;

    private JComboBox cbxDepTour;

    private JScrollPane sclListTour;

    public TourContent() {
        init();
    }

    private void init() {

        
    	setLayout(new BorderLayout(0, 0));

        // Tạo JPanel cho phần tiêu đề của quản lý tour
        pnlTourContentTitle = new JPanel();
        pnlTourContentTitle.setPreferredSize(new Dimension(10, 125));
        add(pnlTourContentTitle, BorderLayout.NORTH);
        pnlTourContentTitle.setLayout(new BorderLayout(0, 0));

        // Tạo JLabel với nhãn là Tour Manager
        lblTourContentTitle = new JLabel("Tour Manager");
        lblTourContentTitle.setPreferredSize(new Dimension(200, 50));
        lblTourContentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTourContentTitle.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        pnlTourContentTitle.add(lblTourContentTitle, BorderLayout.NORTH);

        // Tạo JPanel search tour
        pnlSearchTour = new JPanel();
        pnlSearchTour.setPreferredSize(new Dimension(10, 60));
        pnlTourContentTitle.add(pnlSearchTour, BorderLayout.CENTER);
        pnlSearchTour.setLayout(new BorderLayout(0, 0));

        // Tạo pnlIconSrc_Txt để chứa thanh tìm kiếm và icon tìm kiếm
        pnlIconSrc_Txt = new JPanel();
        pnlSearchTour.add(pnlIconSrc_Txt, BorderLayout.CENTER);
        pnlIconSrc_Txt.setLayout(new BorderLayout(0, 0));

        // Tạo thanh tìm kiếm
        txtSearchTour = new JTextField();
        txtSearchTour.setText("Search Tour");
        pnlIconSrc_Txt.add(txtSearchTour, BorderLayout.CENTER);
        txtSearchTour.setMargin(new Insets(2, 10, 2, 10));
        txtSearchTour.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Font font = txtSearchTour.getFont();
				font = font.deriveFont(Font.ITALIC);
				txtSearchTour.setFont(font);
				txtSearchTour.setForeground(Color.gray);
				txtSearchTour.setText("Search Tour");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtSearchTour.setText(null);
				txtSearchTour.requestFocus();;
//				manager.removePlaceholderStyle(manager.getTxtSearchTour());
				Font font = txtSearchTour.getFont();
				font = font.deriveFont(Font.PLAIN|Font.BOLD);
				txtSearchTour.setFont(font);
				txtSearchTour.setForeground(Color.black);
				
			}
		});

        // Tạo icon tìm kiếm
        lblSearchTour = new JLabel("");
        lblSearchTour.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        pnlIconSrc_Txt.add(lblSearchTour, BorderLayout.EAST);
//		lblSearchTour.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Manager.class.getResource("search.png"))));
        lblSearchTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Các JPanel này để căn chỉnh phần pnlIconSrc_Txt ở giữa
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 20));
        pnlSearchTour.add(panel, BorderLayout.NORTH);

        panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(10, 20));
        pnlSearchTour.add(panel_1, BorderLayout.SOUTH);

        panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(250, 10));
        pnlSearchTour.add(panel_2, BorderLayout.EAST);

        panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(250, 10));
        pnlSearchTour.add(panel_6, BorderLayout.WEST);


        pnlContentTourDetail = new JPanel();
        add(pnlContentTourDetail, BorderLayout.CENTER);
        pnlContentTourDetail.setLayout(new BorderLayout(0, 0));

		/*
		Tạo pnlContentTourDetail phần này sẽ gồm:
		pnlbtnEdit_ListTour ở vị trí North chứa nút chuyển qua lại giữa phần nhập dữ liệu và danh sách
		pnlEdit_ListTour ở vị trí Center chứa phần nhập dữ liệu và danh sách,
		và pnlButtonTour ở vị trí South chứa các nút chức năng thêm, xóa, refesh
		*/
        pnlEdit_ListTour = new JPanel();
        pnlContentTourDetail.add(pnlEdit_ListTour, BorderLayout.CENTER);
        pnlEdit_ListTour.setLayout(new BorderLayout(0, 0));

        // Tạo pnlbtnEdit_ListTour cho quản lý tour phần này sẽ chứa nút Edit Tour và List Tour
        pnlbtnEdit_ListTour = new JPanel();
        pnlbtnEdit_ListTour.setPreferredSize(new Dimension(10, 50));
        pnlEdit_ListTour.add(pnlbtnEdit_ListTour, BorderLayout.NORTH);
        pnlbtnEdit_ListTour.setLayout(new BoxLayout(pnlbtnEdit_ListTour, BoxLayout.X_AXIS));
        // Tạo 2 nút Edit Tour và List Tour
        btnEditTour = new JButton("Edit Tour");
        btnEditTour.setContentAreaFilled(false);
        btnEditTour.setFocusPainted(false);
        btnEditTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListTour.add(btnEditTour);
        btnEditTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pnlEditToure) {
                cardLayoutEdit_ListTourDetail.show(pnlEdit_ListTourDetail,"pnlEditTour");
            }
        });

        btnListTour = new JButton("List Tour");
        btnListTour.setContentAreaFilled(false);
        btnListTour.setFocusPainted(false);
        btnListTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlbtnEdit_ListTour.add(btnListTour);
        btnListTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutEdit_ListTourDetail.show(pnlEdit_ListTourDetail,"pnlListTour");
            }
        });

        // Tạo pnlEdit_ListTourDetail cho quản lý tour phần này sẽ chứa phần nhập dữ liệu và danh sách
        pnlEdit_ListTourDetail = new JPanel();
        pnlEdit_ListTour.add(pnlEdit_ListTourDetail, BorderLayout.CENTER);
        pnlEdit_ListTourDetail.setLayout(new CardLayout(0, 0));

        // Tạo JPanel phần nhập liệu tour
        pnlEditTour = new JPanel();
        pnlEdit_ListTourDetail.add(pnlEditTour, "pnlEditTour");
        pnlEditTour.setLayout(new BorderLayout(0, 0));

        scrollFillInforTour = new JScrollPane();
        scrollFillInforTour.setBorder(new TitledBorder(null, "Edit Tour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlEditTour.add(scrollFillInforTour, BorderLayout.CENTER);

        pnlFillTour = new JPanel();
        pnlFillTour.setBorder(null);
        scrollFillInforTour.setViewportView(pnlFillTour);
        pnlFillTour.setLayout(new GridLayout(5, 2, 0, 0));

        pnlIdTour = new JPanel();
        pnlIdTour.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlIdTour);
        pnlIdTour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblIdTour = new JLabel("ID");
        lblIdTour.setPreferredSize(new Dimension(125, 25));
        pnlIdTour.add(lblIdTour);

        txtIdTour = new JTextField();
        txtIdTour.setPreferredSize(new Dimension(100, 25));
        pnlIdTour.add(txtIdTour);
        txtIdTour.setColumns(15);

        pnlNameTour = new JPanel();
        pnlNameTour.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlNameTour);
        pnlNameTour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblNameTour = new JLabel("Name");
        lblNameTour.setPreferredSize(new Dimension(125, 25));
        pnlNameTour.add(lblNameTour);

        txtNameTour = new JTextField();
        txtNameTour.setPreferredSize(new Dimension(100, 25));
        txtNameTour.setColumns(15);
        pnlNameTour.add(txtNameTour);

        pnlDepTour = new JPanel();
        pnlFillTour.add(pnlDepTour);

        lblDepTour = new JLabel("Departure");
        lblDepTour.setPreferredSize(new Dimension(125, 25));
        pnlDepTour.add(lblDepTour);

        cbxDepTour = new JComboBox();
        cbxDepTour.setPreferredSize(new Dimension(166, 25));
        cbxDepTour.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cbxDepTour.setModel(new DefaultComboBoxModel(new String[] {"An Giang", "Bà Rịa-Vũng Tàu", "Bạc Liêu",
                "Bắc Kạn","Bắc Giang","Bắc Ninh","Bến Tre","Bình Dương","Bình Định","Bình Phước","Bình Thuận","Cà Mau",
                "Cao Bằng","Cần Thơ","Đà Nẵng","Đắk Lắk","Đắk Nông","Điện Biên","Đồng Nai","Đồng Tháp","Gia Lai",
                "Hà Giang","Hà Nam","Hà Nội","Hà Tây","Hà Tĩnh","Hải Dương","Hải Phòng","Hòa Bình","Hồ Chí Minh",
                "Hậu Giang","Hưng Yên","Khánh Hòa","Kiên Giang","Kon Tum","Lai Châu","Lào Cai","Lạng Sơn","Lâm Đồng",
                "Long An","Nam Định","Nghệ An","Ninh Bình","Ninh Thuận","Phú Thọ","Phú Yên","Quảng Bình","Quảng Nam",
                "Quảng Ngãi","Quảng Ninh","Quảng Trị","Sóc Trăng","Sơn La","Tây Ninh","Thái Bình","Thái Nguyên","Thanh Hóa",
                "Thừa Thiên - Huế","Tiền Giang","Trà Vinh","Tuyên Quang","Vĩnh Long","Vĩnh Phúc","Yên Bái"}));
        pnlDepTour.add(cbxDepTour);

        pnlDesTour = new JPanel();
        pnlDesTour.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlDesTour);
        pnlDesTour.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblDesTour = new JLabel("Destination");
        lblDesTour.setPreferredSize(new Dimension(125, 25));
        pnlDesTour.add(lblDesTour);

        cbxDesTour = new JComboBox();
        cbxDesTour.setPreferredSize(new Dimension(166, 25));
        cbxDesTour.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cbxDesTour.setModel(new DefaultComboBoxModel(new String[] {"An Giang", "Bà Rịa-Vũng Tàu", "Bạc Liêu",
                "Bắc Kạn","Bắc Giang","Bắc Ninh","Bến Tre","Bình Dương","Bình Định","Bình Phước","Bình Thuận","Cà Mau",
                "Cao Bằng","Cần Thơ","Đà Nẵng","Đắk Lắk","Đắk Nông","Điện Biên","Đồng Nai","Đồng Tháp","Gia Lai",
                "Hà Giang","Hà Nam","Hà Nội","Hà Tây","Hà Tĩnh","Hải Dương","Hải Phòng","Hòa Bình","Hồ Chí Minh",
                "Hậu Giang","Hưng Yên","Khánh Hòa","Kiên Giang","Kon Tum","Lai Châu","Lào Cai","Lạng Sơn","Lâm Đồng",
                "Long An","Nam Định","Nghệ An","Ninh Bình","Ninh Thuận","Phú Thọ","Phú Yên","Quảng Bình","Quảng Nam",
                "Quảng Ngãi","Quảng Ninh","Quảng Trị","Sóc Trăng","Sơn La","Tây Ninh","Thái Bình","Thái Nguyên","Thanh Hóa",
                "Thừa Thiên - Huế","Tiền Giang","Trà Vinh","Tuyên Quang","Vĩnh Long","Vĩnh Phúc","Yên Bái"}));
        pnlDesTour.add(cbxDesTour);

        pnlNumOfPeople = new JPanel();
        pnlNumOfPeople.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlNumOfPeople);
        pnlNumOfPeople.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblNumOfPeople = new JLabel("Number of peoples");
        lblNumOfPeople.setPreferredSize(new Dimension(125, 25));
        pnlNumOfPeople.add(lblNumOfPeople);

        cbxNumOfPeople = new JComboBox();
        cbxNumOfPeople.setPreferredSize(new Dimension(166, 25));
        cbxNumOfPeople.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cbxNumOfPeople.setModel(new DefaultComboBoxModel(new String[] {"29", "35", "45" , "50"}));
        pnlNumOfPeople.add(cbxNumOfPeople);

        pnlPriceTour = new JPanel();
        pnlFillTour.add(pnlPriceTour);

        lblPriceTour = new JLabel("Price");
        lblPriceTour.setPreferredSize(new Dimension(125, 25));
        pnlPriceTour.add(lblPriceTour);

        txtPriceTour = new JTextField();
        txtPriceTour.setPreferredSize(new Dimension(100, 25));
        pnlPriceTour.add(txtPriceTour);
        txtPriceTour.setColumns(15);

        pnlStartDay = new JPanel();
        pnlFillTour.add(pnlStartDay);

        lblStartDay = new JLabel("Start day");
        lblStartDay.setPreferredSize(new Dimension(125, 25));
        pnlStartDay.add(lblStartDay);

        StartDay = new JDateChooser();
        StartDay.setPreferredSize(new Dimension(166, 25));
        pnlStartDay.add(StartDay);

        pnlEndDay = new JPanel();
        pnlFillTour.add(pnlEndDay);

        lblEndDay = new JLabel("End day");
        lblEndDay.setPreferredSize(new Dimension(125, 25));
        pnlEndDay.add(lblEndDay);

        EndDay = new JDateChooser();
        EndDay.setBorder(null);
        EndDay.setPreferredSize(new Dimension(166, 25));
        pnlEndDay.add(EndDay);

        pnlSchedule = new JPanel();
        pnlFillTour.add(pnlSchedule);

        lblSchedule = new JLabel("Schedule describe");
        lblSchedule.setPreferredSize(new Dimension(125, 25));
        pnlSchedule.add(lblSchedule);

        txtSchedule = new JTextField();
        txtSchedule.setPreferredSize(new Dimension(100, 25));
        txtSchedule.setColumns(15);
        pnlSchedule.add(txtSchedule);

        // Tạo pnlButtonTour phần này sẽ chứa các nút chức năng
        pnlButtonTour = new JPanel();
        pnlButtonTour.setBorder(null);
        pnlButtonTour.setPreferredSize(new Dimension(10, 40));
        pnlEditTour.add(pnlButtonTour, BorderLayout.SOUTH);
        pnlButtonTour.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));

        // Tạo nút thêm
        btnAddTour = new JButton("Add");
        btnAddTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddTour.setBackground(new Color(66, 165, 243));
        btnAddTour.setFocusPainted(false);
        btnAddTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnAddTour);
        
        // Tạo nút xóa
        btnDeleteTour = new JButton("Delete");
        btnDeleteTour.setBackground(new Color(66, 165, 243));
        btnDeleteTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeleteTour.setFocusPainted(false);
        btnDeleteTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnDeleteTour);

        // Tạo nút refresh
        btnRefreshTour = new JButton("Refresh");
        btnRefreshTour.setBackground(new Color(66, 165, 243));
        btnRefreshTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRefreshTour.setFocusPainted(false);
        btnRefreshTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnRefreshTour);

        // Tạo JPanel phần danh sách tour
        pnlListTour = new JPanel();
        pnlListTour.setBorder(new TitledBorder(null, "List Tour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListTour.setBackground(new Color(240, 240, 240));
        pnlEdit_ListTourDetail.add(pnlListTour, "pnlListTour");
        pnlListTour.setLayout(new BorderLayout(0, 0));

        sclListTour = new JScrollPane();
        pnlListTour.add(sclListTour, BorderLayout.CENTER);

        Object [][] data1 = {
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
                {"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"}

        };

        String [] items1 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
        JTable tourListTable = new JTable(data1, items1);
        sclListTour.setViewportView(tourListTable);

        // panel_3, panel_4, panel_5 này để căn chỉnh phần pnlEdit_ListTour đẹp hơn thôi
        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(50, 10));
        pnlContentTourDetail.add(panel_3, BorderLayout.EAST);

        panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(50, 10));
        pnlContentTourDetail.add(panel_4, BorderLayout.WEST);

        panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 60));
        pnlContentTourDetail.add(panel_5, BorderLayout.SOUTH);


        // ------------ Change Form -------------------- //

         cardLayoutEdit_ListTourDetail =  (CardLayout)(this.getPnlEdit_ListTourDetail().getLayout());

    }
}
