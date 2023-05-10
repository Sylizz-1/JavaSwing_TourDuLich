package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.google.protobuf.TextFormat.ParseException;


import DAO.CustomerDAO;
import DAO.TourDAO;
import DTO.CustomerDTO;
import DTO.TourDTO;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
				cardLayoutPnlContent.show(pnlStatisticContent,"pnlCusStatistical");
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
		
		lblBy = new JLabel(" Statistics Booking By             ");
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
		
		btnShowChart_Booking = new JButton("  Chart Booking ");
		btnShowChart_Booking.setFocusPainted(false);
		btnShowChart_Booking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart_Booking);
		
		btnView_Booking = new JButton("View Booking");
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
		
		lblBy = new JLabel(" Statistics Tour By             ");
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
		
		btnShowChart_Tour = new JButton("  Chart Tour ");
		btnShowChart_Tour.setFocusPainted(false);
		btnShowChart_Tour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart_Tour);
		
		btnView_Tour = new JButton("View Tour");
		btnView_Tour.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
//								year -----------------------------------------------------------------
		        if(rdbtnByYear_Tour.isSelected() && rdbtnByMonth_Tour.isSelected() == false ) {	
		            Boolean check = false;
		                String year = (String) cbxYear_Tour.getSelectedItem();
		                ArrayList<TourDTO> data = TourDAO.getInstance().getAll();
		                
		                DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("ID");
		                model.addColumn("Name");
		                model.addColumn("Hotel");
		                model.addColumn("Region Code");
		                model.addColumn("Price");
		                model.addColumn("Start Date");
		                model.addColumn("End Date");
		                model.addColumn("Departure");
		                model.addColumn("Describe");
		                
		                for(TourDTO TourDTO: data) {
		                        String date2 = TourDTO.getCreate_at();
		                        SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		                        try {
		                            Date date4 = formatter4.parse(date2);
		                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		                             simpleDateFormat.applyPattern("yyyy");
		                                String format = simpleDateFormat.format(date4); 

		                                if(format.equals(year)) { 
		                                     model.addRow(new Object[] {
		                                                TourDTO.getTour_id(),TourDTO.getTour_name(),TourDTO.getHotel_id(),TourDTO.getRegion_code(),TourDTO.getPrice(),TourDTO.getStart_day(),TourDTO.getEnd_day(),TourDTO.getDeparture_place(),TourDTO.getSchedule_describe(),TourDTO.getCreate_at()
		                                        });
		                                     check = true;
		                                }
		                        } catch (java.text.ParseException e1) {
		                            // TODO Auto-generated catch block
		                            e1.printStackTrace();
		                        }
		                }	
		                if (check == false) {
		                    JOptionPane.showMessageDialog(null, "không có tour trong năm này !");
		                    DefaultTableModel model2 = (DefaultTableModel) TourTable.getModel();
		                    while (model2.getRowCount() > 0) {
		                        model2.removeRow(0);
		                    }
		                }
		                TourTable = new JTable();
		                TourTable.setModel(model);
		                scrollPane_2.setViewportView(TourTable);
		        }
