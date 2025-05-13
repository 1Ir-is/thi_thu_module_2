package views;

import models.Drone;
import utils.SaveFileUtils;
import utils.ValidationUtils;

import java.util.List;
import java.util.Scanner;

public class DroneView extends CommonView {
    private static final String MANUFACTURER_TYPE_FILE = "src/datas/hangCheTao.csv";
    private static final Scanner scanner = new Scanner(System.in);

    public static Drone getDroneInput() {
        System.out.print("Nhập số hiệu: ");
        String registrationNumber = ValidationUtils.validateInput("DRN-\\d{3}", "Số hiệu không hợp lệ! Vui lòng nhập lại.");

        List<String> manufacturerTypes = SaveFileUtils.readFromFile(MANUFACTURER_TYPE_FILE);
        System.out.println("Danh sách các hãng chế tạo.");
        for (int i = 0; i < manufacturerTypes.size(); i++) {
            System.out.println((i + 1) + ". " + manufacturerTypes.get(i));
        }

        String manufacturerType = null;
        while (true) {
            System.out.print("Hãy chọn số: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= manufacturerTypes.size()) {
                    manufacturerType = manufacturerTypes.get(choice - 1).split(",")[0];
                    break;
                } else {
                    System.out.println("Lỗi! Vui lòng nhập số hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi! Vui lòng nhập số.");
            }
        }

        System.out.print("Nhập năm sản xuất: ");
        int productionYear = ValidationUtils.validatePositiveInt("Lỗi! Vui lòng nhập lại.");

        System.out.print("Nhập tên người điều phối: ");
        String coordinator = ValidationUtils.validateInput("[A-Z][a-z]*(\\s[A-Z][a-z]*)*", "Tên phải bắt đầu bằng chữ hoa.");

        System.out.print("Nhập tầm bay tối đa (km): ");
        int maxRange = ValidationUtils.validatePositiveInt("Lỗi! Vui lòng nhập lại.");

        return new Drone(registrationNumber, manufacturerType, productionYear, coordinator, maxRange);
    }
}
