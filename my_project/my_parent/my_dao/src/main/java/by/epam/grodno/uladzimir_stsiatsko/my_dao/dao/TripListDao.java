package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;

public interface TripListDao {
	
	List<TripList> findTrips(Request request);
	
}
