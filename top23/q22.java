import java.util.*;

// Interface for purchasable items
interface Purchasable {
    void addItem(String itemName, double itemPrice);
    void removeItem(String itemName);
    double calculateTotalPrice();
}

// Class representing Electronics items
class Electronics implements Purchasable {
    private Map<String, Double> items = new HashMap<>();

    @Override
    public void addItem(String itemName, double itemPrice) {
        items.put(itemName, itemPrice);
    }

    @Override
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    @Override
    public double calculateTotalPrice() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}

// Class representing Clothing items
class Clothing implements Purchasable {
    private Map<String, Double> items = new HashMap<>();

    @Override
    public void addItem(String itemName, double itemPrice) {
        items.put(itemName, itemPrice);
    }

    @Override
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    @Override
    public double calculateTotalPrice() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}

// Class representing Books items
class Books implements Purchasable {
    private Map<String, Double> items = new HashMap<>();

    @Override
    public void addItem(String itemName, double itemPrice) {
        items.put(itemName, itemPrice);
    }

    @Override
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    @Override
    public double calculateTotalPrice() {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}

// Shopping cart manager class
class ShoppingCartManager {
    private Map<String, Purchasable> items = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addItem(String itemType, String itemName, double itemPrice) {
        Purchasable item;
        switch (itemType.toLowerCase()) {
            case "electronics":
                item = new Electronics();
                break;
            case "clothing":
                item = new Clothing();
                break;
            case "books":
                item = new Books();
                break;
            default:
                System.out.println("Invalid item type.");
                return;
        }
        item.addItem(itemName, itemPrice);
        items.put(itemName, item);
    }

    public void removeItem(String itemName) {
        Purchasable item = items.get(itemName);
        if (item != null) {
            item.removeItem(itemName);
            items.remove(itemName);
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Purchasable item : items.values()) {
            totalPrice += item.calculateTotalPrice();
        }
        return totalPrice;
    }
}

// Main class to manage user interactions
public class q22 {
    public static void main(String[] args) {
        ShoppingCartManager cartManager = new ShoppingCartManager();
        Scanner scanner = new Scanner(System.in);

        boolean shopping = true;
        while (shopping) {
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Calculate Total Price");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item type (Electronics/Clothing/Books): ");
                    String itemType = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    cartManager.addItem(itemType, itemName, itemPrice);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    cartManager.removeItem(itemToRemove);
                    break;
                case 3:
                    double totalPrice = cartManager.calculateTotalPrice();
                    System.out.println("Total Price: $" + totalPrice);
                    break;
                case 4:
                    shopping = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
