package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import DAO.BookingDAO;
import DAO.CustomerDAO;
import DAO.TourDAO;
import DTO.BookingDTO;
import DTO.CustomerDTO;
import DTO.TourDTO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Excel extends JFrame {

	private JPanel contentPane;
	private JTable table_thongke;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excel frame = new Excel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Excel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 10, 2, 2);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 220, 929, 414);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 909, 396);
		panel.add(scrollPane_1);

		table_thongke = new JTable();
		scrollPane_1.setViewportView(table_thongke);

		JButton btntkbooking = new JButton("TK_Booking");
		btntkbooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
		        model.addColumn("Booking_ID");;
		        model.addColumn("Tour_ID");
		        model.addColumn("Customer_id");
		        model.addColumn("Customer_number");
		        model.addColumn("Total_cost");
		        model.addColumn("Create_At");
		        ArrayList<BookingDTO> csDTO = BookingDAO.getInstance().getAll();
		        for(BookingDTO bkDto : csDTO) {
		        	System.out.println(bkDto.toString());
		            model.addRow(new Object[] {
		                    bkDto.getBooking_id(),bkDto.getTour_id(),bkDto.getCustomer_id(),bkDto.getCustomer_number(),bkDto.getTotal_cost(),bkDto.getCreate_at()

		            });
		        }
		        table_thongke = new JTable();
		        table_thongke.setModel(model);
		        scrollPane_1.setViewportView(table_thongke);
