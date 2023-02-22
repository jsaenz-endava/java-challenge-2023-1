package shopAssets;

import java.util.ArrayList;


import products.Product;

public class ShoppingCart {
	
	private User currentUser;
	private ArrayList<Product> listOfProducts = new ArrayList<>();
	private int total;
	
	public ShoppingCart(User currentUser) {
		this.currentUser = currentUser;
		this.total = 0;
	}
	
	public void addProduct(Product someProduct, int copies) {
		for (int i = 0; i < copies; i++) {
			listOfProducts.add(someProduct);
		}
		updateTotal();
	}
	
	public Product getProduct(int productIdx) {
		return listOfProducts.get(productIdx);
	}
	
	public ArrayList<Product> getListOfProducts() {
		return listOfProducts;
	}
	
	public void removeProduct(int productIdx) {
		listOfProducts.remove(productIdx-1);
		updateTotal();
	}
	
	public User getUser() {
		return currentUser;
	}
	
	public int getTotal() {
		return total;
	}
	
	private void updateTotal() {
		this.total = 0;
		for(Product currentProduct: this.listOfProducts) this.total += currentProduct.getPrice();
	}
	
	public void printTicket() {
		System.out.println("Nombre del comprador:\t" + getUser().getName());
		System.out.println("Celular:\t\t" + getUser().getCellphoneNumber());
		System.out.println("Email:\t\t\t" + getUser().getEmail() + "\n");
		System.out.println("-----------------------------------------------------------------------------------------------");
		System.out.println("ID\t\t\t\t\tProducto\t\t\t\t\tPrecio");
		System.out.println("_______________________________________________________________________________________________");
		for(int i = 0; i < this.listOfProducts.size(); i++) {
			System.out.print(i+1);
			System.out.format("%-70s", "\t" + this.listOfProducts.get(i).getName());
			System.out.println("\t\t$" +  String.format("%,d",this.listOfProducts.get(i).getPrice()));
		}
		System.out.println("-----------------------------------------------------------------------------------------------\n");
		System.out.format("%76s", "Total:\t$");
		System.out.println(String.format("%,d",getTotal()));
		
	}
}