//								month ------------------------------------------------------------------------------------------
		        if(rdbtnByYear_Tour.isSelected()==false && rdbtnByMonth_Tour.isSelected()) {
		            Boolean check = false;
		            String month = (String) cbxMonth_Tour.getSelectedItem();
		            ArrayList<TourDTO> data = TourDAO.getInstance().getAll();
		            
		            DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("ID");;
		                model.addColumn("Name");
		                model.addColumn("Hotel");
		                model.addColumn("Region Code");
		                model.addColumn("Price");
		                model.addColumn("Start Date");
		                model.addColumn("End Date");
		                model.addColumn("Departure");
		                model.addColumn("Describe");
		                model.addColumn("Create_At");
		            
		            for(TourDTO TourDTO: data) {
		                    String date2 = TourDTO.getCreate_at();
		                    SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		                    try {
		                        Date date4 = formatter4.parse(date2);
		                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		                         simpleDateFormat.applyPattern("MM");
		                           String format2 = simpleDateFormat.format(date4); 

		                            if(format2.equals(month)) { 
		                                 model.addRow(new Object[] {
		                                         TourDTO.getTour_id(),TourDTO.getTour_name(),TourDTO.getHotel_id(),TourDTO.getRegion_code(),TourDTO.getPrice(),TourDTO.getStart_day(),TourDTO.getEnd_day(),TourDTO.getDeparture_place(),TourDTO.getSchedule_describe(),TourDTO.getCreate_at()
		                                    });
		                                 check = true;
		                            }    
		                    } catch (java.text.ParseException e1) {
		                        e1.printStackTrace();
		                    }
		            }	
		            if (check == false) {
		                JOptionPane.showMessageDialog(null, "Tháng đã chọn không có Tour!");
		                DefaultTableModel model2 = (DefaultTableModel) TourTable.getModel();
		                while (model2.getRowCount() > 0) {
		                    model2.removeRow(0);
		                }
		            }
		            TourTable = new JTable();
		            TourTable.setModel(model);
		            scrollPane_2.setViewportView(TourTable);
		        }
		        
		        
		        if(rdbtnByYear_Tour.isSelected() && rdbtnByMonth_Tour.isSelected()) {
		            Boolean check = false;
		            String year = (String) cbxYear_Tour.getSelectedItem();
		            String month = (String) cbxMonth_Tour.getSelectedItem();
		            ArrayList<TourDTO> data = TourDAO.getInstance().getAll();
		            
		            DefaultTableModel model = new DefaultTableModel();
		                model.addColumn("ID");;
		                model.addColumn("Name");
		                model.addColumn("Hotel");
		                model.addColumn("Region Code");
		                model.addColumn("Price");
		                model.addColumn("Start Date");
		                model.addColumn("End Date");
		                model.addColumn("Departure");
		                model.addColumn("Describe");
		            
		            for(TourDTO TourDTO: data) {
		                    String date2 = TourDTO.getCreate_at();
		                    SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		                    try {
		                        Date date4 = formatter4.parse(date2);
		                        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
		                         simpleDateFormat2.applyPattern("yyyy");
		                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		                         simpleDateFormat.applyPattern("MM");
		                         String yearitem = simpleDateFormat2.format(date4); 
		                           String monthitem = simpleDateFormat.format(date4); 
		                           
		                            if(yearitem .equals(year) && monthitem.equals(month) ) { 
		                                 model.addRow(new Object[] {
		                                            TourDTO.getTour_id(),TourDTO.getTour_name(),TourDTO.getHotel_id(),TourDTO.getRegion_code(),TourDTO.getPrice(),TourDTO.getStart_day(),TourDTO.getEnd_day(),TourDTO.getDeparture_place(),TourDTO.getSchedule_describe(),TourDTO.getCreate_at()
		                                    });
		                                 check = true;
		                            }    
		                    } catch (java.text.ParseException e1) {
		                        e1.printStackTrace();
		                    }
		            }	
		            if (check == false) {
		                JOptionPane.showMessageDialog(null, "không có tour trong năm hoặc  tháng này !");
		                DefaultTableModel model2 = (DefaultTableModel) TourTable.getModel();
		                while (model2.getRowCount() > 0) {
		                    model2.removeRow(0);
		                }
		            }
		            TourTable = new JTable();
		            TourTable.setModel(model);
		            scrollPane_2.setViewportView(TourTable);
		        }
		    }
		});
		btnView_Tour.setFocusPainted(false);
		panel_6.add(btnView_Tour);
		
		pnlDetailTourList = new JPanel();
		pnlDetailTourList.setLayout(new CardLayout(0, 0));
		pnlDetailTourList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTourStatistical.add(pnlDetailTourList, BorderLayout.CENTER);
		
		scrollPane_2 = new JScrollPane();
		pnlDetailTourList.add(scrollPane_2, BorderLayout.CENTER);
		
