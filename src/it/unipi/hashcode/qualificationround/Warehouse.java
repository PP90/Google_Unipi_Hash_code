package it.unipi.hashcode.qualificationround;

import java.util.List;

public class Warehouse {
	int id;
	int x;
	int y;
	List<ProductType> availability;// contains for ALL the product types the
									// respective availability
	
	
	public int getId() {
		return id;
	}
	public Warehouse(int id, int x, int y, List<ProductType> availability) {
										super();
										this.id = id;
										this.x = x;
										this.y = y;
										this.availability = availability;
									}
	public void setId(int id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public List<ProductType> getAvailability() {
		return availability;
	}
	public void setAvailability(List<ProductType> availability) {
		this.availability = availability;
	}
	
}
