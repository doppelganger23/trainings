package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.StationDao;
import by.epam.grodno.uladzimir_stsiatsko.my_service.StationService;

@Service
public class StationServiceImpl implements StationService {
	
	@Autowired
	StationDao sDao;
	
	public List<String> getStations(){
		return sDao.getStations();
	}

}
