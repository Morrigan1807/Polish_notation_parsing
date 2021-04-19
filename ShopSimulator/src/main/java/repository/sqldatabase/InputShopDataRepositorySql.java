package repository.sqldatabase;

import model.database.InputShopDataModel;
import repository.InputShopDataRepository;

import java.util.List;

public class InputShopDataRepositorySql implements InputShopDataRepository {

    @Override
    public void insertInputShopData(InputShopDataModel inputShopData) {

    }

    @Override
    public void updateInputShopData(int idInputShopData, InputShopDataModel inputShopDataWithNewInfo) {

    }

    @Override
    public void deleteInputShopData(int idiInputShopDataForDelete) {

    }

    @Override
    public List<InputShopDataModel> selectAllInputShopData() {
        return null;
    }

    @Override
    public InputShopDataModel selectInputShopDataById(int idInputShopData) {
        return null;
    }
}
