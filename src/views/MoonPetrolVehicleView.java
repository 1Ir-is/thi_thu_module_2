package views;


import models.MoonPatrolVehicle;

import services.DroneService;
import services.MoonPatrolVehicleService;
import utils.ValidationUtils;


public class MoonPetrolVehicleView extends CommonView {
    private static final MoonPatrolVehicleService moonPatrolVehicleService = new MoonPatrolVehicleService();
    public static MoonPatrolVehicle getMoonPatrolVehicleInput() {
        String registrationNumber;
        while (true) {
            System.out.print("Nhập số hiệu: ");
            registrationNumber = ValidationUtils.validateInput("XTT-\\d{3}", "Số hiệu không hợp lệ! Vui lòng nhập lại.");
            if (moonPatrolVehicleService.findById(registrationNumber) == null) {
                break;
            } else {
                System.out.println("Số hiệu đã tồn tại! Vui lòng nhập số hiệu khác.");
            }
        }


        String manufacturerType = getManufacturerType();
        int productionYear = getProductionYear();
        String coordinator = getCoordinator();

        System.out.print("Nhập khả năng chống bức xạ: ");
        int radiationResistanceLevel = ValidationUtils.validateInt(1,10);

        return new MoonPatrolVehicle(registrationNumber, manufacturerType, productionYear, coordinator, radiationResistanceLevel);
    }


}
