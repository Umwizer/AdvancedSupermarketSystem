package AdvancedSupermaketSystem;

public class BeverageProduct extends InventoryManager {
    private String volume;

    public BeverageProduct() {
    }

    public BeverageProduct(String id, String name, double price, int quantity,
                           String supplier, String location, String volume) {
        super(id, name, price, quantity, "Beverage", supplier, location);
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && volume != null && !volume.trim().isEmpty();
    }

    @Override
    public String getCategoryDescription() {
        return "Liquid drink product measured by volume";
    }

    @Override
    public String toString() {
        return super.toString() + ", Volume: " + volume;
    }
}
