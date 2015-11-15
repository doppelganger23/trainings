package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

public class Bill {
	
	private int id;
	private int passengerId;
	private int tripListId;
	private double paymentValue;
	private String billingNumber;
	private boolean isPaid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public int getTripListId() {
		return tripListId;
	}
	public void setTripListId(int tripListId) {
		this.tripListId = tripListId;
	}
	public double getPaymentValue() {
		return paymentValue;
	}
	public void setPaymentValue(double paymentValue) {
		this.paymentValue = paymentValue;
	}
	public String getBillingNumber() {
		return billingNumber;
	}
	public void setBillingNumber(String billingNumber) {
		this.billingNumber = billingNumber;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	
}
