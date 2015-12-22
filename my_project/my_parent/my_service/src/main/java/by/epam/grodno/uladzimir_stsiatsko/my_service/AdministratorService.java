package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;

public interface AdministratorService {
	
	Integer authenticate(String login, String password);
	
	void register(String login, String password, String firstName, String lastName, String email, String accessLevel);
	
	void register(Administrator admin);
	
	void delete (Administrator admin);
	
	Administrator getByLogin(String login);
	
	Administrator getByEmail(String email);
	
	List<Administrator> getAll(long first, long count, String sortBy, String sortType);
	
	int getCount();
}
