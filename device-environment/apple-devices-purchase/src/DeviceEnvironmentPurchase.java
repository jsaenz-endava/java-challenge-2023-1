import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeviceEnvironmentPurchase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> cart = new ArrayList<>();

        // Get product category
        System.out.println("Choose a product category:");
        System.out.println("1. Laptop");
        System.out.println("2. Smartphone");
        System.out.println("3. TV accessories");
        int category = scanner.nextInt();

        // Create product based on category and get user choice
        if (category == 1) {
            LaptopProduct laptop = new LaptopProduct();
            System.out.println(laptop.displayProducts());
            int laptopChoice = scanner.nextInt();
            if (laptopChoice == 1) {
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                Product product = laptop.getProduct(1, quantity);
                cart.add(product);
            } else if (laptopChoice == 2) {
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                Product product = laptop.getProduct(2, quantity);
                cart.add(product);
            }
        } else if (category == 2) {
            SmartphoneProduct smartphone = new SmartphoneProduct();
            System.out.println(smartphone.displayProducts());
            int smartphoneChoice = scanner.nextInt();
            if (smartphoneChoice == 1) {
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                Product product = smartphone.getProduct(1, quantity);
                cart.add(product);
            } else if (smartphoneChoice == 2) {
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                Product product = smartphone.getProduct(2, quantity);
                cart.add(product);
            }
        } else if (category == 3) {
            SmartTvProduct tvAccessory = new SmartTvProduct();
            System.out.println(tvAccessory.displayProducts());
            int tvAccessoryChoice = scanner.nextInt();
            if (tvAccessoryChoice == 1) {
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                Product product = tvAccessory.getProduct(1, quantity);
                cart.add(product);
            }
            else if (tvAccessoryChoice == 2) {
                System.out.println("Enter the quantity:");
                int quantity = scanner.nextInt();
                Product product = tvAccessory.getProduct(2, quantity);
                cart.add(product);
            }

            // Display cart contents
            System.out.println("Your cart:");
            for (Product product : cart) {
                System.out.println(product.toString());
            }
        }
    }
}