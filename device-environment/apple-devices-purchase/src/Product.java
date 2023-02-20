public class Product {
    // Esto podría ser una interfaz
//    public interface ProductCategory {
//        String getName();
//        String getCategory();
//        double getPrice();
//        String getDescription();
//        Product getProduct(int choice, int quantity);
//    }
    private String name;
    private double price;
    private String description;
    private String category;
    private int quantity;
    private Warranty warranty; // composition
    private Manufacturer manufacturer; // composition

    public Product(String name, double price, String description, String category, int quantity, Warranty warranty, Manufacturer manufacturer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.warranty = warranty;  // composition
        this.manufacturer = manufacturer; // composition
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String toString() {
        return name + " (" + category + "): $" + price + " x " + quantity + " = $" + price * quantity + " - " + description;
    }

    public String displayProducts(){
        return "This product is not available";
    };

    public Product getProduct(int choice, int quantity){
        return new Product(this.name, this.price, this.description, this.category, quantity, this.warranty, this.manufacturer);
    }
}


