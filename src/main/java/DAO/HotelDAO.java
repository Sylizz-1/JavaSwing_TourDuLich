package DAO;

import DTO.HotelDTO;


import java.sql.*;
import java.util.ArrayList;

public class HotelDAO implements AccessDatabase<HotelDTO>{


    @Override
    public ArrayList<HotelDTO> getAll() {
        ArrayList<HotelDTO> arr = new ArrayList<HotelDTO>();
        ConnectDatabase conndb = new ConnectDatabase();
        try {
            Connection conn = conndb.getConnection();
            String query = "Select * from hotel";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                HotelDTO hotel = new HotelDTO();
                hotel.setHotel_id(rs.getInt("hotel_id"));
                hotel.setHotel_name(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setTel(rs.getInt("tel"));
                hotel.setWebsite(rs.getString("website"));
                hotel.setStar(rs.getInt("star"));
                arr.add(hotel);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return arr;
    }

    @Override
    public HotelDTO getById(int id) {
        HotelDTO hotel = new HotelDTO();
        ConnectDatabase conndb = new ConnectDatabase();
        try {

            String query = "Select * from hotel where hotel_id = ?" ;
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                hotel.setHotel_id(rs.getInt("hotel_id"));
                hotel.setHotel_name(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setTel(rs.getInt("tel"));
                hotel.setWebsite(rs.getString("website"));
                hotel.setStar(rs.getInt("star"));
            }
            else return null;

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return hotel;
    }

    @Override
    public boolean add(HotelDTO HotelDTO) {
        boolean result = false;
        HotelDTO hotel = new HotelDTO();
        ConnectDatabase conndb = new ConnectDatabase();
        try {

            String query = "insert into hotel (?,?,?,?,?,?)";
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setInt(1,HotelDTO.getHotel_id());
            st.setString(2, HotelDTO.getHotel_name());
            st.setString(3,HotelDTO.getAddress());
            st.setInt(4,HotelDTO.getTel());
            st.setString(5,HotelDTO.getWebsite());
            st.setInt(6,HotelDTO.getStar());
            if (st.executeUpdate()>=1)
                result = true;

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }

    @Override
    public boolean update(HotelDTO HotelDTO) {
        boolean result = false;
        HotelDTO hotel = new HotelDTO();
        ConnectDatabase conndb = new ConnectDatabase();
        try {

            String query = "update hotel set " +
                    "hotel_name=?," +
                    "address=?," +
                    "tel=?," +
                    "website=?," +
                    "star=? where hotel_id = " + HotelDTO.getHotel_id();
            PreparedStatement st = conndb.getConnection().prepareStatement(query);
            st.setString(1, HotelDTO.getHotel_name());
            st.setString(2,HotelDTO.getAddress());
            st.setInt(3,HotelDTO.getTel());
            st.setString(4,HotelDTO.getWebsite());
            st.setInt(5,HotelDTO.getStar());

            if (st.executeUpdate()>=1)
                result = true;

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "delete from hotel where hotel_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            if (st.executeUpdate()>=1)
                result = true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }

    @Override
    public boolean checkExistById(int id) {
        boolean result = false;
        ConnectDatabase conndb = new ConnectDatabase();

        try {
            Connection conn = conndb.getConnection();
            String sql = "select * from hotel where hotel_id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            result = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally {
            conndb.closeConnection();
        }
        return result;
    }
}
