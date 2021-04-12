package repository;

import model.database.InputShopDataModel;

import java.util.List;

public interface InputShopDataRepository {

    void insertInputShopData(InputShopDataModel inputShopData);

    void updateInputShopData(int idInputShopData, InputShopDataModel inputShopDataWithNewInfo);

    void deleteInputShopData(int idiInputShopDataForDelete);

    List<InputShopDataModel> selectAllInputShopData();

    InputShopDataModel selectInputShopDataById(int idInputShopData);
}
