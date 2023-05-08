package BUS;

import DAO.PlaceDAO;
import DTO.PlaceDTO;
import org.apache.poi.ss.formula.SheetRangeAndWorkbookIndexFormatter;

import java.util.ArrayList;

public class PlaceBus {
    PlaceDAO pd = new PlaceDAO();

    public ArrayList<PlaceDTO> getAll() {
        return pd.getAll();
    }

    public  ArrayList<PlaceDTO> getPlacesByRegionCode(String rc) {
        return pd.getPlacesByRegionCode(rc);
    }
}
