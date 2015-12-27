package by.epam.grodno.uladzimir_stsiatsko.my_web.page.ticket;

import java.io.Serializable;

public class BillMetaData implements Serializable {
	
	private String currency;
	
	public BillMetaData(String currency){
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
