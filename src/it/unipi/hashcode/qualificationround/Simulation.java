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
		for(DeliveryPoint dp:deliveryPoints){
			int distance = Integer.MAX_VALUE;
			for(Warehouse w:warehouses){
				int currentDistance = distance(dp.getX(),dp.getY(),w.getX(),w.getY());
				if(currentDistance < distance){
					distance = currentDistance;
				}
				
			}
		}
		return null;
	}
	
	public static int distance(int xa, int ya, int xb, int yb){
		double diffX = (double) (xa - xb);
		double diffY = (double) (ya - yb);
		double result =Math.sqrt(diffX*diffX + diffY*diffY);
		return (int) Math.ceil(result);
	}
}
