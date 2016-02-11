package it.unipi.hashcode.qualificationround;

import java.util.ArrayList;
import java.util.List;

public class Order {

	DeliveryPoint dPoint;
	
	List<Product> items;
	
	public Order(DeliveryPoint dPoint){
		this.dPoint = dPoint;
		items = new ArrayList<Product>();
	}
	
	public void addItem(Product pt){
		items.add(pt);
	}

	public DeliveryPoint getdPoint() {
		return dPoint;
	}

	public void setdPoint(DeliveryPoint dPoint) {
		this.dPoint = dPoint;
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	
	
}
