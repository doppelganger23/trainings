package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

public class PlaceInWagon {
	
	private int id;
	private int wagonId;
	private int placeNumber;
	private boolean isLower;
	private boolean isReserved;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWagonId() {
		return wagonId;
	}
	public void setWagonId(int wagonId) {
		this.wagonId = wagonId;
	}
	public int getPlaceNumber() {
		return placeNumber;
	}
	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}
	public boolean isLower() {
		return isLower;
	}
	public void setLower(boolean isLower) {
		this.isLower = isLower;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	

}
