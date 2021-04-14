package repository;

import model.database.SimulationModel;

import java.util.List;

public class SimulationRepositoryImpl implements SimulationRepository {
    @Override
    public void insertSimulation(SimulationModel simulation) {

    }

    @Override
    public void updateSimulation(int idSimulationForUpdate, SimulationModel simulationWithNewInfo) {

    }

    @Override
    public void deleteSimulation(int idSimulationForDelete) {

    }

    @Override
    public List<SimulationModel> selectAllSimulations() {
        return null;
    }

    @Override
    public SimulationModel selectSimulationById(int idSimulationForDelete) {
        return null;
    }

    @Override
    public List<SimulationModel> selectAllSimulationsByIdEntity(String idEntity) {
        return null;
    }
}
