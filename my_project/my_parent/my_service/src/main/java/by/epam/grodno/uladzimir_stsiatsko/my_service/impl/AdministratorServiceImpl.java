package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.AdministratorDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;
import by.epam.grodno.uladzimir_stsiatsko.my_service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorDao adminDao;

	@PostConstruct
	private void init() {
		System.out.println("Post-initialization phase complete");
	}

	// пока не понятно где брать айди
	@Override
	public void insertOrUpdate(Administrator admin) {
		// ноль или null?
		if (admin.getId() == 0) {
			adminDao.insert(admin);
		} else {
			adminDao.update(admin);
		}
	}

	@Override
	public void registerAdmin(String login, String password, String firstName, String lastName) {
		Administrator admin = new Administrator();
		admin.setLogin(login);
		admin.setPassword(password);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		adminDao.insert(admin);
	}

	@Override
	public Integer authenticate(String login, String password) {
		Administrator admin = adminDao.getByLogin(login);
		if (admin != null && admin.getPassword().equals(password)){
			return admin.getId();
		}
		return null;
	}

}
