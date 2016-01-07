package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Route;

public interface RouteService {
	
	void delete(Route route);
	
	List<Route> getAll(long first, long count, String sortBy, String sortType);
	
	int getCount();
	
	List<Route> findAll();

}
