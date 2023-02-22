package products;

public class Base extends Tops {
	
	public Base(int itemID) {
		switch (itemID){
			case 1:
				super.setName("Arróz");
				super.setExtraPrice(0);
				break;
			case 2:
				super.setName("Pasta");
				super.setExtraPrice(0);
				break;
			case 3:
				super.setName("Chop Suey");
				super.setExtraPrice(0);
				break;
			case 4:
				super.setName("Arróz Shangai");
				super.setExtraPrice(1500);
				break;	
			default:
				super.setName("Arróz");
				super.setExtraPrice(0);
				break;
		}		
	}
	
}
