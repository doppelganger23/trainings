package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;

public interface AdministratorDao {

	Administrator getById(int id);
	
	Administrator getByLogin(String login);

	void insert(Administrator admin);

	void update(Administrator admin);

}
