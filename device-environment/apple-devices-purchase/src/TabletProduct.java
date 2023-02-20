public class TabletProduct extends Product {
    private Product[] products;

    public TabletProduct() {
        super("", 0, "", "tablet", 0);
        products = new Product[1];
        products[0] = new Product("Apple TV 4K", 114.95, "Brings Apple TV+, Apple Music, Apple Fitness+, and Apple Arcade together with all your favorite streaming apps — in our best‑ever picture and audio quality.", "tablet", 0) {
            @Override
            public String displayProducts() {
                return "1. Apple TV 4K - $114.95";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity);
            }
        };
//        products[1] = new Product("Samsung Galaxy S21", 699.99, "A powerful Android phone with great camera and 120Hz display", "smartphone", 0) {
//            @Override
//            public String displayProducts() {
//                return "2. Samsung Galaxy S21 - $699.99";
//            }
//
//            @Override
//            public Product getProduct(int choice, int quantity) {
//                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity);
//            }
//        };
    }

    public String displayProducts() {
        StringBuilder builder = new StringBuilder();
        builder.append("Smartphone products:\n");
        for (Product product : products) {
            builder.append(product.displayProducts()).append("\n");
        }
        return builder.toString();
    }

    public Product getProduct(int choice, int quantity) {
        return products[choice - 1].getProduct(choice, quantity);
    }
}

