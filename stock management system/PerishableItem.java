// PerishableItem.java
import java.time.LocalDate;

public class PerishableItem extends StockItem {
    private LocalDate expirationDate;
    private int shelfLife; // in days

    public PerishableItem(String itemId, String itemName, int quantityInStock, 
                         double pricePerUnit, String supplier, LocalDate expirationDate, int shelfLife) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Perishable", supplier);
        this.expirationDate = expirationDate;
        this.shelfLife = shelfLife;
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
            return quantityInStock * pricePerUnit * 0.5; // 50% discount for near expiration
        }
        return quantityInStock * pricePerUnit;
    }

    @Override
    public String generateStockReport() {
        String status = "Normal";
        if (isExpired()) {
            status = "EXPIRED - NEEDS DISPOSAL";
        } else if (isNearExpiration()) {
            status = "Near Expiration (50% discount applied)";
        }
        
        return String.format("Perishable Item Report:\nID: %s\nName: %s\nQuantity: %d\nPrice: $%.2f\nExpiration: %s\nShelf Life: %d days\nStatus: %s\nStock Value: $%.2f",
                           itemId, itemName, quantityInStock, pricePerUnit, expirationDate, shelfLife, status, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return !isExpired() && quantityInStock > 0;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    public boolean isNearExpiration() {
        return LocalDate.now().plusDays(2).isAfter(expirationDate) && !isExpired();
    }

    public void checkExpirationAlert() {
        if (isExpired()) {
            System.out.println("ALERT: " + itemName + " has expired and needs to be disposed!");
        } else if (isNearExpiration()) {
            System.out.println("Warning: " + itemName + " is nearing expiration. Apply discount.");
        }
    }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }
    
    public int getShelfLife() { return shelfLife; }
    public void setShelfLife(int shelfLife) { this.shelfLife = shelfLife; }
}
