package AdvancedSupermaketSystem;

public class Order {
    private String orderId;
    private Product product;
    private int quantityPurchased;
    private double totalPrice;

    public Order() {
    }

    public Order(String orderId, Product product, int quantityPurchased) {
        this.orderId = orderId;
        this.product = product;
        this.quantityPurchased = quantityPurchased;
        this.totalPrice = calculateTotalPrice();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.totalPrice = calculateTotalPrice();
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
        this.totalPrice = calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double calculateTotalPrice() {
        if (product instanceof Sellable) {
            Sellable sellableProduct = (Sellable) product;
            return sellableProduct.calculateFinalPrice(quantityPurchased);
        }
        return product.getPrice() * quantityPurchased;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                "\nProduct: " + product.getProductName() +
                "\nQuantity Purchased: " + quantityPurchased +
                "\nTotal Price: " + totalPrice;
    }
}
