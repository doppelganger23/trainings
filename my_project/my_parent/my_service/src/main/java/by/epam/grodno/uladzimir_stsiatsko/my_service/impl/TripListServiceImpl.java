package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.TripListDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TripListService;

@Service
public class TripListServiceImpl implements TripListService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TripListServiceImpl.class);
	
	@Autowired
	TripListDao tlDao;
	
	@Override
	public void addTripList(TripList tripList){
		tlDao.insert(tripList);
	}

}
