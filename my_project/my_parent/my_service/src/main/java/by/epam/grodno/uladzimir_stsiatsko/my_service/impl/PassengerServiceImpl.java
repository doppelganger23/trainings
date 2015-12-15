package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.PassengerDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;
import by.epam.grodno.uladzimir_stsiatsko.my_service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerDao pDao;
	
	@Override
	public void registerPassenger(Passenger passenger){
		pDao.insert(passenger);
	}

}
