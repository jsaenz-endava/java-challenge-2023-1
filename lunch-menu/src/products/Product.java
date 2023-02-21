package products;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Product {
	
	private String name;
	private int price; //in pesos

	
	public String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	protected void setPrice(int price) {
		this.price = price;
	}
	protected static void printMenu(String productMenuPath) {
		try {
		      File textFile = new File(productMenuPath);
		      Scanner reader = new Scanner(textFile);
		      while (reader.hasNextLine()) {
		    	System.out.println(reader.nextLine());
		      }
		      reader.close(); 
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");		      
		    }
	}
	
}
