import DAO.TourDAO;
import DTO.TourDTO;

import java.util.ArrayList;

public class Main{
	
    public static void main(String[] args) {
        //    	Manager manager = new Manager();
        //		manager.setVisible(true);
        TourDAO dao = new TourDAO();
        ArrayList<TourDTO> abcs = dao.getAll();
        for (TourDTO abc : abcs) {
            String d = abc.getStart_day().toString();
            System.out.println(d);
        }
    }
}

