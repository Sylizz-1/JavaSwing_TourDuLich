package BUS;

import DAO.CustomerDAO;
import DTO.CustomerDTO;

import java.util.ArrayList;

public class CustomerBUS {
    private CustomerDAO cusdao;
    public  CustomerBUS() {
        cusdao = new CustomerDAO();
    }

    public ArrayList<CustomerDTO> getAll() {
        return cusdao.getAll();
    }

    public CustomerDTO getById(int id) {
        return cusdao.getById(id);
    }
}
