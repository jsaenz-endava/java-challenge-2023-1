package products;

public class Drink extends Product {
	
	private String brand;
	private int volume;
	
	public Drink(int itemID) {
		switch(itemID) {
			case 1:
				this.brand = "Mr. Tea Limón";
				this.volume = 400;
				super.setPrice(5500);
				break;
			case 2:
				this.brand = "Mr. Tea Durazno";
				this.volume = 400;
				super.setPrice(5200);
				break;
			case 3:
				this.brand = "Agua Cristal Con Gas";
				this.volume = 600;
				super.setPrice(4900);
				break;
			case 4:
				this.brand = "Agua Cristal Sin Gas";
				this.volume = 600;
				super.setPrice(4900);
				break;
			case 5:
				this.brand = "Pepsi";
				this.volume = 400;
				super.setPrice(5200);
				break;
			case 6:
				this.brand = "Manzana";
				this.volume = 400;
				super.setPrice(5200);
				break;
			case 7:
				this.brand = "Colombiana";
				this.volume = 400;
				super.setPrice(5200);
				break;
			case 8:
				this.brand = "7up";
				this.volume = 400;
				super.setPrice(5200);
				break;
			case 9:
				this.brand = "Uva";
				this.volume = 400;
				super.setPrice(5200);
				break;
			case 10:
				this.brand = "Hit Mango";
				this.volume = 500;
				super.setPrice(5500);
				break;
			case 11:
				this.brand = "Hit Mora";
				this.volume = 500;
				super.setPrice(5500);
				break;
			default:
				this.brand = "Mr Tea Limón";
				this.volume = 400;
				super.setPrice(5500);
				break;
		}
		setName();
	}
	
	private void setName() {
		super.setName(
				getBrand()
				+ " " + Integer.toString(getVolume())
				+ " ml");
	}
	
	public String getBrand() {
		return brand;
	}

	public int getVolume() {
		return volume;
	}
}
