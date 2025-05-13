package controllers;

import models.Drone;
import services.DroneService;
import views.DroneView;
import exception.NotFoundVehicleException;

import java.util.List;

public class DroneController {
    private final DroneService droneService = new DroneService();

    public void addDrone() {
        Drone drone = DroneView.getDroneInput();
        droneService.add(drone);
        System.out.println("Thêm thành công!");
    }

    public void displayDrone() {
        List<Drone> drones = droneService.findAll();
        for (Drone drone : drones) {
            System.out.println(drone);
        }
    }

    public List<Drone> searchDrone(String keyword) {
        return droneService.searchByNameCoordinator(keyword);
    }

    public void deleteDrone(String registrationNumber) throws NotFoundVehicleException {
        Drone drone = droneService.findById(registrationNumber);
        if (drone == null) {
            throw new NotFoundVehicleException("Vehicle registration number does not exist.");
        }
        droneService.delete(registrationNumber);
        System.out.println("Deleted successfully!");
    }
}