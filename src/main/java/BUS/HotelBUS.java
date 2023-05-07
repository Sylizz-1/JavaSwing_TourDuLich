package BUS;

import DAO.HotelDAO;
import DTO.HotelDTO;

import java.util.ArrayList;

public class HotelBUS {
    private HotelDAO hoteldao;

    public HotelBUS() {
        hoteldao = new HotelDAO();
    }

    public ArrayList<HotelDTO> getAll() {
        return hoteldao.getAll();
    }

    public HotelDTO getById(int id) {
        return hoteldao.getById(id);
    }

    public String add(HotelDTO hoteldto) {
        if (hoteldao.checkExistById(hoteldto.getHotel_id())) {
            return "ID đã tồn tại";
        }
        if (!hoteldao.add(hoteldto)) {
            return "Add thất bại";
        }
        return "Add thành công";
    }
}
