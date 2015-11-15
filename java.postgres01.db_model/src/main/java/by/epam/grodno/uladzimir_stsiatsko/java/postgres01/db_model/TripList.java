package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

import java.sql.Date;

public class TripList {

	private int id;
	private int trainId;
	private int wagonId;
	private int routeId;
	private String assignedWagonNumber;
	private Date departureDate;
	private Date departureTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public int getWagonId() {
		return wagonId;
	}
	public void setWagonId(int wagonId) {
		this.wagonId = wagonId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getAssignedWagonNumber() {
		return assignedWagonNumber;
	}
	public void setAssignedWagonNumber(String assignedWagonNumber) {
		this.assignedWagonNumber = assignedWagonNumber;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	
}
