package controllers;

import models.MoonPatrolVehicle;
import services.vehicle.MoonPatrolVehicleService;
import views.MoonPetrolVehicleView;
import exception.NotFoundVehicleException;

import java.util.List;

public class MoonPatrolVehicleController {
    private final MoonPatrolVehicleService moonPatrolVehicleService = new MoonPatrolVehicleService();

    public void addMoonPatrolVehicle() {
        MoonPatrolVehicle moonPatrolVehicle = MoonPetrolVehicleView.getMoonPatrolVehicleInput();
        moonPatrolVehicleService.add(moonPatrolVehicle);
        System.out.println("Thêm thành công!");
    }

    public void displayMoonPatrolVehicle() {
        List<MoonPatrolVehicle> moonPatrolVehicles = moonPatrolVehicleService.findAll();
        for (MoonPatrolVehicle moonPatrolVehicle : moonPatrolVehicles) {
            System.out.println(moonPatrolVehicle);
        }
    }

    public List<MoonPatrolVehicle> searchMoonPatrolVehicle(String keyword) {
        return moonPatrolVehicleService.searchByNameCoordinator(keyword);
    }

    public void deleteMoonPatrolVehicle(String registrationNumber) throws NotFoundVehicleException {
        MoonPatrolVehicle moonPatrolVehicle = moonPatrolVehicleService.findById(registrationNumber);
        if (moonPatrolVehicle == null) {
            throw new NotFoundVehicleException("Vehicle registration number does not exist.");
        }
        moonPatrolVehicleService.delete(registrationNumber);
        System.out.println("Deleted successfully!");
    }

    public void editMoonPatrolVehicle(String registrationNumber) throws NotFoundVehicleException {
        MoonPatrolVehicle existingVehicle = moonPatrolVehicleService.findById(registrationNumber);
        if (existingVehicle == null) {
            throw new NotFoundVehicleException("Số hiệu không tồn tại!");
        }
        MoonPatrolVehicle updatedVehicle = MoonPetrolVehicleView.getMoonPatrolVehicleUpdateInput(registrationNumber);
        moonPatrolVehicleService.edit(registrationNumber, updatedVehicle);
        System.out.println("Cập nhật thành công!");
    }
}