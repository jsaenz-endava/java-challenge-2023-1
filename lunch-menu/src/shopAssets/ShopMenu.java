package shopAssets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


import products.Bowl;
import products.Drink;
import products.SushiBites;

public abstract class ShopMenu {
	
	private final static String BOWLS_MENU = "BowlsMenu.txt";
	private final static String SUSHI_MENU = "SushiMenu.txt";
	private final static String DRINKS_MENU = "DrinksMenu.txt";
	public final static String MAIN = "Main";
	public final static String BOWLS = "Bowls";
    public final static String SUSHI =  "Sushi";
    public final static String DRINKS = "Drinks";
    public final static String CART = "Cart";
    public final static String PAYMENT = "Payment";
	
	public static User loginMenu() throws IOException {
		String name;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Bienvenido");
	    System.out.println("Por favor ingrsa tu nombre:");
	    name = reader.readLine();
	    System.out.println("Ingresa tu número de celular:");
	    String cellPhoneNumber = "";
		boolean correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^3[0-9]{9}$")) {
				cellPhoneNumber = option;
			}
			else {
				System.out.println("Numero inválido\n\n");
				separator();
				correctAnswer = false;
			}
		}while(!correctAnswer);
	    System.out.println("Ingresa tu email:");
	    String email = "";
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^(.+)@(.+)$")) {
				email = option;
			}
			else {
				System.out.println("Email inválido");
				separator();
				correctAnswer = false;
			}
		}while(!correctAnswer);
	    separator();
	    return new User(name, cellPhoneNumber, email);
	}
	
	public static String mainMenu() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("-----------------------------｡◕‿‿◕｡ 🗲---------------------");
		System.out.println();
		System.out.println("Este es el menú principal, por favor ingresa una opción");
		System.out.println("1. Bowls");
		System.out.println("2. Sushi");
		System.out.println("3. Drinks");
		System.out.println("4. Ver Carrito");
		System.out.println("----------------------------------------------------------");
		System.out.println();
		boolean correctAnswer = true;
		String nextSection = MAIN;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			switch(option) {
				case "1":
					separator();
					nextSection = BOWLS;
					break;
				case "2":
					separator();
					nextSection = SUSHI;
					break;
				case "3":
					separator();
					nextSection = DRINKS;
					break;
				case "4":
					separator();
					nextSection = CART;
					break;
				default:
					System.out.println("Opción no válida\n\n");
					correctAnswer = false;
					break;
			}
		}while(!correctAnswer);
		return nextSection;
	}
	
	public static String bowlsMenu(ShoppingCart myCart) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		printMenu(BOWLS_MENU);
		System.out.println("Ingresa un tamaño ó \"0\" para volver al menú principal");
		int size = 0;
		boolean correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[0-3]$")) {
				if(option.equals("0")) {
					return MAIN;
				}
				size = Integer.parseInt(option);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);	
		separator();
		System.out.println("Ingresa tu base");
		int base = 0;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[1-4]$")) {
				base = Integer.parseInt(option);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		System.out.println("Ingresa tus Proteínas");
		int[] proteins = new int[size];
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^([1-9]\s|1[0-5]\s){"+Integer.toString(size-1)+"}([1-9]|1[0-5]){1}")) {
				String [] chainOption = option.split(" ");
				for(int i = 0; i < size; i++) proteins[i] = Integer.parseInt(chainOption[i]);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		System.out.println("¿Cuántos de estos bowls deseas?");
		int copies = 1;
		correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[1-9]$")) {
	
				copies = Integer.parseInt(option);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);	
		separator();
		if(size == 1) myCart.addProduct(new Bowl(base,proteins[0]),copies);
		if(size == 2) myCart.addProduct(new Bowl(base,proteins[0],proteins[1]),copies);
		if(size == 3) myCart.addProduct(new Bowl(base,proteins[0],proteins[1],proteins[2]),copies);
		System.out.println("Producto agregado al carrito. Ingresa \"1\" para continuar o \"0\" para volver al menú principal");
		String nextSection = MAIN;
		correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[0-1]$")) {
				if(option.equals("1")) {
					nextSection = BOWLS;
				}	
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		return nextSection;
	}
	
	public static String sushiMenu(ShoppingCart myCart) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		printMenu(SUSHI_MENU);
		System.out.println("Ingresa el tipo de sushi que deseas ó \"0\" para volver al menú principal");
		int sushiType = 1;
		boolean correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[0-5]$")) {
				if(option.equals("0")) {
					return MAIN;
				}
				sushiType = Integer.parseInt(option);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);	
		separator();
		System.out.println("¿Cuántos rollitos deseas? ( x5 : \"1\" , x10 : \"2\" )");
		int numberOfBites = 5;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[1-2]$")) {
				if(option.equals("2")) {
					numberOfBites = 10;
				}
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);	
		separator();
		System.out.println("¿Deseas palillos? ( Si : \"1\" , No : \"2\" )");
		boolean withChopsticks = false;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[1-2]$")) {
				if(option.equals("1")) {
					withChopsticks = true;
				}
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);	
		separator();
		System.out.println("¿Cuántas de estas porciones de sushi deseas?");
		int copies = 1;
		correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[1-9]$")) {
	
				copies = Integer.parseInt(option);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		myCart.addProduct(new SushiBites(sushiType,numberOfBites,withChopsticks),copies);
		System.out.println("Producto agregado al carrito. Ingresa \"1\" para continuar o \"0\" para volver al menú principal");
		String nextSection = MAIN;
		correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[0-1]$")) {
				if(option.equals("1")) {
					nextSection = SUSHI;
				}	
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		return nextSection;
	}
	
	public static String drinksMenu(ShoppingCart myCart) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		printMenu(DRINKS_MENU);
		System.out.println("Ingresa la bebida que deseas ó \"0\" para volver al menú principal");
		int drink = 1;
		boolean correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^([0-9]|1[0-1])$")) {
				if(option.equals("0")) {
					return MAIN;
				}
				drink = Integer.parseInt(option);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);	
		separator();
		System.out.println("¿Cuántas de estas bebidas deseas?");
		int copies = 1;
		correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[1-9]$")) {
	
				copies = Integer.parseInt(option);
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		myCart.addProduct(new Drink(drink),copies);
		System.out.println("Producto agregado al carrito. Ingresa \"1\" para continuar o \"0\" para volver al menú principal");
		String nextSection = MAIN;
		correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[0-1]$")) {
				if(option.equals("1")) {
					nextSection = DRINKS;
				}	
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		return nextSection;
		
	}
	
	public static String cartMenu(ShoppingCart myCart) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		myCart.printTicket();
		System.out.println("\n\nIngresa \"1\" para pagar, \"2\" para descartar un producto ó \"0\" para volver al menú principal");
		boolean correctAnswer = true;
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^[0-2]$")) {
				if(option.equals("0")) {
					return MAIN;
				}
				if(option.equals("1")) {
					separator();
					return PAYMENT;
				}
				if(myCart.getListOfProducts().size()<1) {
					System.out.println("No hay productos en el carrito");
					separator();
					return CART;
				}
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);
		separator();
		System.out.println("Ingresa el ID del producto que deseas descartar");
		do {
			correctAnswer = true;
			String option = reader.readLine();
			if(option.matches("^\\d+$") 
			   && Integer.parseInt(option) <= myCart.getListOfProducts().size()) {
				myCart.removeProduct(Integer.parseInt(option));
			}
			else {
				System.out.println("Opción no válida\n\n");
				correctAnswer = false;
			}
		}while(!correctAnswer);	
		separator();
		System.out.println("Producto descartado");
		separator();
		return CART;
	}
	
	public static void separator() {
		System.out.print("\n\n");
		for (int i=0; i<60; i++){
		    System.out.print(" -");
		}
		System.out.print("\n\n");
	}
	
	private static void printMenu(String productMenuPath) {
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
