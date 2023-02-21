import java.util.Scanner;

public class DeviceEnvironmentPurchase {

    public static void main(String[] args) {

        Cart purchase = purchaseProcess();
        purchase.printCart();

    }

    public static Cart purchaseProcess(){
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        String options = "Choose a product category:\n 1. Laptop\n 2. Smartphone\n 3. TV accessories\n 4. Tablet\n 5. Smart watch";
        int stop;

        do {
            System.out.println(options);
            int category = scanner.nextInt();

            // Create product based on category and get user choice
            switch(category) {
                case 1:
                    LaptopProduct laptop = new LaptopProduct();
                    System.out.println(laptop.displayProducts());
                    int laptopChoice = scanner.nextInt();
                    if (laptopChoice == 1) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = laptop.getProduct(1, quantity);
                        cart.addItem(product);
                    } else if (laptopChoice == 2) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = laptop.getProduct(2, quantity);
                        cart.addItem(product);
                    }
                    break;
                case 2:
                    SmartphoneProduct smartphone = new SmartphoneProduct();
                    System.out.println(smartphone.displayProducts());
                    int smartphoneChoice = scanner.nextInt();
                    if (smartphoneChoice == 1) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = smartphone.getProduct(1, quantity);
                        cart.addItem(product);
                    } else if (smartphoneChoice == 2) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = smartphone.getProduct(2, quantity);
                        cart.addItem(product);
                    }
                    break;
                case 3:
                    SmartTvProduct tvAccessory = new SmartTvProduct();
                    System.out.println(tvAccessory.displayProducts());
                    int tvAccessoryChoice = scanner.nextInt();
                    if (tvAccessoryChoice == 1) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = tvAccessory.getProduct(1, quantity);
                        cart.addItem(product);
                    }
                    else if (tvAccessoryChoice == 2) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = tvAccessory.getProduct(2, quantity);
                        cart.addItem(product);
                    }
                    break;
                case 4:
                    TabletProduct tablet = new TabletProduct();
                    System.out.println(tablet.displayProducts());
                    int tabletChoice = scanner.nextInt();
                    if (tabletChoice == 1) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = tablet.getProduct(1, quantity);
                        cart.addItem(product);
                    }
                    else if (tabletChoice == 2) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = tablet.getProduct(2, quantity);
                        cart.addItem(product);
                    }
                    break;
                case 5:
                    SmartWatchProduct watch = new SmartWatchProduct();
                    System.out.println(watch.displayProducts());
                    int watchChoice = scanner.nextInt();
                    if (watchChoice == 1) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = watch.getProduct(1, quantity);
                        cart.addItem(product);
                    }
                    else if (watchChoice == 2) {
                        System.out.println("Enter the quantity:");
                        int quantity = scanner.nextInt();
                        Product product = watch.getProduct(2, quantity);
                        cart.addItem(product);
                    }
                    break;
                default:
                    System.out.println("That is not a valid category.");
            }

            System.out.println("Do you want to add more products?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            stop = scanner.nextInt();

        }
        while (stop != 2);

        return cart;
        }
    }
