
package AdvancedSupermaketSystem;
import java.util.Scanner;

public class SupermarketSystem  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== SUPERMARKET MANAGEMENT SYSTEM =====");

        String category = InputValidator.getValidCategory(sc);
        String id = InputValidator.getValidProductId(sc, "Enter Product ID (e.g. P100): ");
        String name = InputValidator.getValidName(sc, "Enter Product Name: ");
        double price = InputValidator.getValidDouble(sc, "Enter Price: ");
        int qty = InputValidator.getValidInt(sc, "Enter Quantity: ");
        String supplier = InputValidator.getValidString(sc, "Enter Supplier Name: ");
        String location = InputValidator.getValidString(sc, "Enter Storage Location: ");
        String specificValue = InputValidator.getCategorySpecificInput(sc, category);

        Product product = ProductFactory.createProduct(category, id, name, price, qty, supplier, location, specificValue);

        if (!product.validateProduct()) {
            System.out.println("Error: Product validation failed.");
            sc.close();
            return;
        }

        System.out.println("\n===== PRODUCT DETAILS =====");
        System.out.println(product);
        System.out.println("Category Description: " + product.getCategoryDescription());
        product.generateReport();

        String custId = InputValidator.getValidCustomerId(sc, "Enter Customer ID (e.g. C100): ");
        String custName = InputValidator.getValidName(sc, "Enter Customer Name: ");
        String phone = InputValidator.getValidPhone(sc, "Enter Phone Number (10 digits): ");

        Customer customer = new Customer(custId, custName, phone);

        int orderQty;
        while (true) {
            orderQty = InputValidator.getValidInt(sc, "Enter Quantity to Purchase: ");
            if (orderQty <= product.getQuantity()) {
                break;
            }
            System.out.println("Error: Not enough stock available.");
        }

        if (product instanceof Sellable) {
            Sellable sellableProduct = (Sellable) product;
            sellableProduct.processSale(orderQty);
        }

        Order order = new Order("ORD001", product, orderQty);

        System.out.println("\n===== CUSTOMER DETAILS =====");
        System.out.println(customer);

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println(order);

        if (product instanceof Sellable) {
            Sellable sellableProduct = (Sellable) product;
            sellableProduct.printReceipt();
        }

        sc.close();
    }
}
