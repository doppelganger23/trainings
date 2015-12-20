package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;

public interface PassengerService {
	
	void registerPassenger(Passenger passenger);
	
	void delete (Passenger passenger);
	
	List<Passenger> getAll(long first, long count, String sortBy, String sortType);
		
	int getCount();

}
