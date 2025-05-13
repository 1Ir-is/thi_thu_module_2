package views;

import models.ManufacturerType;
import services.manufacturerType.IManufacturerTypeService;
import services.manufacturerType.ManufacturerTypeService;
import utils.SaveFileUtils;
import utils.ValidationUtils;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CommonView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getManufacturerType() {
        IManufacturerTypeService manufacturerTypeService = new ManufacturerTypeService();
        List<ManufacturerType> manufacturerTypes = manufacturerTypeService.getAllManufacturers();

        System.out.println("Danh sách các hãng chế tạo.");
        for (int i = 0; i < manufacturerTypes.size(); i++) {
            System.out.println((i + 1) + ". " + manufacturerTypes.get(i).getName() + " (" + manufacturerTypes.get(i).getCountry() + ")");
        }

        String manufacturerType = null;
        while (true) {
            System.out.print("Hãy chọn số: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= manufacturerTypes.size()) {
                    manufacturerType = manufacturerTypes.get(choice - 1).getName();
                    break;
                } else {
                    System.out.println("Lỗi! Vui lòng nhập số hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi! Vui lòng nhập số.");
            }
        }
        return manufacturerType;
    }

    public static int getProductionYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int productionYear;
        while (true) {
            System.out.print("Nhập năm sản xuất: ");
            productionYear = ValidationUtils.validatePositiveInt("Lỗi! Vui lòng nhập lại.");
            if (productionYear <= currentYear) {
                break;
            } else {
                System.out.println("Năm sản xuất không được lớn hơn năm hiện tại!");
            }
        }
        return productionYear;
    }

    public static String getCoordinator() {
        System.out.print("Nhập tên người điều phối: ");
        return ValidationUtils.validateInput("[A-Z][a-z]*(\\s[A-Z][a-z]*)*", "Tên phải bắt đầu bằng chữ hoa.");
    }
}

