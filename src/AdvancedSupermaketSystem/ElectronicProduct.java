package AdvancedSupermaketSystem;

public class ElectronicProduct extends InventoryManager {
    private String warrantyPeriod;

    public ElectronicProduct() {
    }

    public ElectronicProduct(String id, String name, double price, int quantity,
                             String supplier, String location, String warrantyPeriod) {
        super(id, name, price, quantity, "Electronic", supplier, location);
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.25;
    }

    @Override
    public String getCategoryDescription() {
        return "Electronic device with warranty coverage";
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty Period: " + warrantyPeriod;
    }
}
