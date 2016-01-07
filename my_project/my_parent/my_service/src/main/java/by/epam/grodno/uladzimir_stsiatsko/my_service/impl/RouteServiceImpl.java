package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.RouteDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Route;
import by.epam.grodno.uladzimir_stsiatsko.my_service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	RouteDao rDao;
	
	public List<Route> findAll(){
		return rDao.getAll();
	}

	@Override
	public void delete(Route route) {
		rDao.detete(route);
	}

	@Override
	public List<Route> getAll(long first, long count, String sortBy, String sortType) {
		return rDao.getAll(first, count, sortBy, sortType);
	}

	@Override
	public int getCount() {
		return rDao.getCount();
	}

}
