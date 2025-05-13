package views;

import models.Drone;
import services.DroneService;
import utils.ValidationUtils;

public class DroneView extends CommonView {
    private static final DroneService droneService = new DroneService();

    public static Drone getDroneInput() {
        String registrationNumber;
        while (true) {
            System.out.print("Nhập số hiệu: ");
            registrationNumber = ValidationUtils.validateInput("DRN-\\d{3}", "Số hiệu không hợp lệ! Vui lòng nhập lại.");
            if (droneService.findById(registrationNumber) == null) {
                break;
            } else {
                System.out.println("Số hiệu đã tồn tại! Vui lòng nhập số hiệu khác.");
            }
        }

        String manufacturerType = getManufacturerType();
        int productionYear = getProductionYear();
        String coordinator = getCoordinator();

        System.out.print("Nhập tầm bay tối đa (km): ");
        int maxRange = ValidationUtils.validatePositiveInt("Lỗi! Vui lòng nhập lại.");

        return new Drone(registrationNumber, manufacturerType, productionYear, coordinator, maxRange);
    }
}