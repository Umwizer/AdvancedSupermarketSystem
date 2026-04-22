package AdvancedSupermaketSystem;

public class ClothingProduct extends InventoryManager {
    private String size;

    public ClothingProduct() {
    }

    public ClothingProduct(String id, String name, double price, int quantity,
                           String supplier, String location, String size) {
        super(id, name, price, quantity, "Clothing", supplier, location);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.25;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && size != null && !size.trim().isEmpty();
    }

    @Override
    public String getCategoryDescription() {
        return "Wearable clothing item available in sizes";
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}
