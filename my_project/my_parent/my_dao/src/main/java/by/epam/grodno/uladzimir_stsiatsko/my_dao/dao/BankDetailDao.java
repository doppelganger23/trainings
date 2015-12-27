package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.BankDetail;

public interface BankDetailDao {
	
	List<String> getAllTypes();
	
	List<BankDetail> getAll();
	
	//заменены на ^, удалить?
	double getByrExchangeRate(String currencyType);
	int getBillingNumber(String currencyType);

}
