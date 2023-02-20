package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Store {
    ArrayList<Product> products;
    ShoppingCart shoppingCart = new ShoppingCart(new HashMap<>());

    public void showShop() {
        loadProducts();
        System.out.println("Welcome to our shop [Decathlon Bogota]!");
        showPrincipalMenu();
    }

    private void showPrincipalMenu() {

        System.out.println("\nWhat do you want ? Please select an option using the numbers");
        System.out.println("1. Show our products and buy");
        System.out.println("2. Show your shopping cart");
        System.out.println("3. Exit from our store");

        Scanner input = new Scanner(System.in);
        String option = input.nextLine();

        switch (option) {
            case "1" -> showProducts();
            case "2" -> {
                shoppingCart.showShoppingCart();
                showPrincipalMenu();
            }
            case "3" -> System.out.println("Thanks for visiting, come back soon!");
            default -> {
                System.out.println("Invalid option, please select a valid option!");
                showPrincipalMenu();
            }
        }
    }

    private void loadProducts() {
        FileReader reader;
        ArrayList<Product> products = new ArrayList<>();
        JSONArray data;
        try {
            reader = new FileReader("data/products.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JSONParser parser = new JSONParser();
        try {
            data = (JSONArray) parser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        for (Object o : data) {
            JSONObject product = (JSONObject) o;
            String name = (String) product.get("name");
            String reference = (String) product.get("reference");
            String brand = (String) product.get("brand");
            long price = (long) product.get("price");
            double score = (double) product.get("score");
            String size = (String) product.get("size");
            String description = (String) product.get("description");
            String category = (String) product.get("category");
            products.add(new Product(name, reference, brand, category, price, score, size, description));
        }
        this.products = products;
    }


    private void showProducts() {
        System.out.println("\nThese are our products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.print(i + " : " + products.get(i).toString());
        }
        System.out.println("\nWhat do you want ? Please select an option using the numbers");
        System.out.println("1. Buy a product");
        System.out.println("2. Return to main menu");

        Scanner input = new Scanner(System.in);
        String option = input.nextLine();

        switch (option) {
            case "1" -> buyProduct();
            case "2" -> showPrincipalMenu();
            default -> {
                System.out.println("Invalid option, please select a valid option!");
                showPrincipalMenu();
            }
        }
    }

    private void buyProduct() {
        System.out.println("\nPlease select the item you want to buy (enter item number)");
        Scanner input = new Scanner(System.in);
        int numberItem = input.nextInt();

        Product selectedProduct = this.products.get(numberItem);
        HashMap<String, ShoppingCartProduct> products = this.shoppingCart.getShoppingCartProducts();

        if (!products.containsKey(selectedProduct.getReference())) {
            ShoppingCartProduct cartProduct =
                    new ShoppingCartProduct(selectedProduct.getName(),
                            selectedProduct.getReference(), selectedProduct.getBrand(), selectedProduct.getPrice(),
                            selectedProduct.getScore(), selectedProduct.getSize(),
                            selectedProduct.getDescription(), selectedProduct.getCategory() , 1);
            products.put(selectedProduct.getReference(), cartProduct);
        } else {
            ShoppingCartProduct cartProduct = products.get(selectedProduct.getReference());
            cartProduct.setQuantity(cartProduct.getQuantity() + 1);
        }
        this.shoppingCart.setTotal( this.shoppingCart.getTotal() + selectedProduct.getPrice());

        System.out.println("\nWhat do you want ? Please select an option using the numbers");
        System.out.println("1. Buy another product");
        System.out.println("2. Return to main menu");

        Scanner inputTwo = new Scanner(System.in);
        String option = inputTwo.nextLine();

        switch (option) {
            case "1" -> showProducts();
            case "2" -> showPrincipalMenu();
            default -> {
                System.out.println("Invalid option, please select a valid option!");
                showPrincipalMenu();
            }
        }
    }
}
