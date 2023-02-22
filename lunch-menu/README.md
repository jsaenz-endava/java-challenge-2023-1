# Sr. Wok's Lunch Menu

Hello dear reader.

This folder contains a Java project with a program for purchasing diferent kinds of 
Sr. Wok products and interact with them.

You can add products, remove products, navigate through Bowls, Sushi and Drinks 
menus, and, you can checkout the status of your shopping cart.

The program itself runs on console, some data validation is implemented but you 
should be carrefull still, the program at this stage may not forgive you.

For single input just type a number and press enter.
For multiple input (Bowls creation) you must type the options separated by simple
space (i.e: `1 2 3`).

This program is based on the Rappi's Sr. Wok store, the prices were created 
accordingly and the language is spanish for the UI.

v1.0.0.

```mermaid
classDiagram
Product <|-- Bowl
Product <|-- Drink
Product <|-- SushiBites

ShopMenu <.. ShoppingCart

Bowl "1" *-- "1" Base
Bowl "1"*-- "1..3" Protein

Tops <|-- Base
Tops <|-- Protein

ShoppingCart "1" *-- "1" User
ShoppingCart "1" *-- "0..n" Product

 class Product {
    <<abstract>>
	+String name
	+int price

	+getName(): String
    #setName(String name):void
	+getPrice(): int
	#setPrice(int price): void
}

class Tops{
    <<abstract>>
    -String name
	-int extraPrice

	#getName(): String
	#setName(String name): void
	#getExtraPrice(): int
	#setExtraPrice(int extraPrice): void
}

class Bowl{
    -String size;
	-Base bowlBase;
	-List~Protein~ bowlProteins

	+Bowl(int bowlBaseID, int bowlProteinID)
	+Bowl(int bowlBaseID, int bowlProtein1ID, int bowlProtein2ID) 
	+Bowl(int bowlBaseID, int bowlProtein1ID, int bowlProtein2ID, int bowlProtein3ID ) 
	-setName(): void
	-setPrice(): void
	+getSize(): String
	+getBowlBase(): Base
	+getBowlProteins(): List~Protein~
}

class Base{
    +Base(int itemID): void
}

class Protein{
    +Protein(int itemID): void
}

class Drink{
    -String brand
	-int volume
	
	+Drink(int itemID)
	-setName(): void
	+getBrand(): String 
	+getVolume(): int
}

class SushiBites{
    -String sushiType;
	-int numberOfBites;
	-boolean withChopsticks;

	+SushiBites(int itemID, int numberOfBites, boolean withChopsticks)
	-setName(): void
	+getSushiType(): String
	+getNumberOfBites(): int
	+isWithChopsticks(): boolean
	-roundTo100(float initialValue): int
}

class ShopMenu{
    <<abstract>>
    -String BOWLS_MENU$
	-String SUSHI_MENU$
	-String DRINKS_MENU$
	+String MAIN$
	+String BOWLS$
    +String SUSHI$
    +String DRINKS$
    +String CART$
    +String PAYMENT$

    +loginMenu()$: User
    +mainMenu()$: String
    +bowlsMenu()$: String
    +sushiMenu()$: String
    +drinksMenu()$: String
    +cartMenu()$: String
    -separator()$: void
    -printMenu(String productMenuPath)$: void
}

class ShoppingCart{
    -User currentUser;
	-List~Product~
	-int total;
	
	+ShoppingCart(User currentUser)
	+addProduct(Product someProduct, int copies): void
	+getProduct(int productIdx): Product
	+getListOfProducts(): List~Product~
	+removeProduct(int productIdx): void 
	+getUser(): User 
	+getTotal(): int
	-updateTotal(): void
	+printTicket(): public
}

class User{
    -String name
	-String cellphoneNumber
	-String email
	
	+User(String name, String cellphoneNumber, String email)
	+getName(): String
	+getCellphoneNumber(): String
	+getEmail(): String
}
```
