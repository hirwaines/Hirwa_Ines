// GroceryItem.java
import java.time.LocalDate;

public class GroceryItem extends StockItem {
    private LocalDate expirationDate;

    public GroceryItem(String itemId, String itemName, int quantityInStock, 
                      double pricePerUnit, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Groceries", supplier);
        this.expirationDate = expirationDate;
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
        if (isNearExpiration()) {
            return quantityInStock * pricePerUnit * 0.7; // 30% discount for near expiration
        }
        return quantityInStock * pricePerUnit;
    }

    @Override
    public String generateStockReport() {
        String status = "Normal";
        if (isExpired()) {
            status = "EXPIRED";
        } else if (isNearExpiration()) {
            status = "Near Expiration (30% discount applied)";
        }
        
        return String.format("Grocery Item Report:\nID: %s\nName: %s\nQuantity: %d\nPrice: $%.2f\nExpiration: %s\nStatus: %s\nStock Value: $%.2f",
                           itemId, itemName, quantityInStock, pricePerUnit, expirationDate, status, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return !isExpired() && quantityInStock > 0;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    public boolean isNearExpiration() {
        return LocalDate.now().plusDays(7).isAfter(expirationDate) && !isExpired();
    }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }
}