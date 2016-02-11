package it.unipi.hashcode.qualificationround;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Simulation {
	int rowsArea;
	int colsArea;
	int D; // number of drones 1<=D<=1000
	int deadline;
	int maxPayloadDrone;
	int W; // number of warehouses 1<=W<=10000
	int C; // number of customers orders

	List<Warehouse> warehouses;
	List<DeliveryPoint> deliveryPoints;
	List<Drone> drones;
	Map<Drone, Warehouse> droneCluster;
	Map<DeliveryPoint, Warehouse> deliveryCluster;
	List<Order> orders;
	Map<Warehouse,HashSet<Product>> demands;
	
	

	public Simulation(int rowsArea, int colsArea, int d, int deadline, int maxPayloadDrone, int w, int c,
			List<Warehouse> warehouses, List<DeliveryPoint> deliveryPoints, List<Drone> drones, List<Order> orders) {
		super();
		this.rowsArea = rowsArea;
		this.colsArea = colsArea;
		D = d;
		this.deadline = deadline;
		this.maxPayloadDrone = maxPayloadDrone;
		W = w;
		C = c;
		this.warehouses = warehouses;
		this.deliveryPoints = deliveryPoints;
		this.drones = drones;
		this.droneCluster = new HashMap<Drone, Warehouse>(drones.size());
		this.deliveryCluster = new HashMap<DeliveryPoint, Warehouse> (deliveryPoints.size());
		this.orders = orders;
		this.demands = new HashMap<Warehouse,HashSet<Product>>(W);
	}

	public int getRowsArea() {
		return rowsArea;
	}

	public void setRowsArea(int rowsArea) {
		this.rowsArea = rowsArea;
	}

	public int getColsArea() {
		return colsArea;
	}

	public void setColsArea(int colsArea) {
		this.colsArea = colsArea;
	}

	public int getD() {
		return D;
	}

	public void setD(int d) {
		D = d;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public int getMaxPayloadDrone() {
		return maxPayloadDrone;
	}

	public void setMaxPayloadDrone(int maxPayloadDrone) {
		this.maxPayloadDrone = maxPayloadDrone;
	}

	public int getW() {
		return W;
	}

	public void setW(int w) {
		W = w;
	}

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public List<DeliveryPoint> getDeliveryPoints() {
		return deliveryPoints;
	}

	public void setDeliveryPoints(List<DeliveryPoint> deliveryPoints) {
		this.deliveryPoints = deliveryPoints;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}

	public Map<Drone, Warehouse> getDroneCluster() {
		return droneCluster;
	}

	public void setDroneCluster(Map<Drone, Warehouse> droneCluster) {
		this.droneCluster = droneCluster;
	}

	public Map<DeliveryPoint, Warehouse> getDeliveryCluster() {
		return deliveryCluster;
	}

	public void setDeliveryCluster(Map<DeliveryPoint, Warehouse> deliveryCluster) {
		this.deliveryCluster = deliveryCluster;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String simulate() {
		//Create association DeliveryPoint - Warehouse
		for (DeliveryPoint dp : deliveryPoints) {
			int distance = Integer.MAX_VALUE;
			Warehouse owner = null;
			for (Warehouse w : warehouses) {
				int currentDistance = distance(dp.getX(), dp.getY(), w.getX(), w.getY());
				if (currentDistance < distance) {
					distance = currentDistance;
					owner = w;
				}

			}
			deliveryCluster.put(dp, owner);
		}
		//Create association Drone - Warehouse
		int deliveryPointsNumber = deliveryPoints.size();
		int alreadyComputedDrones = 0;
		for (Warehouse w : warehouses){
			//Compute drones per warehouse
			int dw = deliveryPointsPerWarehouse(w);
			int percentage = (dw /deliveryPointsNumber)*D;
			for(int i =0;i<percentage;++i){
			    Drone currentDrone = drones.get(i+alreadyComputedDrones);
			    droneCluster.put(currentDrone,w);
			}
			alreadyComputedDrones += percentage;
		}
		//Distribute uniformely random the remaining drones
		if(alreadyComputedDrones<D){
			int missingDrones = D - alreadyComputedDrones;
			for(int i =0;i<missingDrones;++i){
				Random r  = new Random();
				int pivot = r.nextInt(W);
				Drone currentDrone = drones.get(i+alreadyComputedDrones);
				Warehouse w = warehouses.get(pivot);
				droneCluster.put(currentDrone,w);
			}
		}
		//Compute demands for all warehouses
		for(Order o:orders){
			DeliveryPoint dp = o.getdPoint();
			Warehouse w = deliveryCluster.get(dp);
			if(!demands.containsKey(w)){
				demands.put(w, new HashSet<Product>());
			}
			HashSet<Product> wDemands = demands.get(w);
			List<Product> currentDemand = o.getItems();
			for(Product p: currentDemand){
				Product toSum = wDemands.contains(p)
			}
			
		}
		return null;
	}

	public static int distance(int xa, int ya, int xb, int yb) {
		double diffX = (double) (xa - xb);
		double diffY = (double) (ya - yb);
		double result = Math.sqrt(diffX * diffX + diffY * diffY);
		return (int) Math.ceil(result);
	}
	
	public int deliveryPointsPerWarehouse(Warehouse w){
		int i =0;
		for(DeliveryPoint d : deliveryPoints){
			if(deliveryCluster.get(d)==w){
				i++;
			}
		}
		return i;
	}
}
