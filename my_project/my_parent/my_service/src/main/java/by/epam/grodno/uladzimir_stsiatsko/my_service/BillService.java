package by.epam.grodno.uladzimir_stsiatsko.my_service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;

public interface BillService {
	
	void addBill(Bill bill);

	double countPrice (Bill bill);
	
	//supported types are USD and BYR, but you can add more
	int getBillingNumber(String currencyType);
	
}
