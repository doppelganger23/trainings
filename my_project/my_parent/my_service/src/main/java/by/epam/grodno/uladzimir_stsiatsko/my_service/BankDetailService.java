package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.BankDetail;

public interface BankDetailService {

	List<String> findAllTypes();
	
	List<BankDetail> findAll();
	
	//заменены на ^, удалить?
	double getByrExchangeRate(String currencyType);
	int getBillingNumber(String currencyType);
	
}
