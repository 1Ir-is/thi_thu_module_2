package utils;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validateInput(String regex, String errorMessage) {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Không được để trống. Hãy thử lại!");
                continue;
            }

            if (Pattern.matches(regex, input)) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }


    public static int validateMenuChoice(int max) {
        int choice;
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Không được để trống! Hãy nhập giá trị từ " + 1 + " và " + max);
                    continue;
                }
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Invalid choice! Hãy nhập giá trị từ " + 1 + " và " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi, Hãy thử lại!");
            }
        }
    }

    public static int validatePositiveInt(String errorMessage) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Không được để trống. Hãy thử lại!");
                continue;
            }
            try {
                int value = Integer.parseInt(input);
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi, Hãy thử lại!");
            }
        }
    }

    public static int validateInt(int minValue, int maxValue) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value > 0 && value < 10) {
                    return value;
                } else {
                    System.out.print("Giá trị phải từ " + minValue + " đến " + maxValue + ". Hãy thử lại!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi, Hãy thử lại!");
            }
        }
    }
}
