package repository.sqldatabase;

import model.database.SimulationModel;
import repository.SimulationRepository;

import java.util.List;

public class SimulationRepositorySql implements SimulationRepository {

    @Override
    public void insertSimulation(SimulationModel simulation) {
        //TODO Add insert query to DB (for client)
    }

    @Override
    public void updateSimulation(int idSimulationForUpdate, SimulationModel simulationWithNewInfo) {
        //TODO Add update query to DB (for client)
    }

    @Override
    public void deleteSimulation(int idSimulationForDelete) {
        //TODO Add delete query to DB (for client)
    }

    @Override
    public List<SimulationModel> selectAllSimulations() {
        //TODO Add select query to DB (for client)
        return null;
    }

    @Override
    public SimulationModel selectSimulationById(int idSimulationForDelete) {
        //TODO Add select query to DB (for client)
        return null;
    }

    @Override
    public List<SimulationModel> selectAllSimulationsByIdEntity(String idEntity) {
        //TODO Add select query to DB (for client view)
        return null;
    }
}
