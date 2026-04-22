package AdvancedSupermaketSystem;

public class PersonalCareProduct extends InventoryManager {
    private String skinType;

    public PersonalCareProduct() {
    }

    public PersonalCareProduct(String id, String name, double price, int quantity,
                               String supplier, String location, String skinType) {
        super(id, name, price, quantity, "PersonalCare", supplier, location);
        this.skinType = skinType;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.18;
    }

    @Override
    public boolean validateProduct() {
        return super.validateProduct() && skinType != null && !skinType.trim().isEmpty();
    }

    @Override
    public String getCategoryDescription() {
        return "Personal care product for a specific skin type";
    }

    @Override
    public String toString() {
        return super.toString() + ", Skin Type: " + skinType;
    }
}
