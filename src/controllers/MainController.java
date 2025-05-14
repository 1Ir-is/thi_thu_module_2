package controllers;

import exception.NotFoundVehicleException;
import models.Drone;
import models.MoonPatrolVehicle;
import utils.ValidationUtils;
import views.MainView;

import java.util.List;
import java.util.Scanner;

public class MainController {
    private final DroneController droneController = new DroneController();
    private final MoonPatrolVehicleController moonPatrolVehicleController = new MoonPatrolVehicleController();
    private static final Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        boolean exit = false;

        while (!exit) {
            int choice = MainView.showMainMenu();
            switch (choice) {
                case 1:
                    displayAddVehicleMenu();
                    break;
                case 2:
                    displayAllVehicle();
                    break;
                case 3:
                    searchVehicle();
                    break;
                case 4:
                    displayDeleteVehicleMenu();
                    break;
                case 5:
                    displayEditVehicleMenu();
                    break;
                case 6:
                    System.out.print("Bạn có chắc chắn muốn thoát? (y/n): ");
                    String confirmation = scanner.nextLine().trim().toLowerCase();
                    if ("y".equals(confirmation)) {
                        exit = true;
                        System.out.println("Thoát chương trình!");
                    }
                    break;
                default:
                    System.out.println("Lỗi");
            }
        }
    }

    private void displayAddVehicleMenu() {
        System.out.println("1. Thêm drone bay.");
        System.out.println("2. Thêm xe tuần tra.");
        System.out.println("3. Quay về.");
        System.out.print("Lựa chọn của bạn: ");
        int choice = ValidationUtils.validateMenuChoice(3);

        switch (choice) {
            case 1:
                droneController.addDrone();
                break;
            case 2:
                moonPatrolVehicleController.addMoonPatrolVehicle();
                break;
            case 3:
                return;
            default:
                System.out.println("Lỗi! Vui lòng nhập lại.");
        }
    }

    private void displayAllVehicle() {
        droneController.displayDrone();
        moonPatrolVehicleController.displayMoonPatrolVehicle();
    }

    private void searchVehicle() {
        System.out.print("Nhập tên người điều phối: ");
        String keyword = scanner.nextLine();

        List<Drone> drones = droneController.searchDrone(keyword);
        List<MoonPatrolVehicle> moonPatrolVehicles = moonPatrolVehicleController.searchMoonPatrolVehicle(keyword);

        System.out.println("Result: ");
        for (Drone drone : drones) {
            System.out.println(drone);
        }
        for (MoonPatrolVehicle moonPatrolVehicle : moonPatrolVehicles) {
            System.out.println(moonPatrolVehicle);
        }
        if (drones.isEmpty() && moonPatrolVehicles.isEmpty()) {
            System.out.println("Không tìm thấy!");
        }
    }

    private void displayDeleteVehicleMenu() {
        while (true) {
            System.out.print("Nhập số hiệu: ");
            String registrationNumber = scanner.nextLine();

            try {
                if (registrationNumber.startsWith("DRN")) {
                    droneController.deleteDrone(registrationNumber);
                    break;
                } else if (registrationNumber.startsWith("XTT")) {
                    moonPatrolVehicleController.deleteMoonPatrolVehicle(registrationNumber);
                    break;
                } else {
                    System.out.println("Lỗi! Số hiệu phải bắt đầu bằng 'DRN' hoặc 'XTT'.");
                }
            } catch (NotFoundVehicleException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayEditVehicleMenu() {
        while (true) {
            System.out.print("Nhập số hiệu: ");
            String registrationNumber = scanner.nextLine();

            try {
                if (registrationNumber.startsWith("DRN")) {
                    droneController.editDrone(registrationNumber);
                    break;
                } else if (registrationNumber.startsWith("XTT")) {
                    moonPatrolVehicleController.editMoonPatrolVehicle(registrationNumber);
                    break;
                } else {
                    System.out.println("Lỗi! Số hiệu phải bắt đầu bằng 'DRN' hoặc 'XTT'.");
                }
            } catch (NotFoundVehicleException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
