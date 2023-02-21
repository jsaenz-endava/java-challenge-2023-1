import java.util.ArrayList;
import java.util.List;

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
            double itemTotal = item.getProduct( 1 ,item.getQuantity()).getPrice() * item.getQuantity(); //item.getProduct().getPrice() * item.getQuantity()
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
}
