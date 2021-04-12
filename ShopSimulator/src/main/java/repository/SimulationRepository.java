package repository;

import model.database.SimulationModel;

import java.util.List;

public interface SimulationRepository {

    void insertSimulation(SimulationModel simulation);

    void updateSimulation(int idSimulationForUpdate, SimulationModel simulationWithNewInfo);

    void deleteSimulation(int idSimulationForDelete);

    List<SimulationModel> selectAllSimulations();

    SimulationModel selectSimulationById(int idSimulationForDelete);

    List<SimulationModel> selectAllSimulationsByIdEntity(int idEntity);
}
