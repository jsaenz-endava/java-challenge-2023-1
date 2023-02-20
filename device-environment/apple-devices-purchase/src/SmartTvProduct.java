public class SmartTvProduct extends Product {
    private Product[] products;

    Warranty defaultWarranty = new Warranty(12,"Manufacturer's warranty");
    Manufacturer apple = new Manufacturer("Apple Inc.","Cupertino, CA");

    public SmartTvProduct() {
        super("", 0, "", "smart tv", 0, new Warranty(12,"Manufacturer's warranty"), new Manufacturer("Made in China","China"));
        products = new Product[1];
        products[0] = new Product("Apple TV 4K", 114.95, "Brings Apple TV+, Apple Music, Apple Fitness+, and Apple Arcade together with all your favorite streaming apps — in our best‑ever picture and audio quality.", "smart tv", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "1. Apple TV 4K - $114.95";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
        products[1] = new Product("Apple TV 4K, first gen", 67.25 , "Brings Apple TV+, Apple Music, Apple Fitness+, and Apple Arcade together with all your favorite streaming apps.", "smart tv", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "2. Apple TV 4K, first gen - $667.25";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
    }

    public String displayProducts() {
        StringBuilder builder = new StringBuilder();
        builder.append("Smart TV products:\n");
        for (Product product : products) {
            builder.append(product.displayProducts()).append("\n");
        }
        return builder.toString();
    }

    public Product getProduct(int choice, int quantity) {
        return products[choice - 1].getProduct(choice, quantity);
    }
}
