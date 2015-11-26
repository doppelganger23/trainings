package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.RequestDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;
import by.epam.grodno.uladzimir_stsiatsko.my_service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestDao dao;
	
	public void find(Request request){
		dao.setQuiery(request);
	}
	
	public Request getRequest(int id){
		 return dao.getById(id);
	}
}
