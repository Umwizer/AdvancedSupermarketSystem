package AdvancedSupermaketSystem;

public class ProductFactory {
    public static InventoryManager createProduct(String category, String id, String name,
                                                 double price, int qty,
                                                 String supplier, String location,
                                                 String specificValue) {
        switch (category.toLowerCase()) {
            case "food":
                return new FoodProduct(id, name, price, qty, supplier, location, specificValue);
            case "beverage":
                return new BeverageProduct(id, name, price, qty, supplier, location, specificValue);
            case "electronic":
                return new ElectronicProduct(id, name, price, qty, supplier, location, specificValue);
            case "clothing":
                return new ClothingProduct(id, name, price, qty, supplier, location, specificValue);
            case "cleaning":
                return new CleaningProduct(id, name, price, qty, supplier, location, specificValue);
            case "personalcare":
                return new PersonalCareProduct(id, name, price, qty, supplier, location, specificValue);
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }
}
