package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.StationDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Station;
import by.epam.grodno.uladzimir_stsiatsko.my_service.StationService;

@Service
public class StationServiceImpl implements StationService {
	
	@Autowired
	private StationDao sDao;
	
	public List<Station> getStations(){
		return sDao.getStations();
	}
	
	public List<String> getStationNames(){
		return sDao.getStationNames();
	}

	public String getName(int stationId){
		return sDao.getName(stationId);
	}
}
