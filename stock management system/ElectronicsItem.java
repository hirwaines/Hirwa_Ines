// ElectronicsItem.java
public class ElectronicsItem extends StockItem {
    private int warrantyPeriod; // in months

    public ElectronicsItem(String itemId, String itemName, int quantityInStock, 
                         double pricePerUnit, String supplier, int warrantyPeriod) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Electronics", supplier);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void updateStock(int quantity) {
        if (quantityInStock + quantity >= 0) {
            quantityInStock += quantity;
        } else {
            System.out.println("Cannot reduce stock below zero.");
        }
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    @Override
    public String generateStockReport() {
        return String.format("Electronics Item Report:\nID: %s\nName: %s\nQuantity: %d\nPrice: $%.2f\nWarranty: %d months\nStock Value: $%.2f",
                            itemId, itemName, quantityInStock, pricePerUnit, warrantyPeriod, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
    }

    public void applyDiscount(double percentage) {
        if (percentage <= 50) {
            pricePerUnit *= (1 - percentage/100);
            System.out.println("Discount of " + percentage + "% applied.");
        } else {
            System.out.println("Discount cannot exceed 50%.");
        }
    }

    public int getWarrantyPeriod() { return warrantyPeriod; }
    
    public void setWarrantyPeriod(int warrantyPeriod) {
        if (warrantyPeriod >= 0 && warrantyPeriod <= 36) {
            this.warrantyPeriod = warrantyPeriod;
        } else {
            System.out.println("Warranty period must be between 0-36 months.");
        }
    }
}
