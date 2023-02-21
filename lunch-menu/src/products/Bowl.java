package products;

import java.util.ArrayList;

public class Bowl extends Product {
	
	private String size;
	private Base bowlBase;
	private ArrayList<Protein> bowlProteins = new ArrayList<Protein>();
	private final static String BOWLS_MENU = "BowlsMenu.txt";

	public Bowl(int bowlBaseID, int bowlProteinID) {
		this.size = "Pequeño";
		this.bowlBase = new Base(bowlBaseID);
		this.bowlProteins.add(new Protein(bowlProteinID));
		setPrice();
		setName();
	}
	public Bowl(int bowlBaseID, int bowlProtein1ID, int bowlProtein2ID) {
		this.size = "Mediano";
		this.bowlBase = new Base(bowlBaseID);
		this.bowlProteins.add(new Protein(bowlProtein1ID));
		this.bowlProteins.add(new Protein(bowlProtein2ID));
		setPrice();
		setName();
	}
	public Bowl(int bowlBaseID, int bowlProtein1ID, int bowlProtein2ID, int bowlProtein3ID ) {
		this.size = "Grande";
		this.bowlBase = new Base(bowlBaseID);
		this.bowlProteins.add(new Protein(bowlProtein1ID));
		this.bowlProteins.add(new Protein(bowlProtein2ID));
		this.bowlProteins.add(new Protein(bowlProtein3ID));
		setPrice();
		setName();
	}
	
	private void setName() {
		String name = "Bowl " + this.size + " con: " + this.bowlBase.getName();
		for(int i = 0; i < this.bowlProteins.size() - 1; i++) {
			
			if (i == this.bowlProteins.size() - 1) {
				name += " y " + this.bowlProteins.get(i).getName();
	        }
			else {
				name += ", " + this.bowlProteins.get(i).getName();
			}
		}
		super.setName(name);
	}
	
	private void setPrice() {
		int extraPrice = this.bowlBase.getExtraPrice();
		for(Protein bowlProtein : this.bowlProteins ) {
			extraPrice += bowlProtein.getExtraPrice();
		}
		switch (this.size) {
			case "Pequeño":
				super.setPrice(15500 + extraPrice);
				break;
			case "Mediano":
				super.setPrice(20500 + extraPrice);
				break;
			case "Grande":
				super.setPrice(25900 + extraPrice);
				break;
			default:
				super.setPrice(15500 + extraPrice);
				break;	
		}
	}
	
	public String getSize() {
		return size;
	}

	public Base getBowlBase() {
		return bowlBase;
	}

	public ArrayList<Protein> getBowlProteins() {
		return bowlProteins;
	}

	public static void printMenu() {
		Product.printMenu(BOWLS_MENU);
	}

}
