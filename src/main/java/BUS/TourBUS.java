package BUS;

import DAO.PlaceDAO;
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

    public String add(TourDTO tourDTO) {

        if (tour.checkExistById(tourDTO.getTour_id())) {
            return "ID tour đã tồn tại";
        }

        if (!tour.add(tourDTO))
            return "Thêm tour thất bại!";

        PlaceDAO pd = new PlaceDAO();
        ArrayList<PlaceDTO> places = pd.getPlacesByRegionCode(tourDTO.getRegion_code());
        for (PlaceDTO place : places) {
            Tour_DetailDTO td = new Tour_DetailDTO();
            td.setTour_id(tourDTO.getTour_id());
            td.setPlace_id(place.getPlace_id());
            tour_detail.add(td);
        }

        return "thêm tour thành công!";
    }

    public String update (TourDTO TourDTO) {
        if (!tour.update(TourDTO)) {
            return "UPDATE thất bại!";
        }

        if (!tour_detail.delete(TourDTO.getTour_id())){
            return "Có lỗi xảy ra trong quá trình xoá tour_id trong tour_detail";
        }

        PlaceDAO pd = new PlaceDAO();
        ArrayList<PlaceDTO> places = pd.getPlacesByRegionCode(TourDTO.getRegion_code());
        for (PlaceDTO place : places) {
            Tour_DetailDTO td = new Tour_DetailDTO();
            td.setTour_id(TourDTO.getTour_id());
            td.setPlace_id(place.getPlace_id());
            tour_detail.add(td);
        }
         return "UPDATE thành công!";
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
