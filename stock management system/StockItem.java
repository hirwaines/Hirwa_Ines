// StockItem.java
public abstract class StockItem {
    protected String itemId;
    protected String itemName;
    protected static int quantityInStock;
    protected double pricePerUnit;
    protected String category;
    protected static String supplier;

    public StockItem(String itemId, String itemName, int quantityInStock, 
                    double pricePerUnit, String category, String supplier) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = quantityInStock;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
        this.supplier = supplier;
    }

    // Abstract methods
    public abstract void updateStock(int quantity);
    public abstract double calculateStockValue();
    public abstract String generateStockReport();
    public abstract boolean validateStock();

    // Getters and setters
    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public int getQuantityInStock() { return quantityInStock; }
    public double getPricePerUnit() { return pricePerUnit; }
    public String getCategory() { return category; }
    public String getSupplier() { return supplier; }

    public void setPricePerUnit(double pricePerUnit) {
        if (pricePerUnit > 0) {
            this.pricePerUnit = pricePerUnit;
        } else {
            System.out.println("Price must be greater than zero.");
        }
    }
}