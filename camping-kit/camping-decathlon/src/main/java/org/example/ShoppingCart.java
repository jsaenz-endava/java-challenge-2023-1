package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public void deleteCartItems(){
        System.out.println("\nPlease enter item's reference (showed before) :\n");
        Scanner input = new Scanner(System.in);
        String reference = input.nextLine();

        if(!this.shoppingCartProducts.containsKey(reference)){
            System.out.println("Item's reference entered doesn't exist");
        }else{
            ShoppingCartProduct product = this.shoppingCartProducts.get(reference);
            this.total -= product.getPrice();
            if( product.getQuantity() > 1 ){
                product.setQuantity(product.getQuantity() - 1);
                System.out.println("An item of this product was deleted from the shopping cart!");
            }
            else{
                shoppingCartProducts.remove(reference);
                System.out.println("This product was successfully deleted from the shopping cart!");
            }
        }
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
