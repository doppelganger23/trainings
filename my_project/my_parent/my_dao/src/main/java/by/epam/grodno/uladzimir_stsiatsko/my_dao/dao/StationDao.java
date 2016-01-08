package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Station;

public interface StationDao {

	List<String> getStationNames();
	
	List<Station> getStations();
	
	String getName(int stationId);
	
}
