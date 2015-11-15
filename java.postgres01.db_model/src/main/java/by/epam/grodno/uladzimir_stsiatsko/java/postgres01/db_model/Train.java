package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

public class Train {

	private int id;
	private String trainNumber;
	private double averagePathSpeedInKM;
	private double priceMultiplier;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public double getAveragePathSpeedInKM() {
		return averagePathSpeedInKM;
	}
	public void setAveragePathSpeedInKM(double averagePathSpeedInKM) {
		this.averagePathSpeedInKM = averagePathSpeedInKM;
	}
	public double getPriceMultiplier() {
		return priceMultiplier;
	}
	public void setPriceMultiplier(double priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}
	
	
}
