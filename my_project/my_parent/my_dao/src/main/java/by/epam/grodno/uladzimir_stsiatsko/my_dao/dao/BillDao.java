package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;

public interface BillDao {

	void insert(Bill bill);
	
	//counts price for each block through which passenger will travel
	List<Double> getPriceElements(Bill bill);
	
}
