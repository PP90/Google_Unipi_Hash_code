package it.unipi.hashcode.qualificationround;

public class Product {
	ProductType type;
	int quantity;

	public Product(ProductType type) {
		this(type, 0);
	}

	public Product(ProductType type, int quantity) {
		super();
		this.type = type;
		this.quantity = quantity;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addQuantity(int quantityToAdd) {
		this.quantity += quantityToAdd;
	}
	public void addQuantity(Product p){
		if (p.getType().getName()==type.getName()){
			addQuantity(p.getQuantity());
		}
	}
}
