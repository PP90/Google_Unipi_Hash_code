package it.unipi.hashcode.qualificationround;

import java.util.List;
import java.util.Map;

public class Simulation {
	int rowsArea;
	int colsArea;
	int D; //number of drones
	int deadline;
	int maxPayloadDrone;
	int W; //number of warehouses 1<=W<=10000
	int C; //number of customers orders
	
	List<Warehouse> warehouses;
	List<DeliveryPoint> deliveryPoints;
	List<Drone> drones;
	Map<Drone,Warehouse> droneCluster;
	Map<DeliveryPoint,Warehouse> warehouseCluster;
	List<Order> orders;
	
	public String simulate(){
		return null;
	}
}
