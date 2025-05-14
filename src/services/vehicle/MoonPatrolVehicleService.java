package services.vehicle;

import models.MoonPatrolVehicle;
import repositories.vehicles.MoonPatrolVehicleRepository;

import java.util.List;

public class MoonPatrolVehicleService implements IVehicleService<MoonPatrolVehicle> {
    private final MoonPatrolVehicleRepository moonPatrolVehicleRepository = new MoonPatrolVehicleRepository();

    @Override
    public List<MoonPatrolVehicle> findAll() {
        return moonPatrolVehicleRepository.findAll();
    }

    @Override
    public void add(MoonPatrolVehicle vehicle) {
        moonPatrolVehicleRepository.add(vehicle);
    }

    @Override
    public void delete(String registrationNumber) {
        moonPatrolVehicleRepository.delete(registrationNumber);
    }

    @Override
    public List<MoonPatrolVehicle> searchByNameCoordinator(String keyword) {
        return moonPatrolVehicleRepository.searchByName(keyword);
    }

    @Override
    public MoonPatrolVehicle findById(String registrationNumber) {
        return moonPatrolVehicleRepository.findById(registrationNumber);
    }

    @Override
    public void edit(String registrationNumber, MoonPatrolVehicle updatedVehicle) {
        moonPatrolVehicleRepository.edit(registrationNumber, updatedVehicle);
    }
}