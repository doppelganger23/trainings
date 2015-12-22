package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.AdministratorDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;
import by.epam.grodno.uladzimir_stsiatsko.my_service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorDao adminDao;

	@Override
	public void register(String login, String password, String firstName, String lastName, String email,
			String accessLevel) {
		Administrator admin = new Administrator();
		admin.setLogin(login);
		admin.setPassword(password);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setEmail(email);
		admin.setAccessLevel(accessLevel);
		adminDao.insert(admin);
	}
	
	@Override
	public Administrator getByLogin(String login){
		return adminDao.getByLogin(login);
	}
	
	@Override
	public Administrator getByEmail(String email){
		return adminDao.getByEmail(email);		
	}

	@Override
	public Integer authenticate(String login, String password) {
		Administrator admin = adminDao.getByLogin(login);
		if (admin != null && admin.getPassword().equals(password)) {
			return admin.getId();
		}
		return null;
	}

	@Override
	public void register(Administrator admin) {
		adminDao.insert(admin);
	}

	@Override
	public void delete(Administrator admin) {
		adminDao.remove(admin);	
	}

	@Override
	public List<Administrator> getAll(long first, long count, String sortBy, String sortType) {
		if (sortBy == "sort-by-id") {
			if (sortType == "ASCENDING") {
				return adminDao.getAll(first, count, "id", "asc");
			} else
				return adminDao.getAll(first, count, "id", "desc");
		}
		if (sortBy == "sort-by-login") {
			if (sortType == "ASCENDING") {
				return adminDao.getAll(first, count, "login", "asc");
			} else {
				return adminDao.getAll(first, count, "login", "desc");
			}
		}
		if (sortBy == "sort-by-first-name") {
			if (sortType == "ASCENDING") {
				return adminDao.getAll(first, count, "first_name", "asc");
			} else {
				return adminDao.getAll(first, count, "first_name", "desc");
			}
		}
		if (sortBy == "sort-by-last-name") {
			if (sortType == "ASCENDING") {
				return adminDao.getAll(first, count, "last_name", "asc");
			} else {
				return adminDao.getAll(first, count, "last_name", "desc");
			}
		}
		if (sortBy == "sort-by-email") {
			if (sortType == "ASCENDING") {
				return adminDao.getAll(first, count, "email", "asc");
			} else {
				return adminDao.getAll(first, count, "email", "desc");
			}
		}
		if (sortBy == "sort-by-access-level") {
			if (sortType == "ASCENDING") {
				return adminDao.getAll(first, count, "access_level", "asc");
			} else {
				return adminDao.getAll(first, count, "access_level", "desc");
			}
		}
		return adminDao.getAll(first, count, "id", "asc");
	}

	@Override
	public int getCount() {
		return adminDao.getCount();
	}

}
