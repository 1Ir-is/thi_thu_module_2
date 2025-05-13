package views;

import utils.SaveFileUtils;
import utils.ValidationUtils;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CommonView {
    private static final String MANUFACTURER_TYPE_FILE = "src/datas/hangCheTao.csv";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getManufacturerType() {
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
                    manufacturerType = manufacturerTypes.get(choice - 1).split(",")[1];
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

