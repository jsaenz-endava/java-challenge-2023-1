public class SmartWatchProduct extends Product {
    private Product[] products;

    Warranty defaultWarranty = new Warranty(12,"Manufacturer's warranty");
    Manufacturer apple = new Manufacturer("Apple Inc.","Cupertino, CA");

    public SmartWatchProduct() {
        super("", 0, "", "smartwatch", 0, new Warranty(12,"Manufacturer's warranty"), new Manufacturer("Made in China","China"));
        products = new Product[2];
        products[0] = new Product("Apple Watch SE", 249, "Feature packed, and now it’s a better value than ever.", "smartwatch", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "1. Apple Watch SE - $249";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
        products[1] = new Product("Apple Watch Series 8", 399, "Your essential companion is now even more powerful.", "smartwatch", 0, defaultWarranty, apple) {
            @Override
            public String displayProducts() {
                return "2. Apple Watch Series 8 - $399";
            }

            @Override
            public Product getProduct(int choice, int quantity) {
                return new Product(this.getName(), this.getPrice(), this.getDescription(), this.getCategory(), quantity, this.getWarranty(), this.getManufacturer());
            }
        };
    }

    public String displayProducts() {
        StringBuilder builder = new StringBuilder();
        builder.append("Smartwatch products:\n");
        for (Product product : products) {
            builder.append(product.displayProducts()).append("\n");
        }
        return builder.toString();
    }

    public Product getProduct(int choice, int quantity) {
        return products[choice - 1].getProduct(choice, quantity);
    }
}


