
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double subtotal = 0;
        double discount = 0;
        double finalTotal;
        double payment;
        double change;

        int choice;
        int quantity;
        int itemsPurchased = 0;

        while (true) {

            System.out.println("\n===== SIMPLE STORE =====");
            System.out.println("1. Mouse - $20");
            System.out.println("2. Keyboard - $40");
            System.out.println("3. Headphones - $50");
            System.out.println("4. Laptop Stand - $30");
            System.out.println("5. Checkout");
            System.out.print("Choose a product: ");

            choice = input.nextInt();

            if (choice == 5) {
                break;
            }

            double price = 0;
            String productName = "";

            if (choice == 1) {
                productName = "Mouse";
                price = 20;
            } else if (choice == 2) {
                productName = "Keyboard";
                price = 40;
            } else if (choice == 3) {
                productName = "Headphones";
                price = 50;
            } else if (choice == 4) {
                productName = "Laptop Stand";
                price = 30;
            } else {
                System.out.println("Invalid option.");
                System.out.println(
                        "Please choose a number from 1 to 5."
                );
                continue;
            }

            System.out.println("You selected: " + productName);
            System.out.println("Price: $" + price);
            System.out.print("Enter quantity: ");

            quantity = input.nextInt();

            if (quantity <= 0) {
                System.out.println("Invalid quantity.");
                System.out.println(
                        "Quantity must be greater than 0."
                );
                continue;
            }

            double itemCost = price * quantity;

            System.out.println(
                    quantity + " x $" + price + " = $" + itemCost
            );

            subtotal = subtotal + itemCost;
            itemsPurchased = itemsPurchased + quantity;

            System.out.println("Added to cart!");
            System.out.println("Current total: $" + subtotal);
        }

        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Items purchased: " + itemsPurchased);
        System.out.println("Subtotal: $" + subtotal);

        if (subtotal >= 100) {
            discount = subtotal * 0.10;
            System.out.println("You received a 10% discount!");
        } else {
            discount = 0;
        }

        finalTotal = subtotal - discount;

        System.out.println("Discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);

        payment = 0;

        while (payment < finalTotal) {

            System.out.print("Enter payment amount: $");
            payment = input.nextDouble();

            if (payment < finalTotal) {
                System.out.println("Insufficient payment.");
                System.out.println(
                        "You still need to pay: $"
                                + (finalTotal - payment)
                );
            }
        }

        change = payment - finalTotal;

        System.out.println("Payment successful!");

        System.out.println("\n========================");
        System.out.println("       SIMPLE STORE");
        System.out.println("========================");
        System.out.println("Items purchased: " + itemsPurchased);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);
        System.out.println("Payment: $" + payment);
        System.out.println("Change: $" + change);
        System.out.println("========================");
        System.out.println("Thank you for shopping!");
        System.out.println("========================");

        input.close();
    }
}
