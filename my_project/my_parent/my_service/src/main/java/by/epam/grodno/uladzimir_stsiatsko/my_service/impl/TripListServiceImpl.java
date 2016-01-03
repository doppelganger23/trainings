package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.TripListDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TripListService;

@Service
public class TripListServiceImpl implements TripListService {
		
	@Autowired
	TripListDao tlDao;
	
	@Override
	public void addTripList(TripList tripList){
		tlDao.insert(tripList);
	}

	public void deleteTripList(int id){
		tlDao.deleteTripList(id);
	}
	
}
