import DAO.*;
import DTO.CustomerDTO;
import DTO.HotelDTO;
import DTO.PlaceDTO;
import DTO.TourDTO;
import GUI.*;
import GUI.Manager;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


public class Main {

    public static void main(String[] args) throws SQLException {
//        TourDAO abc = new TourDAO();
//
//        TourDTO tour = abc.getById(1);
//        double a = tour.getPrice();
//        System.out.println(Double.valueOf(a));

//        TourDAO abc = new TourDAO();
//        System.out.println( abc.getClass().getName());
//        EmpManager employeeManager = new EmpManager();
//        employeeManager.setVisible(true);
//     	 ArrayList<HotelDTO> jjjArrayList = HotelDAO.getInstance().getAll();
//    	 for(HotelDTO ddd: jjjArrayList) {
//    		 System.out.println(ddd.toString());
//    	 }
//    	 HotelDAO.getInstance().delete(13);
//      	 ArrayList<HotelDTO> jjFDFD = HotelDAO.getInstance().getAll();
//    	 for(HotelDTO ddd: jjFDFD) {
//    		 System.out.println(ddd.toString());
//    	 }
//    	ArrayList<CustomerDTO> dddArrayList = CustomerDAO.getInstance().getAll();
//    	for(CustomerDTO dddCustomerDTO : dddArrayList) {
////    		System.out.println(dddArrayList.toString());
    	Manager manager = new Manager();
		manager.setVisible(true);

    	}
    }

