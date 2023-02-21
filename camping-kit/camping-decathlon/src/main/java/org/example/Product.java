package org.example;

public class Product {
    private final String name;
    private final String reference;
    private final String brand;
    private final String category;
    private final long price;
    private final double score;
    private final String size;
    private final String description;

    public Product(String name, String reference, String brand, String category, long price, double score, String size, String description) {
        this.name = name;
        this.reference = reference;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.score = score;
        this.size = size;
        this.description = description;
    }

    @Override
    public String toString() {
        return "{Nombre: " + name + "\n" +
                "Referencia: " + reference + "\n" +
                "Marca: " + brand + "\n" +
                "Talla: " + size + "\n" +
                "Categoria: " + category + "\n" +
                "Puntuacion: " + score + "\n" +
                "Descripcion: " + description + "\n" +
                "Precio: " + price + " }\n";
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public String getBrand() {
        return brand;
    }

    public long getPrice() {
        return price;
    }

    public double getScore() {
        return score;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
