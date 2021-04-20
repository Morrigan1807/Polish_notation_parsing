package repository.sqldatabase;

import model.database.InputShopDataModel;
import repository.InputShopDataRepository;

import java.util.List;

public class InputShopDataRepositorySql implements InputShopDataRepository {

    @Override
    public void insertInputShopData(InputShopDataModel inputShopData) {
        //TODO Add insert query to DB (for client)
    }

    @Override
    public void updateInputShopData(int idInputShopData, InputShopDataModel inputShopDataWithNewInfo) {
        //TODO Add update query to DB (for client)
    }

    @Override
    public void deleteInputShopData(int idiInputShopDataForDelete) {
        //TODO Add delete query to DB (for client)
    }

    @Override
    public List<InputShopDataModel> selectAllInputShopData() {
        //TODO Add select query to DB (for client view)
        return null;
    }

    @Override
    public InputShopDataModel selectInputShopDataById(int idInputShopData) {
        //TODO Add select query to DB (for client)
        return null;
    }
}
