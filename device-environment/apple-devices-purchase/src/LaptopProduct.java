class LaptopProduct extends Product {
    private Product[] products;

    Warranty defaultWarranty = new Warranty(12,"Manufacturer's warranty");
    Manufacturer apple = new Manufacturer("Apple Inc.","Cupertino, CA");

    public LaptopProduct() {
        super("", 0, "", "laptop", 0, new Warranty(12,"Manufacturer's warranty"), new Manufacturer("Made in China","China"));

        products = new Product[2];
        products[0] = new Product("MacBook Pro", 1499.99, "Apple's premium laptop with Retina display", "laptop", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "1. MacBook Pro - $1499.99";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
        products[1] = new Product("Dell XPS 13", 1199.99, "A high-end laptop with slim design and powerful specs", "laptop", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "2. Dell XPS 13 - $1199.99";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
    }

    public String displayProducts() {
        StringBuilder builder = new StringBuilder();
        builder.append("Laptop products:\n");
        for (Product product : products) {
            builder.append(product.displayProducts()).append("\n");
        }
        return builder.toString();
    }

    public Product getProduct(int choice, int quantity) {
        return products[choice - 1].getProduct(choice, quantity);
    }
}