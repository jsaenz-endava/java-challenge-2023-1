package org.example;

public class ShoppingCartProduct extends Product{
    private int quantity;
    public ShoppingCartProduct(String name, String reference, String brand, long price, double score, String size, String description, String category, int quantity) {
        super(name, reference, brand, category, price, score, size, description);
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{Nombre: " + super.getName() + "\n" +
                "Referencia: " + super.getReference() + "\n" +
                "Marca: " + super.getBrand() + "\n" +
                "Categoria: " + super.getCategory() + "\n" +
                "Talla: " + super.getSize() + "\n" +
                "Puntuacion: " + super.getScore() + "\n" +
                "Descripcion: " + super.getDescription() + "\n" +
                "Precio: " + super.getPrice() + "\n" +
                "Cantidad : " + getQuantity() + " }\n";

    }
}
