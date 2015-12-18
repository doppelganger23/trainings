package by.epam.grodno.uladzimir_stsiatsko.my_dao.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Bill {
	
	private int id;
	private int passengerId;
	private int tripListId;
	private double paymentValue;
	private boolean isPaid;
	private int billingNumber;
	private int fromBlock;
	private int toBlock;
	private Date creationDate;
	
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
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public int getBillingNumber() {
		return billingNumber;
	}
	public void setBillingNumber(int billingNumber) {
		this.billingNumber = billingNumber;
	}
	public int getFromBlock() {
		return fromBlock;
	}
	public void setFromBlock(int fromBlock) {
		this.fromBlock = fromBlock;
	}
	public int getToBlock() {
		return toBlock;
	}
	public void setToBlock(int toBlock) {
		this.toBlock = toBlock;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
