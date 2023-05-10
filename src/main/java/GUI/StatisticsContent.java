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
	private JRadioButton rdbtnByYear;
	private JLabel lblNewLabel_4;
	private JRadioButton rdbtnByMonth;
	private JPanel panel_5;
	private JLabel lblSelectMonth;
	private JComboBox cbxMonth;
	private JLabel lblSelectYear;
	private JLabel lblNewLabel_3;
	private JPanel panel_6;
	private JButton btnShowChart;
	private JPanel pnlDetailList;
	private JComboBox cbxYear;
	private JPanel pnBookingList;
	private JPanel pnlTourList;
	private JPanel pnlCustomerList;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JTable BookingTable;
	private JTable TourTable;
	private JTable CustomerTable;
	
	private CardLayout cardLayoutBookingList;
	private CardLayout cardLayoutTourList;
	private CardLayout cardLayoutCustomerList;
	 
	public JPanel getPnlDetailList() {
		return pnlDetailList;
	}

	public void setPnlDetailList(JPanel pnlDetailList) {
		this.pnlDetailList = pnlDetailList;
	}

	public JPanel getPnBookingList() {
		return pnBookingList;
	}

	public void setPnBookingList(JPanel pnBookingList) {
		this.pnBookingList = pnBookingList;
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
				cardLayoutBookingList.show(pnlDetailList,"pnBookingList");
			}
		});
		btnStatisticBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStatisticBooking.setFocusPainted(false);
		pnlStatisticsList.add(btnStatisticBooking);
		
		btnStatisticTour = new JButton("  Tour  ");
		btnStatisticTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutTourList.show(pnlDetailList,"pnTourList");
			}
		});
		btnStatisticTour.setFocusPainted(false);
		btnStatisticTour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlStatisticsList.add(btnStatisticTour);
		
		btnStatisticCustomer = new JButton("Customer");
		btnStatisticCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutCustomerList.show(pnlDetailList,"pnCustomerList");
			}
		});
		btnStatisticCustomer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStatisticCustomer.setFocusPainted(false);
		pnlStatisticsList.add(btnStatisticCustomer);
		
		pnlStatisticContent = new JPanel();
		add(pnlStatisticContent, BorderLayout.CENTER);
		pnlStatisticContent.setLayout(new BorderLayout(0, 0));
		
		pnlStatisticsBy = new JPanel();
		pnlStatisticsBy.setPreferredSize(new Dimension(10, 80));
		pnlStatisticContent.add(pnlStatisticsBy, BorderLayout.NORTH);
		pnlStatisticsBy.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 25));
		pnlStatisticsBy.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		lblBy = new JLabel(" Statistics By             ");
		panel_4.add(lblBy);
		
		rdbtnByYear = new JRadioButton("By year");
		rdbtnByYear.setFocusPainted(false);
		rdbtnByYear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByYear);
		
		lblNewLabel_4 = new JLabel("             ");
		panel_4.add(lblNewLabel_4);
		
		rdbtnByMonth = new JRadioButton("By month of the year");
		rdbtnByMonth.setFocusPainted(false);
		rdbtnByMonth.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.add(rdbtnByMonth);
		
		panel_5 = new JPanel();
		pnlStatisticsBy.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSelectMonth = new JLabel("Select Month           ");
		panel_5.add(lblSelectMonth);
		
		cbxMonth = new JComboBox();
		cbxMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		panel_5.add(cbxMonth);
		
		lblSelectYear = new JLabel("                    Select Year            ");
		panel_5.add(lblSelectYear);
		
		cbxYear = new JComboBox();
		cbxYear.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021", "2022", "2023"}));
		panel_5.add(cbxYear);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setPreferredSize(new Dimension(464, 14));
		panel_5.add(lblNewLabel_3);
		
		panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(10, 30));
		pnlStatisticsBy.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		btnShowChart = new JButton("  Chart  ");
		btnShowChart.setFocusPainted(false);
		btnShowChart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart);
		
		pnlDetailList = new JPanel();
		pnlDetailList.setLayout(new CardLayout(0, 0));
		pnlDetailList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlStatisticContent.add(pnlDetailList, BorderLayout.CENTER);
		
		pnBookingList = new JPanel();
		pnlDetailList.add(pnBookingList, "pnBookingList");
		pnBookingList.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		pnBookingList.add(scrollPane_1, BorderLayout.CENTER);
		
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
		
		pnlTourList = new JPanel();
		pnlDetailList.add(pnlTourList, "pnlTourList");
		pnlTourList.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		pnlTourList.add(scrollPane_2, BorderLayout.CENTER);
		
		Object [][] data15 = {
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

		String [] items15 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
		
		TourTable = new JTable(data15, items15);
		scrollPane_2.setViewportView(TourTable);
		
		pnlCustomerList = new JPanel();
		pnlDetailList.add(pnlCustomerList, "pnlCustomerList");
		pnlCustomerList.setLayout(new BorderLayout(0, 0));
		
		scrollPane_3 = new JScrollPane();
		pnlCustomerList.add(scrollPane_3, BorderLayout.CENTER);
		
		Object [][] data16 = {
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

		String [] items16 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
		
		CustomerTable = new JTable(data16, items16);
		scrollPane_3.setViewportView(CustomerTable);
//		
//		cardLayoutBookingList =  (CardLayout)(this.getPnBookingList().getLayout());
//		cardLayoutTourList =  (CardLayout)(this.getPnlTourList().getLayout());
//		cardLayoutCustomerList =  (CardLayout)(this.getPnlCustomerList().getLayout());
	}
	
	

}
