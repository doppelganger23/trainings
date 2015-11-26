package by.epam.grodno.uladzimir_stsiatsko.my_service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;

public interface RequestService {

	void find(Request request);
	
	Request getRequest(int id);
	
}
