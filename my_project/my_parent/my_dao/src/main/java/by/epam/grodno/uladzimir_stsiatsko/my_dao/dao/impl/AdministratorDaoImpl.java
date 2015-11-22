package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.HashMap;
import java.util.Map;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.AdministratorDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;

public class AdministratorDaoImpl implements AdministratorDao {
	
	private static int ID_GEN;
	
	private static Map<Integer, Administrator> TABLE_ADMIN = new HashMap<>();
	

	@Override
	public Administrator getById(int id) {
		return TABLE_ADMIN.get(id);
	}

	@Override
	public void insert(Administrator admin) {
		admin.setId(ID_GEN++);
		TABLE_ADMIN.put(admin.getId(), admin);
	}

	@Override
	public void update(Administrator admin) {
		Administrator existingAdmin = TABLE_ADMIN.get(admin.getId());
		existingAdmin.setFirstName(admin.getFirstName());
		existingAdmin.setLastName(admin.getLastName());
		existingAdmin.setLogin(admin.getLogin());
		existingAdmin.setPassword(admin.getPassword());
	}

}
