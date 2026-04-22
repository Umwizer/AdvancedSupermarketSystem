package AdvancedSupermaketSystem;

public class InventoryManager extends Product implements Sellable {
    private String supplierName;
    private String storageLocation;

    public InventoryManager() {
    }

    public InventoryManager(String id, String name, double price, int quantity,
                            String category, String supplierName, String storageLocation) {
        super(id, name, price, quantity, category);
        this.supplierName = supplierName;
        this.storageLocation = storageLocation;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.18;
    }

    @Override
    public boolean checkAvailability() {
        return getQuantity() > 0;
    }

    @Override
    public double calculateTotalValue() {
        return getPrice() * getQuantity();
    }

    @Override
    public void updateStock(int amount) {
        int newQuantity = getQuantity() + amount;
        if (newQuantity >= 0) {
            setQuantity(newQuantity);
        } else {
            System.out.println("Error: Stock cannot become negative.");
        }
    }

    @Override
    public boolean validateProduct() {
        return getProductId() != null && !getProductId().trim().isEmpty()
                && getProductName() != null && !getProductName().trim().isEmpty()
                && getPrice() > 0
                && getQuantity() >= 0
                && getCategory() != null && !getCategory().trim().isEmpty()
                && supplierName != null && !supplierName.trim().isEmpty()
                && storageLocation != null && !storageLocation.trim().isEmpty();
    }

    @Override
    public void generateReport() {
        System.out.println("===== PRODUCT REPORT =====");
        System.out.println(this);
        System.out.println("Available: " + checkAvailability());
        System.out.println("Total Stock Value: " + calculateTotalValue());
    }

    @Override
    public String getCategoryDescription() {
        return "General supermarket product";
    }

    @Override
    public void processSale(int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity sold must be greater than zero.");
        } else if (quantity > getQuantity()) {
            System.out.println("Error: Not enough stock available.");
        } else {
            setQuantity(getQuantity() - quantity);
        }
    }

    @Override
    public double calculateFinalPrice(int quantity) {
        double finalUnitPrice = getPrice() + applyTax() - calculateDiscount();
        return finalUnitPrice * quantity;
    }

    @Override
    public void printReceipt() {
        System.out.println("===== RECEIPT =====");
        System.out.println("Product: " + getProductName());
        System.out.println("Category: " + getCategory());
        System.out.println("Unit Price: " + getPrice());
        System.out.println("Discount per Unit: " + calculateDiscount());
        System.out.println("Tax per Unit: " + applyTax());
        System.out.println("Current Stock Remaining: " + getQuantity());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Supplier Name: " + supplierName +
                ", Storage Location: " + storageLocation;
    }
}
