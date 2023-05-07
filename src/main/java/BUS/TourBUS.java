package BUS;

import DAO.TourDAO;
import DAO.Tour_DetailDAO;
import DAO.UserDAO;
import DTO.*;

import java.util.ArrayList;
import java.util.EventListener;

public class TourBUS {
    TourDAO tour ;
    Tour_DetailDAO tour_detail ;

    public TourBUS() {
        tour = new TourDAO();
        tour_detail= new Tour_DetailDAO();

    }

    public ArrayList<TourDTO> getAll() {
        return tour.getAll();
    }

    public String add(TourDTO tourDTO, ArrayList<PlaceDTO> placeDTOs) {

        if (tour.checkExistById(tourDTO.getTour_id())) {
            return "ID tour đã tồn tại";
        }

        if (!tour.add(tourDTO))
            return "Thêm tour thất bại!";


        for (PlaceDTO place : placeDTOs) {
            Tour_DetailDTO td = new Tour_DetailDTO();
            td.setTour_id(tourDTO.getTour_id());
            td.setPlace_id(place.getPlace_id());
            tour_detail.add(td);
        }

        return "thêm tour thành công!";

    }

    public String update (TourDTO TourDTO) {
        if (tour.update(TourDTO)) {
            return "UPDATE thành công!";
        }
        else return "UPDATE thất bại!";
    }

    public String delete (int id) {
        if (tour.delete(id)) {
            return "Xoá thành công!";
        }
        else return "Xoá thất bại!";
    }

    public ArrayList<PlaceDTO> getPlacesOfTour(int id)  {
        return tour.getPlacesOfTour(id);
    }



}
