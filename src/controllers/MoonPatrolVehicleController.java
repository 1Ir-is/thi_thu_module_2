package controllers;

import models.MoonPatrolVehicle;
import services.MoonPatrolVehicleService;
import views.MoonPetrolVehicleView;

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

    public void deleteMoonPatrolVehicle() {
        String registrationNumberToDelete = MoonPetrolVehicleView.getIdToDelete();
        moonPatrolVehicleService.delete(registrationNumberToDelete);
        System.out.println("Xoá thành công!");
    }
}
