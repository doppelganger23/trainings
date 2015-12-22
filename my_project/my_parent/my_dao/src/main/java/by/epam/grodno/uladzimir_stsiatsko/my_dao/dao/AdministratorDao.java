package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;

public interface AdministratorDao {

	void insert(Administrator admin);

	void update(Administrator admin);

	void remove(Administrator admin);

	Administrator getById(int id);

	Administrator getByLogin(String login);
	
	Administrator getByEmail(String email);

	List<Administrator> getAll(long first, long count, String sortBy, String sortType);

	int getCount();

}
