package it.unipi.hashcode.qualificationround;

public class Drone {
	int x;
	int y;
	int weight;
	int maxPayload;
	
	public Drone(int x, int y, int weight, int maxPayload) {
		super();
		this.x = x;
		this.y = y;
		this.weight = weight;
		this.maxPayload = maxPayload;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getMaxPayload() {
		return maxPayload;
	}

	public void setMaxPayload(int maxPayload) {
		this.maxPayload = maxPayload;
	}
}
