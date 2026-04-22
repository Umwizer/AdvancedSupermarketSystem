package AdvancedSupermaketSystem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputValidator {
    private static final Set<String> usedProductIds = new HashSet<>();
    private static final Set<String> usedCustomerIds = new HashSet<>();

    public static String getValidString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty.");
            } else {
                return input;
            }
        }
    }

    public static String getValidName(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty.");
            } else if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("Error: Only letters and spaces are allowed.");
            } else {
                return input;
            }
        }
    }

    public static int getValidInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value <= 0) {
                    System.out.println("Error: Number must be greater than 0.");
                } else if (value > 1_000_000) {
                    System.out.println("Error: Value is too large.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    public static double getValidDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value <= 0) {
                    System.out.println("Error: Value must be greater than 0.");
                } else if (value > 100_000_000) {
                    System.out.println("Error: Value is too large.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    public static String getValidPhone(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String phone = sc.nextLine().trim();
            if (phone.matches("\\d{10}")) {
                return phone;
            }
            System.out.println("Error: Phone number must be exactly 10 digits.");
        }
    }

    public static String getValidProductId(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Error: Product ID cannot be empty.");
            } else if (!id.matches("P\\d{3,}")) {
                System.out.println("Error: Product ID must be like P100 or P1234.");
            } else if (usedProductIds.contains(id)) {
                System.out.println("Error: Duplicate Product ID not allowed.");
            } else {
                usedProductIds.add(id);
                return id;
            }
        }
    }

    public static String getValidCustomerId(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Error: Customer ID cannot be empty.");
            } else if (!id.matches("C\\d{3,}")) {
                System.out.println("Error: Customer ID must be like C100 or C1234.");
            } else if (usedCustomerIds.contains(id)) {
                System.out.println("Error: Duplicate Customer ID not allowed.");
            } else {
                usedCustomerIds.add(id);
                return id;
            }
        }
    }

    public static String getValidCategory(Scanner sc) {
        while (true) {
            System.out.print("Enter category (Food, Beverage, Electronic, Clothing, Cleaning, PersonalCare): ");
            String category = sc.nextLine().trim().toLowerCase();
            if (category.equals("food") || category.equals("beverage") ||
                category.equals("electronic") || category.equals("clothing") ||
                category.equals("cleaning") || category.equals("personalcare")) {
                return category;
            }
            System.out.println("Error: Invalid category. Try again.");
        }
    }

    public static String getCategorySpecificInput(Scanner sc, String category) {
        switch (category.toLowerCase()) {
            case "food":
                return getValidString(sc, "Enter Expiry Date: ");
            case "beverage":
                return getValidString(sc, "Enter Volume: ");
            case "electronic":
                return getValidString(sc, "Enter Warranty Period: ");
            case "clothing":
                return getValidString(sc, "Enter Size: ");
            case "cleaning":
                return getValidString(sc, "Enter Chemical Type: ");
            case "personalcare":
                return getValidString(sc, "Enter Skin Type: ");
            default:
                return "";
        }
    }
}
