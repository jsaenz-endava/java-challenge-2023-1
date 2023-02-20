package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private HashMap<String, ShoppingCartProduct> shoppingCartProducts;
    private double total = 0;

    public ShoppingCart(HashMap<String, ShoppingCartProduct> shoppingCartProducts) {
        this.shoppingCartProducts = shoppingCartProducts;
    }

    public void showShoppingCart(){
        System.out.println("\nYou have the following items in the cart:\n");
        for(Map.Entry<String, ShoppingCartProduct> products : shoppingCartProducts.entrySet()){
            System.out.println(products.getValue());
        }
        System.out.println("Total: "+ this.total);
    }

    public HashMap<String, ShoppingCartProduct> getShoppingCartProducts() {
        return shoppingCartProducts;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
