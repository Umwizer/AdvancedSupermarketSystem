package AdvancedSupermaketSystem;

public class FoodProduct extends InventoryManager {
    private String expiryDate;

    public FoodProduct() {
    }

    public FoodProduct(String id, String name, double price, int quantity,
                       String supplier, String location, String expiryDate) {
        super(id, name, price, quantity, "Food", supplier, location);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && expiryDate != null && !expiryDate.trim().isEmpty();
    }

    @Override
    public String getCategoryDescription() {
        return "Perishable food item with an expiry date";
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiry Date: " + expiryDate;
    }
}
