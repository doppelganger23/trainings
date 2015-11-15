package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

import java.sql.Date;

public class Request {

	private int id;
	private String departureStation;
	private String destinationStation;
	private Date departureDate;
	private Date arrivalDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartureStation() {
		return departureStation;
	}
	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
}
