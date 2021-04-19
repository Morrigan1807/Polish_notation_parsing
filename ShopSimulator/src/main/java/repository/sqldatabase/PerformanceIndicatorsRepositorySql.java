package repository.sqldatabase;

import model.database.PerformanceIndicatorsModel;
import repository.PerformanceIndicatorsRepository;

import java.util.List;

public class PerformanceIndicatorsRepositorySql implements PerformanceIndicatorsRepository {

    @Override
    public void insertPerformanceIndicators(PerformanceIndicatorsModel performanceIndicators) {

    }

    @Override
    public void updatePerformanceIndicators(int idPerformanceIndicatorsForUpdate, PerformanceIndicatorsModel performanceIndicatorsWithNewInfo) {

    }

    @Override
    public void deletePerformanceIndicators(int idPerformanceIndicatorsForDelete) {

    }

    @Override
    public List<PerformanceIndicatorsModel> selectAllPerformanceIndicators() {
        return null;
    }

    @Override
    public PerformanceIndicatorsModel selectPerformanceIndicatorsById(int idPerformanceIndicators) {
        return null;
    }
}
