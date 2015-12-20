package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;

public interface PassengerDao {
	
	void insert(Passenger passenger);
	
	void remove(Passenger passenger);
	
	List<Passenger> getAll(long first, long count, String sortBy, String sortType);
	
	int getCount();

}
