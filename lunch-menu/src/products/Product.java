package products;

public abstract class Product {
	
	private String name;
	private int price; //in pesos

	
	public String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	protected void setPrice(int price) {
		this.price = price;
	}
}
