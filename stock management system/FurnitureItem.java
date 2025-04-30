// FurnitureItem.java
public class FurnitureItem extends StockItem {
    private double weight; // in kg
    private boolean isPacked;

    public FurnitureItem(String itemId, String itemName, int quantityInStock, 
                        double pricePerUnit, String supplier, double weight, boolean isPacked) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Furniture", supplier);
        this.weight = weight;
        this.isPacked = isPacked;
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
        return String.format("Furniture Item Report:\nID: %s\nName: %s\nQuantity: %d\nPrice: $%.2f\nWeight: %.2f kg\nPacked: %s\nStock Value: $%.2f",
                           itemId, itemName, quantityInStock, pricePerUnit, weight, isPacked ? "Yes" : "No", calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0 && isPacked;
    }

    public double calculateShippingCost(double distance) {
        return distance * weight * 0.1; // $0.10 per kg per km
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    
    public boolean isPacked() { return isPacked; }
    public void setPacked(boolean packed) { isPacked = packed; }
}

