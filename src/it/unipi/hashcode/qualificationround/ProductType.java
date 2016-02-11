package it.unipi.hashcode.qualificationround;

public class ProductType {
	String name;
	int weight;//1<=weight<=maxpayload
	
	public ProductType(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
