package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

public class Wagon {

	private int id;
	private String wagonNumber;
	private double priceMultiplier;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWagonNumber() {
		return wagonNumber;
	}
	public void setWagonNumber(String wagonNumber) {
		this.wagonNumber = wagonNumber;
	}
	public double getPriceMultiplier() {
		return priceMultiplier;
	}
	public void setPriceMultiplier(double priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}
	
}
