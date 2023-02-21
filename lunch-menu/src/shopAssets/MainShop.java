package shopAssets;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import products.Bowl;

public class MainShop {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.setOut(new PrintStream(System.out, true, "UTF-8"));
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
		Bowl myBowl = new Bowl(1,13,13,13);
		System.out.println(myBowl.getName());
		System.out.println(myBowl.getPrice());
	

	}

}
