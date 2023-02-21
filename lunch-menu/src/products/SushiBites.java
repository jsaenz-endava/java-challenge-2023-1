package products;

public class SushiBites extends Product {
	
	private String sushiType;
	private int numberOfBites;
	private boolean withChopsticks;
	private final static String SUSHI_MENU = "SushiMenu.txt";

	public SushiBites(int itemID, int numberOfBites, boolean withChopsticks) {
		this.numberOfBites = numberOfBites;
		this.withChopsticks = withChopsticks;
		float multiplier = 1;
		if(numberOfBites == 10) {
			multiplier = (float) 1.6976;
		}
		switch(itemID) {
			case 1:
				this.sushiType = "California Roll";
				super.setPrice(roundTo100(12900*multiplier));
				break;
			case 2:
				this.sushiType = "Crispi Roll";
				super.setPrice(roundTo100(12900*multiplier));
				break;
			case 3:
				this.sushiType = "Dragon Roll";
				super.setPrice(roundTo100(12900*multiplier));
				break;
			case 4:
				this.sushiType = "Dinamita";
				super.setPrice(roundTo100(12900*multiplier));
				break;
			case 5:
				this.sushiType = "Salmon Tempura";
				super.setPrice(roundTo100(12900*multiplier));
				break;	
			default:
				this.sushiType = "California Roll";
				super.setPrice(roundTo100(12900*multiplier));
				break;	
		}
		
		super.setName(this.sushiType+" x" +Integer.toString(this.numberOfBites)+ " Bocados");
	}
	
	public String getSushiType() {
		return sushiType;
	}
	
	public int getNumberOfBites() {
		return numberOfBites;
	}
	
	public boolean isWithChopsticks() {
		return withChopsticks;
	}
	private int roundTo100(float initialValue) {
		return (int) Math.round(initialValue/100.0) * 100;
	}
	public static void printMenu() {
		Product.printMenu(SUSHI_MENU);
	}
}
