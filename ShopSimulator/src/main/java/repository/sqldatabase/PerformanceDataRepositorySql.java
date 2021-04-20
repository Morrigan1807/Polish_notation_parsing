package repository.sqldatabase;

import model.database.PerformanceDataModel;
import repository.PerformanceDataRepository;

import java.util.List;

public class PerformanceDataRepositorySql implements PerformanceDataRepository {

    @Override
    public void insertPerformanceData(PerformanceDataModel performanceData) {
        //TODO Add insert query to DB (for client)
    }

    @Override
    public void updatePerformanceData(int idPerformanceDataForUpdate, PerformanceDataModel performanceDataWithNewInfo) {
        //TODO Add update query to DB (for client)
    }

    @Override
    public void deletePerformanceData(int idPerformanceDataForDelete) {
        //TODO Add delete query to DB (for client)
    }

    @Override
    public List<PerformanceDataModel> selectAllPerformanceData() {
        //TODO Add select query to DB (for client view)
        return null;
    }

    @Override
    public PerformanceDataModel selectPerformanceDataById(int idPerformanceData) {
        //TODO Add select query to DB (for client)
        return null;
    }
}
