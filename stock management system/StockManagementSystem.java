// StockManagementSystem.java
import java.time.LocalDate;
import java.util.Scanner;

public class StockManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create sample items
        ElectronicsItem laptop = new ElectronicsItem("E1001", "Laptop", 10, 999.99, "TechSuppliers", 24);
        ClothingItem shirt = new ClothingItem("C2001", "T-Shirt", 19.99, "FashionInc", true);
        shirt.addSizeColor("M", "Blue", 5);
        shirt.addSizeColor("L", "Red", 5);
        
        GroceryItem milk = new GroceryItem("G3001", "Milk", 50, 2.99, "DairyFarm", LocalDate.now().plusDays(5));
        FurnitureItem chair = new FurnitureItem("F4001", "Office Chair", 15, 129.99, "FurnitureWorld", 8.5, true);
        PerishableItem banana = new PerishableItem("P5001", "Banana", 100, 0.49, "FruitCo", 
                                                  LocalDate.now().plusDays(3), 5);
        
        // Create sample product, supplier, and warehouse
        Product sampleProduct = new Product("PRD001", "Wireless Mouse", "LogiTech", "TechSuppliers", 25);
        Supplier techSupplier = new Supplier("SUP001", "TechSuppliers Inc.", "John Smith", 
                                           "+1 (555) 123-4567", "john.smith@techsuppliers.com");
        Warehouse mainWarehouse = new Warehouse("WH001", "123 Main St, Anytown", (int) 5000.0, "Sarah Johnson");
        
        // Display menu
        while (true) {
            System.out.println("\nStock Management System");
            System.out.println("1. View Product Reports");
            System.out.println("2. Update Stock");
            System.out.println("3. View Supplier Information");
            System.out.println("4. View Warehouse Information");
            System.out.println("5. Generate Inventory Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("\nProduct Reports:");
                    System.out.println("1. Laptop (Electronics)");
                    System.out.println("2. T-Shirt (Clothing)");
                    System.out.println("3. Milk (Grocery)");
                    System.out.println("4. Office Chair (Furniture)");
                    System.out.println("5. Banana (Perishable)");
                    System.out.print("Select product: ");
                    int productChoice = scanner.nextInt();
                    
                    switch (productChoice) {
                        case 1:
                            System.out.println("\n" + laptop.generateStockReport());
                            break;
                        case 2:
                            System.out.println("\n" + shirt.generateStockReport());
                            break;
                        case 3:
                            System.out.println("\n" + milk.generateStockReport());
                            break;
                        case 4:
                            System.out.println("\n" + chair.generateStockReport());
                            break;
                        case 5:
                            System.out.println("\n" + banana.generateStockReport());
                            banana.checkExpirationAlert();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                    
                case 2:
                    System.out.println("\nUpdate Stock:");
                    System.out.println("1. Laptop (Electronics)");
                    System.out.println("2. T-Shirt (Clothing)");
                    System.out.println("3. Milk (Grocery)");
                    System.out.println("4. Office Chair (Furniture)");
                    System.out.println("5. Banana (Perishable)");
                    System.out.print("Select product: ");
                    int updateChoice = scanner.nextInt();
                    System.out.print("Enter quantity to add (negative to remove): ");
                    int quantity = scanner.nextInt();
                    
                    switch (updateChoice) {
                        case 1:
                            laptop.updateStock(quantity);
                            System.out.println("Laptop stock updated. New quantity: " + laptop.getQuantityInStock());
                            break;
                        case 2:
                            System.out.println("For clothing items, please use the addSizeColor method in code.");
                            break;
                        case 3:
                            milk.updateStock(quantity);
                            System.out.println("Milk stock updated. New quantity: " + milk.getQuantityInStock());
                            break;
                        case 4:
                            chair.updateStock(quantity);
                            System.out.println("Chair stock updated. New quantity: " + chair.getQuantityInStock());
                            break;
                        case 5:
                            banana.updateStock(quantity);
                            System.out.println("Banana stock updated. New quantity: " + banana.getQuantityInStock());
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                    
                case 3:
                    System.out.println("\nSupplier Information:");
                    System.out.println(techSupplier);
                    break;
                    
                case 4:
                    System.out.println("\nWarehouse Information:");
                    System.out.println(mainWarehouse);
                    break;
                    
                case 5:
                    System.out.println("\nInventory Report:");
                    StockItem[] allItems = {laptop, shirt, milk, chair, banana};
                    
                    break;
                    
                case 6:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}