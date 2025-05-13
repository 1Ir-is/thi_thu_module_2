package services;

import models.Drone;
import repositories.DroneRepository;

import java.util.List;

public class DroneService implements IVehicleService<Drone> {
    private final DroneRepository droneRepository = new DroneRepository();

    @Override
    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    @Override
    public void add(Drone vehicle) {
        droneRepository.add(vehicle);
    }

    @Override
    public void delete(String registrationNumber) {
        droneRepository.delete(registrationNumber);
    }

    @Override
    public List<Drone> searchByNameCoordinator(String keyword) {
        return droneRepository.searchByName(keyword);
    }
}
