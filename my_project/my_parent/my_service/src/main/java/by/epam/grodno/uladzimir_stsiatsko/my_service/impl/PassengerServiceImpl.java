package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

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
	
	public void delete (Passenger passenger){
		pDao.remove(passenger);
	}
	
	@Override
	public List<Passenger> getAll(long first, long count, String sortBy, String sortType){
		if (sortBy == "sort-by-id") {
			if (sortType == "ASCENDING") {
				return pDao.getAll(first, count, "id", "asc");
			} else
				return pDao.getAll(first, count, "id", "desc");
		}
		if (sortBy == "sort-by-first-name") {
			if (sortType == "ASCENDING") {
				return pDao.getAll(first, count, "first_name", "asc");
			} else {
				return pDao.getAll(first, count, "first_name", "desc");
			}
		}
		if (sortBy == "sort-by-last-name") {
			if (sortType == "ASCENDING") {
				return pDao.getAll(first, count, "last_name", "asc");
			} else {
				return pDao.getAll(first, count, "last_name", "desc");
			}
		}
		if (sortBy == "sort-by-passport-number") {
			if (sortType == "ASCENDING") {
				return pDao.getAll(first, count, "passport_number", "asc");
			} else {
				return pDao.getAll(first, count, "passport_number", "desc");
			}
		}
		return pDao.getAll(first, count, "id", "asc");
	}
	
	@Override
	public int getCount(){
		return pDao.getCount();
	}
	
}
