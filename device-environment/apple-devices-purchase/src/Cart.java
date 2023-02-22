import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private List<Product> items;

    public Cart() {
        this.items = new ArrayList<Product>();
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public void printCart() {
        if (items.size() == 0) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Your cart contains the following items:");
        double total = 0.0;
        for (int i = 0; i < items.size(); i++) {
            Product item = items.get(i);
            double itemTotal = item.getProduct( 1 ,item.getQuantity()).getPrice() * item.getQuantity();
            total += itemTotal;
            System.out.printf("%d. %s (x%d) - $%.2f\n", i+1, item.getProduct( 1 ,item.getQuantity()).getName(),
                    item.getQuantity(), itemTotal);
        }
        System.out.printf("Total: $%.2f\n", total);
    }

    public int getSize() {
        return items.size();
    }

    public Product getItem(int index) {
        return items.get(index);
    }

    public void getQuantity(Product items){
        Scanner scanner = new Scanner(System.in);
        System.out.println(items.displayProducts());
        int itemChoice = scanner.nextInt();
        if (itemChoice == 1){
            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();
            Product product = items.getProduct(1, quantity);
            this.addItem(product);
        } else if (itemChoice == 2) {
            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();
            Product product = items.getProduct(2, quantity);
            this.addItem(product);
        }
    }

    public void displayDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to know more about the chosen products?\n 1. Yes\n 2. No");
        int information = scanner.nextInt();

        if(information==1){
            System.out.println("What information would you like to know?\n 1. Description \n 2. Warranty \n 3. Manufacturer");
            information = scanner.nextInt();
            switch (information){
                case 1->{
                    for (int i=0; i<this.getSize(); i++){
                        System.out.println(this.getItem(i).getName()+": "+this.getItem(i).getDescription());
                    }
                }
                case 2->{
                    for (int i=0; i<this.getSize(); i++){
                        System.out.println(this.getItem(i).getName()+": "+this.getItem(i).getWarranty().getLength()+" months");
                    }
                }
                case 3->{
                    for (int i=0; i<this.getSize(); i++){
                        System.out.println(this.getItem(i).getName()+": "+this.getItem(i).getManufacturer().getName());
                    }
                }
                default -> System.out.println("Information not available.");
            }
        } else if (information==2) {
            this.printCart();
        } else {
            System.out.println("Not a valid option.");
        }

    }
}
