package BUS;

import DAO.ServiceDAO;
import DTO.ServiceDTO;

import java.util.ArrayList;

public class ServiceBUS {
    private ServiceDAO serdao;
    public ServiceBUS() {
        serdao = new ServiceDAO();
    }

    public ArrayList<ServiceDTO> getAll() {
        return serdao.getAll();
    }

    public ServiceDTO getByid(int id) {
        return serdao.getById(id);
    }
}
