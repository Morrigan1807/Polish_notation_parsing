package repository;

import model.database.PerformanceIndicatorsModel;

import java.util.List;

public interface PerformanceIndicatorsRepository {

    void insertPerformanceIndicators(PerformanceIndicatorsModel performanceIndicators);

    void updatePerformanceIndicators(int idPerformanceIndicatorsForUpdate, PerformanceIndicatorsModel performanceIndicatorsWithNewInfo);

    void deletePerformanceIndicators(int idPerformanceIndicatorsForDelete);

    List<PerformanceIndicatorsModel> selectAllPerformanceIndicators();

    PerformanceIndicatorsModel selectPerformanceIndicatorsById(int idPerformanceIndicators);
}
