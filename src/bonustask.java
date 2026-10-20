
import java.util.Scanner;

public class bonustask {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        double mousePrice = 20;
        double keyboardPrice = 40;
        double headphonesPrice = 50;
        double standPrice = 30;

        double subtotal = 0;
        double discount = 0;
        double finalTotal;
        double payment;
        double change;
        double itemCost;
        double itemDiscount;

        int choice;
        int quantity;
        String productName = "";
        double price = 0;

        int mouseCount = 0;
        int keyboardCount = 0;
        int headphonesCount = 0;
        int standCount = 0;

        int itemsPurchased = 0;

        double quantityDiscountTotal = 0;

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

            if (choice == 1) {
                productName = "Mouse";
                price = mousePrice;
            } else if (choice == 2) {
                productName = "Keyboard";
                price = keyboardPrice;
            } else if (choice == 3) {
                productName = "Headphones";
                price = headphonesPrice;
            } else if (choice == 4) {
                productName = "Laptop Stand";
                price = standPrice;
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

            itemCost = price * quantity;
            
            itemDiscount = 0;

            if (quantity >= 5) {
                itemDiscount = itemCost * 0.05;
                System.out.println(
                        "Large quantity discount: $" + itemDiscount
                );
            }

            subtotal = subtotal + itemCost - itemDiscount;

            quantityDiscountTotal =
                    quantityDiscountTotal + itemDiscount;

            System.out.println(
                    quantity + " x $" + price + " = $" + itemCost
            );
            System.out.println("Added to cart!");
            System.out.println("Current total: $" + subtotal);

            if (choice == 1) {
                mouseCount = mouseCount + quantity;
            } else if (choice == 2) {
                keyboardCount = keyboardCount + quantity;
            } else if (choice == 3) {
                headphonesCount = headphonesCount + quantity;
            } else if (choice == 4) {
                standCount = standCount + quantity;
            }
            
            itemsPurchased = itemsPurchased + quantity;
        }

        // Checkout
        System.out.println("\n===== CHECKOUT =====");

        System.out.println("\n===== ITEMS PURCHASED =====");
        System.out.println("Mouse: " + mouseCount);
        System.out.println("Keyboard: " + keyboardCount);
        System.out.println("Headphones: " + headphonesCount);
        System.out.println("Laptop Stand: " + standCount);

        System.out.println("\nItems purchased: " + itemsPurchased);
        System.out.println("Subtotal after quantity discounts: $" + subtotal);

        if (subtotal >= 200) {
            discount = subtotal * 0.15;
        } else if (subtotal >= 100) {
            discount = subtotal * 0.10;
        } else {
            discount = 0;
        }

        finalTotal = subtotal - discount;

        System.out.println("Quantity discounts: $" + quantityDiscountTotal);
        System.out.println("Checkout discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);

        String mostPurchasedProduct = "Mouse";
        int highestQuantity = mouseCount;

        if (keyboardCount > highestQuantity) {
            highestQuantity = keyboardCount;
            mostPurchasedProduct = "Keyboard";
        }

        if (headphonesCount > highestQuantity) {
            highestQuantity = headphonesCount;
            mostPurchasedProduct = "Headphones";
        }

        if (standCount > highestQuantity) {
            highestQuantity = standCount;
            mostPurchasedProduct = "Laptop Stand";
        }

        System.out.println("\n===== MOST PURCHASED PRODUCT =====");
        System.out.println("Most purchased product: " + mostPurchasedProduct);
        System.out.println("Quantity: " + highestQuantity);

        // Bonus 5: Reward customers who purchase 10 or more items
        if (itemsPurchased >= 10) {
            System.out.println(
                    "You earned a $10 coupon for your next visit!"
            );
        }

        // Payment: Continue until enough money is entered
        payment = 0;

        while (payment < finalTotal) {

            System.out.print("Enter payment amount: $");
            payment = input.nextDouble();

            if (payment < finalTotal) {
                System.out.println("Insufficient payment.");
                System.out.println(
                        "You still need to pay: $" + (finalTotal - payment)
                );
            }
        }

        change = payment - finalTotal;

        System.out.println("Payment successful!");

        System.out.println("\n========================");
        System.out.println("       SIMPLE STORE");
        System.out.println("========================");
        System.out.println("Items purchased: " + itemsPurchased);
        System.out.println("Mouse: " + mouseCount);
        System.out.println("Keyboard: " + keyboardCount);
        System.out.println("Headphones: " + headphonesCount);
        System.out.println("Laptop Stand: " + standCount);
        System.out.println("Subtotal after quantity discounts: $" + subtotal);
        System.out.println("Quantity discounts: $" + quantityDiscountTotal);
        System.out.println("Checkout discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);
        System.out.println("Payment: $" + payment);
        System.out.println("Change: $" + change);
        System.out.println("========================");
        System.out.println("Thank you for shopping!");
        System.out.println("========================");

        input.close();
    }
}
