package shopAssets;

import java.io.IOException;
import java.io.PrintStream;

public class MainShop {
	
	public final static String MAIN = "Main";
	public final static String BOWLS = "Bowls";
	public final static String PAYMENT = "Payment";
    public final static String SUSHI =  "Sushi";
	
	public static void main(String[] args) throws IOException {
		System.setOut(new PrintStream(System.out, true, "UTF-8"));
		boolean activeSession = true;
		User currentUser = ShopMenu.loginMenu();
		String nextSection = ShopMenu.MAIN;
		ShoppingCart currentShoppingCart = new ShoppingCart(currentUser);
		while(activeSession) {
			switch (nextSection) {
				case ShopMenu.MAIN:
					nextSection = ShopMenu.mainMenu();
					break;
				case ShopMenu.BOWLS:
					nextSection = ShopMenu.bowlsMenu(currentShoppingCart);
					break;
				case ShopMenu.SUSHI:
					nextSection = ShopMenu.sushiMenu(currentShoppingCart);
					break;	
				case ShopMenu.DRINKS:
					nextSection = ShopMenu.drinksMenu(currentShoppingCart);
					break;	
				case ShopMenu.CART:
					nextSection = ShopMenu.cartMenu(currentShoppingCart);
					break;
				case "Payment":
					activeSession = false;
					System.out.print("Has pagado un total de: ");
					System.out.println(String.format("%,d",currentShoppingCart.getTotal()));
					break;
				default:
					ShopMenu.mainMenu();
					break;
			}
		}	
	}
}
