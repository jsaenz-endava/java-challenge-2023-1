package shopAssets;

public class User {
	
	private String name;
	private int cellphoneNumber;
	private String email;
	
	public User(String name, int cellphoneNumber, String email) { 
		this.name = name;
		this.cellphoneNumber = cellphoneNumber;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public int getCellphoneNumber() {
		return cellphoneNumber;
	}
	
	public String getEmail() {
		return email;
	}


}
