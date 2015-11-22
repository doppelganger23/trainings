package by.epam.grodno.uladzimir_stsiatsko.my_dao.model;

import java.sql.Timestamp;

public class Request {

	private int id;
	private String departureStation;
	private String destinationStation;
	private Timestamp departureDate;
	private Timestamp arrivalDate;
	
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
	public Timestamp getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}
	public Timestamp getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
}
