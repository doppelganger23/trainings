package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

public class StationToStationBlock {
	
	private int id;
	private String departureStation;
	private String destinationStation;
	private double distanceInKilometres;
	
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
	public double getDistanceInKilometres() {
		return distanceInKilometres;
	}
	public void setDistanceInKilometres(double distanceInKilometres) {
		this.distanceInKilometres = distanceInKilometres;
	}
	

}
