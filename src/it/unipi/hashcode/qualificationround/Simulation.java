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
	List<DeliveryPoints> deliveryPoints;
	List<Drone> drones;
	Map<Drone,Warehouse> clusters;
}