//		Object [][] data15 = {
//				{"111", "Khánh Hòa", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},            
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"},
//				{"111", "Nha Trang", "Miền Trung", "20", "20","20", "20"}
//      
//		};
//
//		String [] items15 = {"ID", "Name", "Area", "Number of days", "Number of peoples", "Number of peoples", "Number of peoples"};
//		TourTable = new JTable(data15, items15);
//		scrollPane_2.setViewportView(TourTable);
		
		
		
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
		
		lblBy = new JLabel(" Statistics Customer By             ");
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
		cbxMonth_Cus.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
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
		
		btnShowChart_Cus = new JButton("  Chart Customer  ");
		btnShowChart_Cus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChartCustomer ffffChart = new ChartCustomer();
				ffffChart.main(items15);
			}
		});
		btnShowChart_Cus.setFocusPainted(false);
		btnShowChart_Cus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.add(btnShowChart_Cus);
		
		btnView_Cus = new JButton("View Customer");
		btnView_Cus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				year -----------------------------------------------------------------
				if(rdbtnByYear_Cus.isSelected() && rdbtnByMonth_Cus.isSelected() == false ) {	
					Boolean checkkqBoolean = false;
						String yearString = (String) cbxYear_Cus.getSelectedItem();
						ArrayList<CustomerDTO> jjjj = CustomerDAO.getInstance().getAll();
						
						DefaultTableModel model = new DefaultTableModel();
			            model.addColumn("ID");;
			            model.addColumn("Name");
			            model.addColumn("Tel");
			            model.addColumn("Birthday");
			            model.addColumn("Email");
			            model.addColumn("Create_At");
			            
				    	for(CustomerDTO customerDTO: jjjj) {
				        		String date2 = customerDTO.getCreate_at();
				        	    SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        	    try {
									Date date4 = formatter4.parse(date2);
									SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
									 simpleDateFormat.applyPattern("yyyy");
								        String format = simpleDateFormat.format(date4); 

								        if(format.equals(yearString)) { 
								        	 model.addRow(new Object[] {
								        			 customerDTO.getCustomer_id(),customerDTO.getCustomer_name(),customerDTO.getTel(),customerDTO.getBirthday(),customerDTO.getEmail(),customerDTO.getCreate_at()
								                });
								        	 checkkqBoolean = true;
								        }
								} catch (java.text.ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				    	}	
				    	if (checkkqBoolean == false) {
				    		JOptionPane.showMessageDialog(null, "không có khách hàng trong năm này !");
				        	DefaultTableModel model2 = (DefaultTableModel) CusTable.getModel();
			                while (model2.getRowCount() > 0) {
			                    model2.removeRow(0);
			                }
				    	}
				    	CusTable = new JTable();
				    	CusTable.setModel(model);
				    	scrollPane_3.setViewportView(CusTable);
				}
//				month ------------------------------------------------------------------------------------------
				if(rdbtnByYear_Cus.isSelected()==false && rdbtnByMonth_Cus.isSelected()) {
					Boolean checkkqBoolean = false;
					String MonthString = (String) cbxMonth_Cus.getSelectedItem();
					ArrayList<CustomerDTO> jjjj = CustomerDAO.getInstance().getAll();
					
					DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("ID");;
		            model.addColumn("Name");
		            model.addColumn("Tel");
		            model.addColumn("Birthday");
		            model.addColumn("Email");
		            model.addColumn("Create_At");
		            
			    	for(CustomerDTO customerDTO: jjjj) {
			        		String date2 = customerDTO.getCreate_at();
			        	    SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        	    try {
								Date date4 = formatter4.parse(date2);
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
								 simpleDateFormat.applyPattern("MM");
							       String format2 = simpleDateFormat.format(date4); 

							        if(format2.equals(MonthString)) { 
							        	 model.addRow(new Object[] {
							        			 customerDTO.getCustomer_id(),customerDTO.getCustomer_name(),customerDTO.getTel(),customerDTO.getBirthday(),customerDTO.getEmail(),customerDTO.getCreate_at()
							                });
							        	 checkkqBoolean = true;
							        }    
							} catch (java.text.ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    	}	
			    	if (checkkqBoolean == false) {
			        	JOptionPane.showMessageDialog(null, "không có khách hàng trong tháng này !");
			        	DefaultTableModel model2 = (DefaultTableModel) CusTable.getModel();
		                while (model2.getRowCount() > 0) {
		                    model2.removeRow(0);
		                }
			    	}
			    	CusTable = new JTable();
			    	CusTable.setModel(model);
			    	scrollPane_3.setViewportView(CusTable);
				}
//				year - month -----------------------------------------------------------------------------------------------
				if(rdbtnByYear_Cus.isSelected() && rdbtnByMonth_Cus.isSelected()) {
					Boolean checkkqBoolean = false;
					String yearString = (String) cbxYear_Cus.getSelectedItem();
					String MonthString = (String) cbxMonth_Cus.getSelectedItem();
					ArrayList<CustomerDTO> jjjj = CustomerDAO.getInstance().getAll();
					
					DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("ID");;
		            model.addColumn("Name");
		            model.addColumn("Tel");
		            model.addColumn("Birthday");
		            model.addColumn("Email");
		            model.addColumn("Create_At");
		            
			    	for(CustomerDTO customerDTO: jjjj) {
			        		String date2 = customerDTO.getCreate_at();
			        	    SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        	    try {
								Date date4 = formatter4.parse(date2);
								SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
								 simpleDateFormat2.applyPattern("yyyy");
								SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
								 simpleDateFormat.applyPattern("MM");
								 String yearStringitem = simpleDateFormat2.format(date4); 
							       String monthStringitem = simpleDateFormat.format(date4); 
							       
							        if(yearStringitem .equals(yearString) && monthStringitem.equals(MonthString) ) { 
							        	 model.addRow(new Object[] {
							        			 customerDTO.getCustomer_id(),customerDTO.getCustomer_name(),customerDTO.getTel(),customerDTO.getBirthday(),customerDTO.getEmail(),customerDTO.getCreate_at()
							                });
							        	 checkkqBoolean = true;
							        }    
							} catch (java.text.ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			    	}	
			    	if (checkkqBoolean == false) {
			        	JOptionPane.showMessageDialog(null, "không có khách hàng trong năm hoặc  tháng này !");
			        	DefaultTableModel model2 = (DefaultTableModel) CusTable.getModel();
		                while (model2.getRowCount() > 0) {
		                    model2.removeRow(0);
		                }
			    	}
			    	CusTable = new JTable();
			    	CusTable.setModel(model);
			    	scrollPane_3.setViewportView(CusTable);
				}
			}
		});
		btnView_Cus.setFocusPainted(false);
		panel_6.add(btnView_Cus);
		
		pnlDetailCusList = new JPanel();
		pnlDetailCusList.setLayout(new CardLayout(0, 0));
		pnlDetailCusList.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detail List", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlCusStatistical.add(pnlDetailCusList, BorderLayout.CENTER);
		
		scrollPane_3 = new JScrollPane();
		pnlDetailCusList.add(scrollPane_3, BorderLayout.CENTER);
		
		
		
		cardLayoutPnlContent =  (CardLayout)(this.getPnlStatisticContent().getLayout());
	
	}
	
	

}
