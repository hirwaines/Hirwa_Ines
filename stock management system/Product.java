// Product.java
public class Product {
    private String productId;
    private String productName;
    private String brand;
    private String supplier;
    private int stockQuantity;

    public Product(String productId, String productName, String brand, String supplier, int stockQuantity) {
        setProductId(productId);
        setProductName(productName);
        setBrand(brand);
        setSupplier(supplier);
        setStockQuantity(stockQuantity);
    }

    // Getters and setters with validation
    public String getProductId() { return productId; }
    public void setProductId(String productId) {
        if (productId != null && !productId.isEmpty()) {
            this.productId = productId;
        } else {
            throw new IllegalArgumentException("Product ID cannot be empty");
        }
    }

    public String getProductName() { return productName; }
    public void setProductName(String productName) {
        if (productName != null && !productName.isEmpty()) {
            this.productName = productName;
        } else {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        } else {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
    }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) {
        if (supplier != null && !supplier.isEmpty()) {
            this.supplier = supplier;
        } else {
            throw new IllegalArgumentException("Supplier cannot be empty");
        }
    }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        } else {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
    }

    @Override
    public String toString() {
        return String.format("Product ID: %s\nName: %s\nBrand: %s\nSupplier: %s\nStock: %d",
                            productId, productName, brand, supplier, stockQuantity);
    }
}