//		        table_thongke.setViewportView(table_thongke);
			}
		});
		btntkbooking.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btntkbooking.setBounds(10, 53, 147, 41);
		contentPane.add(btntkbooking);

		JButton btnexcelbooking = new JButton("Excel_Booking");
		btnexcelbooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcelBooking();
			}
		});
		btnexcelbooking.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnexcelbooking.setBounds(10, 105, 147, 41);
		contentPane.add(btnexcelbooking);

		JButton btntktour = new JButton("TK_Tour");
		btntktour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
		        model.addColumn("Tour_ID");;
		        model.addColumn("Tour_Name");
		        model.addColumn("Hotel_id");
		        model.addColumn("Price");
		        model.addColumn("Star_Day");
		        model.addColumn("End_Day");
		        model.addColumn("Departure_place");
		        model.addColumn("Schedule-descripbe");
		        model.addColumn("create_at");
		        ArrayList<TourDTO> csDTO = TourDAO.getInstance().getAll();
		        for(TourDTO itemDao : csDTO) {
		            model.addRow(new Object[] {
		                    itemDao.getTour_id(),itemDao.getTour_name(),itemDao.getHotel_id(),itemDao.getPrice(),itemDao.getStart_day(),itemDao.getEnd_day(),itemDao.getDeparture_place(),
		                    itemDao.getSchedule_describe(),itemDao.getCreate_at()
		            });
		        }
		        table_thongke = new JTable();
		        table_thongke.setModel(model);
		        scrollPane_1.setViewportView(table_thongke);
			}
		});
		btntktour.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btntktour.setBounds(397, 53, 147, 41);
		contentPane.add(btntktour);

		JButton btnexceltour = new JButton("Excel_Tour");
		btnexceltour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcelTour();

			}
		});
		btnexceltour.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnexceltour.setBounds(397, 105, 147, 41);
		contentPane.add(btnexceltour);

		JButton btntkcustomer = new JButton("TK_Customer");
		btntkcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel model = new DefaultTableModel();
			        model.addColumn("ID");;
			        model.addColumn("Name");
			        model.addColumn("Tel");
			        model.addColumn("Birthday");
			        model.addColumn("Email");
			        model.addColumn("Create_At");
			        ArrayList<CustomerDTO> csDTO = CustomerDAO.getInstance().getAll();
			        for(CustomerDTO itemCustomer : csDTO) {
			            model.addRow(new Object[] {
			                    itemCustomer.getCustomer_id(),itemCustomer.getCustomer_name(),itemCustomer.getTel(),itemCustomer.getBirthday(),itemCustomer.getEmail(),itemCustomer.getCreate_at()
			            });
			        }
			        table_thongke = new JTable();
			        table_thongke.setModel(model);
			        scrollPane_1.setViewportView(table_thongke);
			}
		});
		btntkcustomer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btntkcustomer.setBounds(790, 53, 147, 41);
		contentPane.add(btntkcustomer);

		JButton btnExcelcustomer = new JButton("Excel_Customer");
		btnExcelcustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuatExcelCustomer();
			}
		});
		btnExcelcustomer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnExcelcustomer.setBounds(790, 105, 147, 41);
		contentPane.add(btnExcelcustomer);

		JLabel lblNewLabel = new JLabel("Thống Kê Quản Lý Tour");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 10, 439, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnexcelbooking_1 = new JButton("Excel_Booking");
		btnexcelbooking_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnexcelbooking_1.setBounds(10, 157, 147, 41);
		contentPane.add(btnexcelbooking_1);
		
		JButton btnexcelbooking_2 = new JButton("Excel_Booking");
		btnexcelbooking_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnexcelbooking_2.setBounds(397, 157, 147, 41);
		contentPane.add(btnexcelbooking_2);
		
		JButton btnexcelbooking_3 = new JButton("Excel_Booking");
		btnexcelbooking_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnexcelbooking_3.setBounds(790, 157, 147, 41);
		contentPane.add(btnexcelbooking_3);
	}
	private void XuatExcelBooking() {
        try {
            JFileChooser jfile = new JFileChooser();
           jfile.setSelectedFile(new File("untitled.xls"));

            int seleted = jfile.showSaveDialog(this);

            if (seleted == JFileChooser.APPROVE_OPTION) {
                String FilePath = jfile.getSelectedFile().getPath();
                System.out.println(FilePath);

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("account");
                ArrayList<BookingDTO> list = BookingDAO.getInstance().getAll();
                int rowPos = 0;
                HSSFRow row = sheet.createRow(rowPos);
                row.createCell(0, CellType.NUMERIC).setCellValue("Booking_Id");
                row.createCell(1, CellType.STRING).setCellValue("Tour_id");
                row.createCell(2, CellType.STRING).setCellValue("Customer_id");
                row.createCell(3, CellType.STRING).setCellValue("Customer_number");
                row.createCell(4, CellType.STRING).setCellValue("Total_cost");
                row.createCell(5, CellType.STRING).setCellValue("Create_at");
                for (BookingDTO ddd: list) {
                	rowPos++;
                	row = sheet.createRow(rowPos);
                    row.createCell(0, CellType.NUMERIC).setCellValue(ddd.getBooking_id());
                    row.createCell(1, CellType.STRING).setCellValue(ddd.getTour_id());
                    row.createCell(2, CellType.STRING).setCellValue(ddd.getCustomer_id());
                    row.createCell(3, CellType.STRING).setCellValue(ddd.getCustomer_number());
                    row.createCell(4, CellType.STRING).setCellValue(ddd.getTotal_cost());
                    row.createCell(5, CellType.STRING).setCellValue(ddd.getCreate_at());
                }
                File file = new File(FilePath);
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    workbook.write(fos);
                    fos.close();

                } catch (Exception e) {
                    System.out.println("GUI.Table.jButton1MouseClicked()");
                }

            }
            if (seleted == JFileChooser.CANCEL_OPTION) {
            }

        } catch (Exception e) {
        }

    }
	private void XuatExcelTour() {
        try {
            JFileChooser jfile = new JFileChooser();
           jfile.setSelectedFile(new File("untitled.xls"));

            int seleted = jfile.showSaveDialog(this);

            if (seleted == JFileChooser.APPROVE_OPTION) {
                String FilePath = jfile.getSelectedFile().getPath();
                System.out.println(FilePath);

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("account");
                ArrayList<TourDTO> list = TourDAO.getInstance().getAll();
                int rowPos = 0;
                HSSFRow row = sheet.createRow(rowPos);
                row.createCell(0, CellType.NUMERIC).setCellValue("Tour_ID");
                row.createCell(1, CellType.STRING).setCellValue("Tour_Name");
                row.createCell(2, CellType.STRING).setCellValue("Hotel_ID");
                row.createCell(3, CellType.STRING).setCellValue("Price");
                row.createCell(4, CellType.STRING).setCellValue("Star_Day");
                row.createCell(5, CellType.STRING).setCellValue("Star_End");
                row.createCell(6, CellType.STRING).setCellValue("Departure_place");
                row.createCell(7, CellType.STRING).setCellValue("Schedule_descride");
                row.createCell(8, CellType.STRING).setCellValue("Create_at");
                for (TourDTO ddd: list) {
                	rowPos++;
                	row = sheet.createRow(rowPos);
                    row.createCell(0, CellType.NUMERIC).setCellValue(ddd.getTour_id());
                    row.createCell(1, CellType.STRING).setCellValue(ddd.getTour_name());
                    row.createCell(2, CellType.STRING).setCellValue(ddd.getHotel_id());
                    row.createCell(3, CellType.STRING).setCellValue(ddd.getPrice());
                    row.createCell(4, CellType.STRING).setCellValue(ddd.getStart_day());
                    row.createCell(5, CellType.STRING).setCellValue(ddd.getEnd_day());
                    row.createCell(6, CellType.STRING).setCellValue(ddd.getDeparture_place());
                    row.createCell(7, CellType.STRING).setCellValue(ddd.getSchedule_describe());
                    row.createCell(8, CellType.STRING).setCellValue(ddd.getCreate_at());
                }
                File file = new File(FilePath);
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    workbook.write(fos);
                    fos.close();

                } catch (Exception e) {
                    System.out.println("GUI.Table.jButton1MouseClicked()");
                }

            }
            if (seleted == JFileChooser.CANCEL_OPTION) {
            }

        } catch (Exception e) {
        }

    }
	 private void XuatExcelCustomer() {
	        try {
	            JFileChooser jfile = new JFileChooser();
	           jfile.setSelectedFile(new File("untitled.xls"));

	            int seleted = jfile.showSaveDialog(this);

	            if (seleted == JFileChooser.APPROVE_OPTION) {
	                String FilePath = jfile.getSelectedFile().getPath();
	                System.out.println(FilePath);

	                HSSFWorkbook workbook = new HSSFWorkbook();
	                HSSFSheet sheet = workbook.createSheet("account");
	                ArrayList<CustomerDTO> list = CustomerDAO.getInstance().getAll();
	                int rowPos = 0;
	                HSSFRow row = sheet.createRow(rowPos);
	                row.createCell(0, CellType.NUMERIC).setCellValue("Id");
	                row.createCell(1, CellType.STRING).setCellValue("Name");
	                row.createCell(2, CellType.STRING).setCellValue("Tel");
	                row.createCell(3, CellType.STRING).setCellValue("Birthday");
	                row.createCell(4, CellType.STRING).setCellValue("Email");
	                row.createCell(5, CellType.STRING).setCellValue("Create_at");
	                for (CustomerDTO ddd: list) {
	                	rowPos++;
	                	row = sheet.createRow(rowPos);
	                    row.createCell(0, CellType.NUMERIC).setCellValue(ddd.getCustomer_id());
	                    row.createCell(1, CellType.STRING).setCellValue(ddd.getCustomer_name());
	                    String telString  =String.valueOf(ddd.getTel());
	                    row.createCell(2, CellType.STRING).setCellValue(telString);
	                    row.createCell(3, CellType.STRING).setCellValue(ddd.getBirthday());
	                    row.createCell(4, CellType.STRING).setCellValue(ddd.getEmail());
	                    row.createCell(5, CellType.STRING).setCellValue(ddd.getCreate_at());
	                }
	                File file = new File(FilePath);
	                try {
	                    FileOutputStream fos = new FileOutputStream(file);
	                    workbook.write(fos);
	                    fos.close();

	                } catch (Exception e) {
	                    System.out.println("GUI.Table.jButton1MouseClicked()");
	                }

	            }
	            if (seleted == JFileChooser.CANCEL_OPTION) {
	            }

	        } catch (Exception e) {
	        }

	    }
}
