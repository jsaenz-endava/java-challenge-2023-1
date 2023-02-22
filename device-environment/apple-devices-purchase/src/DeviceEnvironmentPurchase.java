import java.util.Scanner;

public class DeviceEnvironmentPurchase {

    public static void main(String[] args) {

        Cart purchase = purchaseProcess();
        purchase.printCart();
        purchase.displayDetails();

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
            switch (category) {
                case 1 -> {
                    LaptopProduct laptops = new LaptopProduct();
                    cart.getQuantity(laptops);
                }
                case 2 -> {
                    SmartphoneProduct smartphones = new SmartphoneProduct();
                    cart.getQuantity(smartphones);
                }
                case 3 -> {
                    SmartTvProduct tvAccessories = new SmartTvProduct();
                    cart.getQuantity(tvAccessories);
                }
                case 4 -> {
                    TabletProduct tablets = new TabletProduct();
                    cart.getQuantity(tablets);
                }
                case 5 -> {
                    SmartWatchProduct watches = new SmartWatchProduct();
                    cart.getQuantity(watches);
                }
                default -> System.out.println("That is not a valid category.");
            }

            System.out.println("Do you want to add more products?\n 1. Yes\n 2. No");
            stop = scanner.nextInt();

        }
        while (stop != 2);

        return cart;
        }
}
