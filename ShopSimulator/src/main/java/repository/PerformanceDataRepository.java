package repository;

import model.database.PerformanceDataModel;

import java.util.List;

public interface PerformanceDataRepository {

    void insertPerformanceData(PerformanceDataModel performanceData);

    void updatePerformanceData(int idPerformanceDataForUpdate, PerformanceDataModel performanceDataWithNewInfo);

    void deletePerformanceData(int idPerformanceDataForDelete);

    List<PerformanceDataModel> selectAllPerformanceData();

    PerformanceDataModel selectPerformanceDataById(int idPerformanceData);
}
