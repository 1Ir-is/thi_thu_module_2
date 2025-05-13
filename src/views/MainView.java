package views;

import utils.ValidationUtils;

public class MainView {
    public static int showMainMenu() {
        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN THÁM HIỂM");
        System.out.println("1. Thêm mới phương tiện.");
        System.out.println("2. Hiển thị danh sách phương tiện.");
        System.out.println("3. Tìm kiếm phương tiện.");
        System.out.println("4. Xoá phương tiện.");
        System.out.println("5. Thoát.");
        System.out.print("Chọn chức năng: ");
        return ValidationUtils.validateMenuChoice(5);
    }
}
