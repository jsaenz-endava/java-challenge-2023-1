public class TabletProduct extends Product {
    private Product[] products;

    Warranty defaultWarranty = new Warranty(12,"Manufacturer's warranty");
    Manufacturer apple = new Manufacturer("Apple Inc.","Cupertino, CA");

    public TabletProduct() {
        super("", 0, "", "tablet", 0, new Warranty(12,"Manufacturer's warranty"), new Manufacturer("Made in China","China"));
        products = new Product[1];
        products[0] = new Product("iPad Pro 11''", 799, "The ultimate iPad experience with the most advanced technology.", "tablet", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "1. iPad Pro 11'' - $799";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
        products[1] = new Product("iPad Air 10.9''", 599 , "Serious performance in a thin and light design.", "tablet", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "2. iPad Air 10.9'' - $599";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
    }

    public String displayProducts() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tablet products:\n");
        for (Product product : products) {
            builder.append(product.displayProducts()).append("\n");
        }
        return builder.toString();
    }

    public Product getProduct(int choice, int quantity) {
        return products[choice - 1].getProduct(choice, quantity);
    }
}

