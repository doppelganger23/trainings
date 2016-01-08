package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Station;

public interface StationService {

	List<String> getStationNames();
	
	List<Station> getStations();
	
	String getName(int stationId);
	
}
