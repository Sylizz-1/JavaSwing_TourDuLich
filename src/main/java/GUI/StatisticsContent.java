package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatisticsContent extends JPanel {

	private JPanel pnlStatisticsList;
	private JButton btnStatisticBooking;
	private JButton btnStatisticTour;
	private JButton btnStatisticCustomer;
	private JPanel pnlStatisticContent;
	private JPanel pnlStatisticsBy;
	private JPanel panel_4;
	private JLabel lblBy;
	private JRadioButton rdbtnByYear_Booking;
	private JLabel lblNewLabel_4;
	private JRadioButton rdbtnByMonth_Booking;
	private JPanel panel_5;
	private JLabel lblSelectMonth;
	private JComboBox cbxMonth_Booking;
	private JLabel lblSelectYear;
	private JLabel lblNewLabel_3;
	private JPanel panel_6;
	private JButton btnShowChart_Booking;
	private JPanel pnlDetailBookingList;
	private JComboBox cbxYear_Booking;
	private JPanel pnlTourList;
	private JPanel pnlBookingList;
	private JPanel pnlCustomerList;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTable BookingTable;
	private JTable TourTable;

	private JPanel pnlBookingStatistical;
	private JPanel pnlTourStatistical;
	private JPanel pnlCusStatistical;
	private JButton btnView_Booking;
	private JRadioButton rdbtnByYear_Tour;
	private JRadioButton rdbtnByMonth_Tour;
	private JComboBox cbxMonth_Tour;
	private JComboBox cbxYear_Tour;
	private JButton btnShowChart_Tour;
	private JButton btnView_Tour;
	private JPanel pnlDetailTourList;
	private JRadioButton rdbtnByYear_Cus;
	private JRadioButton rdbtnByMonth_Cus;
	private JComboBox cbxMonth_Cus;
	private JComboBox cbxYear_Cus;
	private JButton btnShowChart_Cus;
	private JButton btnView_Cus;
	private JPanel pnlDetailCusList;
	private JTable CusTable;
	
	private CardLayout cardLayoutPnlContent;
	public JPanel getPnlStatisticContent() {
		return pnlStatisticContent;
	}

	public void setPnlStatisticContent(JPanel pnlStatisticContent) {
		this.pnlStatisticContent = pnlStatisticContent;
	}

	public JPanel getPnlBookingList() {
		return pnlBookingList;
	}

	public void setPnlBookingList(JPanel pnlBookingList) {
		this.pnlBookingList = pnlBookingList;
	}

	public JPanel getPnlTourList() {
		return pnlTourList;
	}

	public void setPnlTourList(JPanel pnlTourList) {
		this.pnlTourList = pnlTourList;
	}

	public JPanel getPnlCustomerList() {
		return pnlCustomerList;
	}

	public void setPnlCustomerList(JPanel pnlCustomerList) {
		this.pnlCustomerList = pnlCustomerList;
	}


	public StatisticsContent() {
        init();     
    }
	
	public void init() {
		
		setLayout(new BorderLayout(0, 0));
		
		pnlStatisticsList = new JPanel();
		add(pnlStatisticsList, BorderLayout.NORTH);
		pnlStatisticsList.setLayout(new BoxLayout(pnlStatisticsList, BoxLayout.X_AXIS));
		
		btnStatisticBooking = new JButton("Booking");
		btnStatisticBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutPnlContent.show(pnlStatisticContent,"pnlBookingStatistical");
			}
		});
		btnStatisticBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStatisticBooking.setFocusPainted(false);
		pnlStatisticsList.add(btnStatisticBooking);
		
		btnStatisticTour = new JButton("  Tour  ");
		btnStatisticTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutPnlContent.show(pnlStatisticContent,"pnlTourStatistical");
			}
		});
		btnStatisticTour.setFocusPainted(false);
		btnStatisticTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlStatisticsList.add(btnStatisticTour);
		
		btnStatisticCustomer = new JButton("Customer");
		btnStatisticCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutPnlContent.show(pnlStatisticContent,"pnlCustomerStatistical");
			}
		});
		btnStatisticCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStatisticCustomer.setFocusPainted(false);
		pnlStatisticsList.add(btnStatisticCustomer);
		
		
		pnlStatisticContent = new JPanel();
		add(pnlStatisticContent, BorderLayout.CENTER);
		pnlStatisticContent.setLayout(new CardLayout(0, 0));
		
		pnlBookingStatistical = new JPanel();
		pnlStatisticContent.add(pnlBookingStatistical, "pnlBookingStatistical");
		pnlBookingStatistical.setLayout(new BorderLayout(0, 0));
		
		
		pnlStatisticsBy = new JPanel();
		pnlStatisticsBy.setPreferredSize(new Dimension(10, 80));
		pnlBookingStatistical.add(pnlStatisticsBy, BorderLayout.NORTH);
		pnlStatisticsBy.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 25));
		pnlStatisticsBy.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		lblBy = new JLabel(" Statistics By             ");
		panel_4.add(lblBy);
		
		rdbtnByYear_Booking = new JRadioButton("By year");
		rdbtnByYear_Booking.setFocusPainted(false);
		rdbtnByYear_Booking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByYear_Booking);
		
		lblNewLabel_4 = new JLabel("             ");
		panel_4.add(lblNewLabel_4);
		
		rdbtnByMonth_Booking = new JRadioButton("By month of the year");
		rdbtnByMonth_Booking.setFocusPainted(false);
		rdbtnByMonth_Booking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByMonth_Booking);
		
		panel_5 = new JPanel();
		pnlStatisticsBy.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSelectMonth = new JLabel("Select Month           ");
		panel_5.add(lblSelectMonth);
		
		cbxMonth_Booking = new JComboBox();
		cbxMonth_Booking.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		panel_5.add(cbxMonth_Booking);
		
		lblSelectYear = new JLabel("                    Select Year            ");
		panel_5.add(lblSelectYear);
		
		cbxYear_Booking = new JComboBox();
		cbxYear_Booking.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021", "2022", "2023"}));
		panel_5.add(cbxYear_Booking);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(92, 14));
		panel_5.add(lblNewLabel_3);
		
		panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(10, 30));
		pnlStatisticsBy.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		btnShowChart_Booking = new JButton("  Chart  ");
		btnShowChart_Booking.setFocusPainted(false);
		btnShowChart_Booking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart_Booking);
		
		btnView_Booking = new JButton("View");
		btnView_Booking.setFocusPainted(false);
		panel_6.add(btnView_Booking);
		
		pnlDetailBookingList = new JPanel();
		pnlDetailBookingList.setLayout(new CardLayout(0, 0));
		pnlDetailBookingList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlBookingStatistical.add(pnlDetailBookingList, BorderLayout.CENTER);
		
		scrollPane_1 = new JScrollPane();
		pnlDetailBookingList.add(scrollPane_1, BorderLayout.CENTER);
		
		Object [][] data14 = {
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
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"}
      
		};

		String [] items14 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
		BookingTable = new JTable(data14, items14);
		scrollPane_1.setViewportView(BookingTable);
		
		//----------------------------------------------------------
		pnlTourStatistical = new JPanel();
		pnlStatisticContent.add(pnlTourStatistical, "pnlTourStatistical");
		pnlTourStatistical.setLayout(new BorderLayout(0, 0));
		
		pnlStatisticsBy = new JPanel();
		pnlStatisticsBy.setPreferredSize(new Dimension(10, 80));
		pnlTourStatistical.add(pnlStatisticsBy, BorderLayout.NORTH);
		pnlStatisticsBy.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 25));
		pnlStatisticsBy.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		lblBy = new JLabel(" Statistics By             ");
		panel_4.add(lblBy);
		
		rdbtnByYear_Tour = new JRadioButton("By year");
		rdbtnByYear_Tour.setFocusPainted(false);
		rdbtnByYear_Tour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByYear_Tour);
		
		lblNewLabel_4 = new JLabel("             ");
		panel_4.add(lblNewLabel_4);
		
		rdbtnByMonth_Tour = new JRadioButton("By month of the year");
		rdbtnByMonth_Tour.setFocusPainted(false);
		rdbtnByMonth_Tour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByMonth_Tour);
		
		panel_5 = new JPanel();
		pnlStatisticsBy.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSelectMonth = new JLabel("Select Month           ");
		panel_5.add(lblSelectMonth);
		
		cbxMonth_Tour = new JComboBox();
		cbxMonth_Tour.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		panel_5.add(cbxMonth_Tour);
		
		lblSelectYear = new JLabel("                    Select Year            ");
		panel_5.add(lblSelectYear);
		
		cbxYear_Tour = new JComboBox();
		cbxYear_Tour.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021", "2022", "2023"}));
		panel_5.add(cbxYear_Tour);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(92, 14));
		panel_5.add(lblNewLabel_3);
		
		panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(10, 30));
		pnlStatisticsBy.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		btnShowChart_Tour = new JButton("  Chart  ");
		btnShowChart_Tour.setFocusPainted(false);
		btnShowChart_Tour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart_Tour);
		
		btnView_Tour = new JButton("View");
		btnView_Tour.setFocusPainted(false);
		panel_6.add(btnView_Tour);
		
		pnlDetailTourList = new JPanel();
		pnlDetailTourList.setLayout(new CardLayout(0, 0));
		pnlDetailTourList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTourStatistical.add(pnlDetailTourList, BorderLayout.CENTER);
		
		scrollPane_2 = new JScrollPane();
		pnlDetailTourList.add(scrollPane_2, BorderLayout.CENTER);
		
		Object [][] data15 = {
				{"111", "Khánh Hòa", "Miền Trung", "20", "20","20", "20"},
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
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"}
      
		};

		String [] items15 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
		TourTable = new JTable(data15, items15);
		scrollPane_2.setViewportView(TourTable);
		
		
		
		//----------------------------------------------------------
		pnlCusStatistical = new JPanel();
		pnlStatisticContent.add(pnlCusStatistical, "pnlCusStatistical");
		pnlCusStatistical.setLayout(new BorderLayout(0, 0));
		
		pnlStatisticsBy = new JPanel();
		pnlStatisticsBy.setPreferredSize(new Dimension(10, 80));
		pnlCusStatistical.add(pnlStatisticsBy, BorderLayout.NORTH);
		pnlStatisticsBy.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 25));
		pnlStatisticsBy.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		lblBy = new JLabel(" Statistics By             ");
		panel_4.add(lblBy);
		
		rdbtnByYear_Cus = new JRadioButton("By year");
		rdbtnByYear_Cus.setFocusPainted(false);
		rdbtnByYear_Cus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByYear_Cus);
		
		lblNewLabel_4 = new JLabel("             ");
		panel_4.add(lblNewLabel_4);
		
		rdbtnByMonth_Cus = new JRadioButton("By month of the year");
		rdbtnByMonth_Cus.setFocusPainted(false);
		rdbtnByMonth_Cus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByMonth_Cus);
		
		panel_5 = new JPanel();
		pnlStatisticsBy.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSelectMonth = new JLabel("Select Month           ");
		panel_5.add(lblSelectMonth);
		
		cbxMonth_Cus = new JComboBox();
		cbxMonth_Cus.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		panel_5.add(cbxMonth_Cus);
		
		lblSelectYear = new JLabel("                    Select Year            ");
		panel_5.add(lblSelectYear);
		
		cbxYear_Cus = new JComboBox();
		cbxYear_Cus.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021", "2022", "2023"}));
		panel_5.add(cbxYear_Cus);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(92, 14));
		panel_5.add(lblNewLabel_3);
		
		panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(10, 30));
		pnlStatisticsBy.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		btnShowChart_Cus = new JButton("  Chart  ");
		btnShowChart_Cus.setFocusPainted(false);
		btnShowChart_Cus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart_Cus);
		
		btnView_Cus = new JButton("View");
		btnView_Cus.setFocusPainted(false);
		panel_6.add(btnView_Cus);
		
		pnlDetailCusList = new JPanel();
		pnlDetailCusList.setLayout(new CardLayout(0, 0));
		pnlDetailCusList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCusStatistical.add(pnlDetailCusList, BorderLayout.CENTER);
		
		scrollPane_3 = new JScrollPane();
		pnlDetailCusList.add(scrollPane_3, BorderLayout.CENTER);
		
		Object [][] data16 = {
				{"111", "Thai Binh", "Miền Trung", "20", "20","20", "20"},
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
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"}
      
		};

		String [] items16 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
		CusTable = new JTable(data16, items16);
		scrollPane_3.setViewportView(CusTable);
		
		cardLayoutPnlContent =  (CardLayout)(this.getPnlStatisticContent().getLayout());
	
	}
	
	

}
