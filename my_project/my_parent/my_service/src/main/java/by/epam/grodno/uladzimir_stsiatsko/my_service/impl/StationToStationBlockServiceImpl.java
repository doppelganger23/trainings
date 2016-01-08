package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.StationToStationBlockDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.StationToStationBlock;
import by.epam.grodno.uladzimir_stsiatsko.my_service.StationToStationBlockService;

@Service
public class StationToStationBlockServiceImpl implements StationToStationBlockService {

	@Autowired
	StationToStationBlockDao stsDao;
	
	public List<StationToStationBlock> getBlocks(){
		return stsDao.getBlocks();
	}
	
}
