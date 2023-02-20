class SmartphoneProduct extends Product {
    private Product[] products;

    public SmartphoneProduct() {
        super("", 0, "", "smartphone", 0);
        products = new Product[2];
        products[0] = new Product("iPhone 13", 799.99, "The latest iPhone with A15 Bionic chip and Ceramic Shield", "smartphone", 0) {
            @Override
            public String displayProducts() {
                return "1. iPhone 13 - $799.99";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity);
            }
        };
        products[1] = new Product("Samsung Galaxy S21", 699.99, "A powerful Android phone with great camera and 120Hz display", "smartphone", 0) {
            @Override
            public String displayProducts() {
                return "2. Samsung Galaxy S21 - $699.99";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity);
            }
        };
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
