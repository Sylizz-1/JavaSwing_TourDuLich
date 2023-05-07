package GUI;

import BUS.HotelBUS;
import BUS.RegionBUS;
import BUS.TourBUS;
import DAO.HotelDAO;
import DTO.HotelDTO;
import DTO.PlaceDTO;
import DTO.RegionDTO;
import DTO.TourDTO;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class TourContent extends JPanel{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
    private JPanel pnlListTour_Place;
    private JTable tourListTable;
    private JPanel pnlListPlace;

    private JScrollPane sclListPlace;
    private JTable placeListTable;
    private JButton btnUpdateTour;

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
    private JPanel pnlHotel;
    private JLabel lblHotel;
    private JComboBox cbxHotel;
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

    DefaultTableModel model_tour;
    DefaultTableModel model_place ;




    public TourContent() {
        setUpTable();
        init();
        loadTourData();
        btnInteract();
    }

    private void setUpTable() {
        model_tour = new DefaultTableModel();
        model_tour.addColumn("Id");
        model_tour.addColumn("Name");
        model_tour.addColumn("Hotel");
        model_tour.addColumn("Region");
        model_tour.addColumn("Price");
        model_tour.addColumn("Start_day");
        model_tour.addColumn("End_day");
        model_tour.addColumn("Departure");
        model_tour.addColumn("Descirbe");
        model_tour.addColumn("Create at");

        model_place = new DefaultTableModel();
        model_place.addColumn("id");
        model_place.addColumn("Name");
        model_place.addColumn("Describe");
        model_place.addColumn("Address");
        model_place.addColumn("region");
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

        pnlHotel = new JPanel();
        pnlHotel.setPreferredSize(new Dimension(320, 35));
        pnlFillTour.add(pnlHotel);
        pnlHotel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        lblHotel = new JLabel("Hotel");
        lblHotel.setPreferredSize(new Dimension(125, 25));
        pnlHotel.add(lblHotel);

        cbxHotel = new JComboBox();
        cbxHotel.setPreferredSize(new Dimension(166, 25));
        cbxHotel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//        cbxHotel.setModel(new DefaultComboBoxModel(new String[] {"ádvcx", "ádasd", "xcv" , "xcva123"}));
//        cbxHotel.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                System.out.println(cbxHotel.getSelectedItem());
//            }
//        });
        pnlHotel.add(cbxHotel);

        pnlPriceTour = new JPanel();


        lblPriceTour = new JLabel("Price");
        lblPriceTour.setPreferredSize(new Dimension(125, 25));
        pnlPriceTour.add(lblPriceTour);

        txtPriceTour = new JTextField();
        txtPriceTour.setText("abc");
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
        pnlFillTour.add(pnlPriceTour);


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

        // Tạo nút update
        btnUpdateTour = new JButton("Update");
        btnUpdateTour.setBackground(new Color(66, 165, 243));
        btnUpdateTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdateTour.setFocusPainted(false);
        btnUpdateTour.setPreferredSize(new Dimension(100, 25));
        pnlButtonTour.add(btnUpdateTour);

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
        // Tạo pnlListTour_Place gồm pnlListTour ở vị trí Center và pnlListPlace ở vị trí South
        pnlListTour_Place = new JPanel();
        pnlListTour_Place.setBackground(new Color(240, 240, 240));
        pnlEdit_ListTourDetail.add(pnlListTour_Place, "pnlListTour");
        pnlListTour_Place.setLayout(new GridLayout(2, 1, 0, 30));

        // Tạo JPanel list Tour
        pnlListTour = new JPanel();
        pnlListTour.setBorder(new TitledBorder(null, "List Tour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListTour_Place.add(pnlListTour);
        pnlListTour.setLayout(new BorderLayout(0, 0));
        // Tạo Scroll cho list Tour
        sclListTour = new JScrollPane();
        pnlListTour.add(sclListTour);

//        String [] items4 = {"ID", "Name", "Hotel", "Price", "Start_day", "End_day", "Departure","Describe","create at"};

        tourListTable = new JTable();
        sclListTour.setViewportView(tourListTable);

        // Tạo JPanel list ser1
        pnlListPlace = new JPanel();
        pnlListTour_Place.add(pnlListPlace);
        pnlListPlace.setLayout(new BorderLayout(0, 0));

        sclListPlace = new JScrollPane();
        sclListPlace.setBorder(new TitledBorder(null, "Places of tour", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        pnlListPlace.add(sclListPlace);


        placeListTable = new JTable();
        sclListPlace.setViewportView(placeListTable);

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

    // load data from database
    private void loadTourData() {
        // load tour table
        TourBUS tb = new TourBUS();
        ArrayList<TourDTO> tours = tb.getAll();
        for (TourDTO tour : tours) {
            model_tour.addRow(new Object[]{
                    tour.getTour_id(),
                    tour.getTour_name(),
                    tour.getHotel_id(),
                    tour.getRegion_code(),
                    tour.getPrice(),
                    tour.getStart_day().toString(),
                    tour.getEnd_day().toString(),
                    tour.getDeparture_place(),
                    tour.getSchedule_describe(),
                    tour.getCreate_at().toString()
            });
        }
        tourListTable.setModel(model_tour);

        // load combobox hotel
        DefaultComboBoxModel<String> model_hotel = new DefaultComboBoxModel<String>();
        HotelBUS ht = new HotelBUS();
        ArrayList<HotelDTO> hotels = ht.getAll();

        for (HotelDTO hotel : hotels) {
           model_hotel.addElement(hotel.getHotel_id() + "-" + hotel.getHotel_name());
        }
        cbxHotel.setModel(model_hotel);

        // load combobox region
        DefaultComboBoxModel<String> model_region = new DefaultComboBoxModel<String>();
        RegionBUS reg = new RegionBUS();
        ArrayList<RegionDTO> regions = reg.getAll();

        for (RegionDTO region : regions) {
            model_region.addElement(region.getRegion_code());
        }
        cbxDesTour.setModel(model_region);

    }

    private void btnInteract() {
        tourListTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    tourListTableMouseClicked( e);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnAddTour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddTourActionPerformed( e);
            }
        });
    }

    private void tourListTableMouseClicked(MouseEvent e) throws ParseException {

        // load Places of tour
        int row = tourListTable.getSelectedRow();

        TourBUS tb = new TourBUS();
        ArrayList<PlaceDTO> places = tb.getPlacesOfTour(Integer.parseInt(tourListTable.getValueAt(row,0).toString()) );
        while (model_place.getRowCount() >= 1){
            model_place.removeRow(0);
        }
        for (PlaceDTO place : places) {
            model_place.addRow(new Object[]{
                    place.getPlace_id(),
                    place.getPlace_name(),
                    place.getPlace_describe(),
                    place.getPlace_address(),
                    place.getRegion_code()
            });
        }
        placeListTable.setModel(model_place);

        // load form of Tour
        txtIdTour.setText(tourListTable.getValueAt(row,0).toString());
        txtNameTour.setText(tourListTable.getValueAt(row,1).toString());
        cbxDepTour.setSelectedItem(tourListTable.getValueAt(row,7));
        cbxDesTour.setSelectedItem(tourListTable.getValueAt(row,3));
        HotelBUS hb = new HotelBUS();
        HotelDTO hd = hb.getById(Integer.parseInt(tourListTable.getValueAt(row,2).toString()) );
        cbxHotel.setSelectedItem(hd.getHotel_id() + "-" + hd.getHotel_name());
        String date = tourListTable.getValueAt(row,5).toString();
        StartDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        date = tourListTable.getValueAt(row,6).toString();
        EndDay.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        txtSchedule.setText(tourListTable.getValueAt(row,8).toString());
        txtPriceTour.setText(tourListTable.getValueAt(row,4).toString());
    }

    private void btnAddTourActionPerformed(ActionEvent e) {
        String id = txtIdTour.getText(),
                name = txtNameTour.getText(),
                dep = Objects.requireNonNull(cbxDepTour.getSelectedItem()).toString(),
                reion = Objects.requireNonNull(cbxDepTour.getSelectedItem()).toString(),
                hotel = Objects.requireNonNull(cbxHotel.getSelectedItem()).toString(),
                startday = sdf.format(StartDay.getDate()),
                endday = sdf.format(EndDay.getDate()),
                desc =  txtSchedule.getText(),
                price = txtPriceTour.getText();
    }
}
