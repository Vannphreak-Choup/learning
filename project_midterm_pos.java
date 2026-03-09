import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class project_midterm_pos {
    public static void condition() {
        List<String> order = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String user;
        while (true) {
            System.out.println("\n1. Add to Cart\n2. View Item in Cart\n3. Remove Item From Cart\n4. Checkout");
            System.out.print("Enter your input: ");
            user = scanner.nextLine();
            if (user.equals("1")) {
                System.out.print("Enter your product id: ");
                String add = scanner.nextLine();
                AddtoCart(add, order);

            }else if (user.equals("2")) {
                System.out.println("Cart:  " + order);

            }else if (user.equals("3")) {
                System.out.print("Enter your removal item: ");
                String remove = scanner.nextLine();
                RemoveItem(remove, order);
            }else if (user.equals("4")) {
                CheckOut(order);
                break;

            }else {
                System.out.println("Invalid input! Nuh Ah");
            }

        }scanner.close();

    }


    public static void AddtoCart(String ProductID, List<String> cart) {
        for (int i = 0; i < id.size(); i++) {
            if (ProductID.equalsIgnoreCase(id.get(i))) {
                cart.add(products.get(i));
                System.out.println("\n" + products.get(i) + " is added into your cart!");
                return;
            }
        }
        System.out.println("Product ID not found!!");
    }
    public static void RemoveItem(String ProductID, List<String> cart) {
        for (int i = 0; i < id.size(); i++) {
            if (cart.isEmpty()) {
                System.out.println("Your Cart is Empty!!");
                return;

            }else if (!cart.contains(products.get(i)) && !ProductID.equalsIgnoreCase(id.get(i))) {
                System.out.println("You cart does not contain this item");
                return;

            }else if (cart.contains(products.get(i)) && ProductID.equalsIgnoreCase(id.get(i))) {
                cart.remove(products.get(i));
                System.out.println("\n" + products.get(i) + " has been removed!");
                return;
            }
        }
    }
    public static void CheckOut(List<String> value) {

        if (value.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        List<String> printed = new ArrayList<>();
        double subtotal = 0;
        System.out.println("\n\n====================================");
        System.out.println("              ABC STORE");
        System.out.println("        Phnom Penh, Cambodia");
        System.out.println("        Tel: +855 12 345 678");
        System.out.println("====================================");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Date: " + now.toLocalDate());
        System.out.println("Time: " + now.toLocalTime().withNano(0));
        System.out.println("Cashier: System");
        System.out.println("\n------------------------------------");
        System.out.printf("%-20s %-5s %-10s\n", "Item", "Qty", "Price");
        System.out.println("------------------------------------");
        for (int i = 0; i < value.size(); i++) {
            String currentItem = value.get(i);
            if (printed.contains(currentItem)) {
                continue;
            }
            int qty = 0;
            for (int j = 0; j < value.size(); j++) {
                if (currentItem.equals(value.get(j))) {
                    qty++;
                }
            }
            int index = products.indexOf(currentItem);
            if (index != -1) {
                double price = prices.get(index);
                double itemTotal = price * qty;

                System.out.printf("%-20s %-5d $%.2f\n", currentItem, qty, itemTotal);
                subtotal += itemTotal;
            }
            printed.add(currentItem);
        }

        double discount = 0;
        if (subtotal >= 10) {
            discount = subtotal * 0.1;
        }
        double total = subtotal - discount;
        System.out.println("------------------------------------");
        System.out.printf("Subtotal:%18s$%.2f\n", "", subtotal);
        if (discount > 0) {
            System.out.printf("Discount (10%%):%13s$%.2f\n", "", discount);
        }else {
            System.out.printf("Discount (0%%):%13s$%.2f\n", "", discount);

        }
        System.out.println("------------------------------------");
        System.out.printf("TOTAL:%21s$%.2f\n", "", total);
        double cash;

        while (true) {
            System.out.print("Cash: $");
            cash = scanner.nextDouble();

            if (cash < total) {
                System.out.println("Not enough cash! Please enter again.");
            } else {
                break;
            }
        }scanner.close();

        double change = cash - total;
        System.out.printf("Change:%20s$%.2f\n", "", change);

        System.out.println("====================================");
        System.out.println("        Thank You For Shopping!");
        System.out.println("          Please Come Again");
        System.out.println("====================================");
    }

    public static List<String> products = new ArrayList<>(List.of(
                "Coca-Cola", "Pepsi", "Mineral Water", "Iced Coffee", "Sandwich",
                "Cheeseburger", "French Fries", "Instant Noodles", "Chocolate Bar",
                "Potato Chips", "Notebook", "Pen", "USB Flash Drive 16GB",
                "Phone Charger", "Earphones", "Girlfriend", "Boyfriend"));

    public static List<Double> prices = new ArrayList<>(List.of(
                0.75, 0.75, 0.50, 1.25, 2.50, 3.50, 1.80, 0.90,
                1.20, 1.50, 2.00, 0.50, 6.00, 5.50, 4.00, 25.00, 25.00));

    public static List<String> id = new ArrayList<>(List.of(
                "P001", "P002", "P003", "P004", "P005",
                "P006", "P007", "P008", "P009", "P010",
                "P011", "P012", "P013", "P014", "P015", "P016", "P017"));

    public static void print_product() {
        System.out.println("\n          Welcome to ABC STORE!!!🎀");
        System.out.println("------------------------------------------------");
        System.out.printf("| %-6s | %-22s | %-6s |\n", "ID", "PRODUCT", "PRICE");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("| %-6s | %-22s | $%-5.2f |\n",
                    id.get(i),
                    products.get(i),
                    prices.get(i));
        }
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        print_product();
        condition();
        

    }
}



