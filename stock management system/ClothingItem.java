// ClothingItem.java
import java.util.HashMap;

public class ClothingItem extends StockItem {
    private HashMap<String, HashMap<String, Integer>> sizeColorStock; // size -> (color -> quantity)
    private boolean hasDiscount;

    public ClothingItem(String itemId, String itemName, double pricePerUnit, 
                      String supplier, boolean hasDiscount) {
        super(itemId, itemName, 0, pricePerUnit, "Clothing", supplier);
        this.sizeColorStock = new HashMap<>();
        this.hasDiscount = hasDiscount;
    }

    public void addSizeColor(String size, String color, int quantity) {
        sizeColorStock.putIfAbsent(size, new HashMap<>());
        sizeColorStock.get(size).put(color, quantity);
        quantityInStock += quantity;
    }

    @Override
    public void updateStock(int quantity) {
        System.out.println("For Clothing items, use addSizeColor method to update specific size/color stock.");
    }

    @Override
    public double calculateStockValue() {
        double value = quantityInStock * pricePerUnit;
        if (hasDiscount) {
            value *= 0.9; // 10% discount
        }
        return value;
    }

    @Override
    public String generateStockReport() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("Clothing Item Report:\nID: %s\nName: %s\nTotal Quantity: %d\nPrice: $%.2f\n",
                                  itemId, itemName, quantityInStock, pricePerUnit));
        
        report.append("Size/Color Breakdown:\n");
        for (String size : sizeColorStock.keySet()) {
            for (String color : sizeColorStock.get(size).keySet()) {
                report.append(String.format("- %s/%s: %d\n", size, color, sizeColorStock.get(size).get(color)));
            }
        }
        
        report.append(String.format("Stock Value: $%.2f", calculateStockValue()));
        if (hasDiscount) {
            report.append(" (10% discount applied)");
        }
        
        return report.toString();
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
    }

    public boolean hasDiscount() { return hasDiscount; }
    public void setHasDiscount(boolean hasDiscount) { this.hasDiscount = hasDiscount; }
}