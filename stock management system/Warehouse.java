// Warehouse.java
public class Warehouse {
    private String warehouseId;
    private String location;
    private double capacity; // in cubic meters
    private String managerName;

    public Warehouse(String warehouseId, String location, double capacity, String managerName) {
        setWarehouseId(warehouseId);
        setLocation(location);
        setCapacity(capacity);
        setManagerName(managerName);
    }

    // Getters and setters with validation
    public String getWarehouseId() { return warehouseId; }
    public void setWarehouseId(String warehouseId) {
        if (warehouseId != null && !warehouseId.isEmpty()) {
            this.warehouseId = warehouseId;
        } else {
            throw new IllegalArgumentException("Warehouse ID cannot be empty");
        }
    }

    public String getLocation() { return location; }
    public void setLocation(String location) {
        if (location != null && !location.isEmpty()) {
            this.location = location;
        } else {
            throw new IllegalArgumentException("Location cannot be empty");
        }
    }

    public double getCapacity() { return capacity; }
    public void setCapacity(double capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Capacity must be positive");
        }
    }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) {
        if (managerName != null && !managerName.isEmpty()) {
            this.managerName = managerName;
        } else {
            throw new IllegalArgumentException("Manager name cannot be empty");
        }
    }

    public String generateInventoryReport(StockItem[] items) {
        StringBuilder report = new StringBuilder();
        report.append(String.format("Warehouse %s Inventory Report\nLocation: %s\nManager: %s\nCapacity: %.2f m³\n\n",
                                  warehouseId, location, managerName, capacity));
        
        report.append("Items in Stock:\n");
        double totalValue = 0;
        for (StockItem item : items) {
            report.append(item.generateStockReport()).append("\n\n");
            totalValue += item.calculateStockValue();
        }
        
        report.append(String.format("Total Inventory Value: $%.2f", totalValue));
        return report.toString();
    }

    @Override
    public String toString() {
        return String.format("Warehouse ID: %s\nLocation: %s\nCapacity: %.2f m³\nManager: %s",
                            warehouseId, location, capacity, managerName);
    }
}
