package AdvancedSupermaketSystem;

public class CleaningProduct extends InventoryManager {
    private String chemicalType;

    public CleaningProduct() {
    }

    public CleaningProduct(String id, String name, double price, int quantity,
                           String supplier, String location, String chemicalType) {
        super(id, name, price, quantity, "Cleaning", supplier, location);
        this.chemicalType = chemicalType;
    }

    public String getChemicalType() {
        return chemicalType;
    }

    public void setChemicalType(String chemicalType) {
        this.chemicalType = chemicalType;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.20;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && chemicalType != null && !chemicalType.trim().isEmpty();
    }

    @Override
    public String getCategoryDescription() {
        return "Cleaning product defined by chemical type";
    }

    @Override
    public String toString() {
        return super.toString() + ", Chemical Type: " + chemicalType;
    }
}
