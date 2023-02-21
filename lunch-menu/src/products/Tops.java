package products;

public abstract class Tops {
	
	private String name;
	private int extraPrice;
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getExtraPrice() {
		return extraPrice;
	}
	protected void setExtraPrice(int extraPrice) {
		this.extraPrice = extraPrice;
	}
}
