package products;

public class Protein extends Tops {
	public Protein(int itemID) {
		switch (itemID){
			case 1:
				super.setName("Pollo Naranja");
				super.setExtraPrice(0);
				break;
			case 2:
				super.setName("Pollo Bourbon");
				super.setExtraPrice(0);
				break;
			case 3:
				super.setName("Rés Teriyaki");
				super.setExtraPrice(0);
				break;
			case 4:
				super.setName("Cerdo BBQ");
				super.setExtraPrice(0);
				break;	
			case 5:
				super.setName("Lumpiá");
				super.setExtraPrice(0);
				break;
			case 6:
				super.setName("Papas Fritas");
				super.setExtraPrice(0);
				break;	
			case 7:
				super.setName("Chop Suey");
				super.setExtraPrice(0);
				break;
			case 8:
				super.setName("Arróz");
				super.setExtraPrice(0);
				break;
			case 9:
				super.setName("Pasta");
				super.setExtraPrice(0);
				break;
			case 10:
				super.setName("Cerdo Agridulce");
				super.setExtraPrice(0);
				break;
			case 11:
				super.setName("Arróz Shangai");
				super.setExtraPrice(0);
				break;
			case 12:
				super.setName("Costillas BBQ");
				super.setExtraPrice(1500);
				break;
			case 13:
				super.setName("Kungpao Shrimp");
				super.setExtraPrice(2000);
				break;
			case 14:
				super.setName("Camarón Dinamita");
				super.setExtraPrice(1500);
				break;	
			default:
				super.setName("Arróz");
				super.setExtraPrice(0);
				break;
		}		
	}
}