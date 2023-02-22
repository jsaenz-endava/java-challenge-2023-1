package products;

import java.util.ArrayList;

public class Bowl extends Product {
	
	private String size;
	private Base bowlBase;
	private ArrayList<Protein> bowlProteins = new ArrayList<Protein>();

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
		String name = "Bowl " + getSize() + " con: " + getBowlBase().getName();
		for(int i = 0; i <= getBowlProteins().size() - 1; i++) {
			
			if (i == getBowlProteins().size() - 1) {
				name += " y " + getBowlProteins().get(i).getName();
	        }
			else {
				name += ", " + getBowlProteins().get(i).getName();
			}
		}
		super.setName(name);
	}
	
	private void setPrice() {
		int extraPrice = getBowlBase().getExtraPrice();
		for(Protein bowlProtein : getBowlProteins() ) {
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
}
