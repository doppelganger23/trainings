package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.TrainDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Train;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	TrainDao tDao;
	
	public List<Train> findAll(){
		return tDao.getAll();
	}
	
}
