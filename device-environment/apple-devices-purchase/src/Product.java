abstract class Product {
    private String name;
    private double price;
    private String description;
    private String category;
    private int quantity;

    public Product(String name, double price, String description, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return name + " (" + category + "): $" + price + " x " + quantity + " = $" + price * quantity + " - " + description;
    }

    public abstract String displayProducts();

    public abstract Product getProduct(int choice, int quantity);
}


