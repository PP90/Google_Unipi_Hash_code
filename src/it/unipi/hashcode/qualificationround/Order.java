package it.unipi.hashcode.qualificationround;

import java.util.ArrayList;
import java.util.List;

public class Order {

	DeliveryPoint dPoint;
	
	List<ProductType> items;
	
	public Order(DeliveryPoint dPoint){
		this.dPoint = dPoint;
		items = new ArrayList<ProductType>();
	}
	
	public void addItem(ProductType pt){
		items.add(pt);
	}

	public DeliveryPoint getdPoint() {
		return dPoint;
	}

	public void setdPoint(DeliveryPoint dPoint) {
		this.dPoint = dPoint;
	}

	public List<ProductType> getItems() {
		return items;
	}

	public void setItems(List<ProductType> items) {
		this.items = items;
	}
	
	
	
}
