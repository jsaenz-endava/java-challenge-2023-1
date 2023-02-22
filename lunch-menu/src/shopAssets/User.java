package shopAssets;

public class User {
	
	private String name;
	private String cellphoneNumber;
	private String email;
	
	public User(String name, String cellphoneNumber, String email) { 
		this.name = name;
		this.cellphoneNumber = cellphoneNumber;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

}
