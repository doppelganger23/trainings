package by.epam.grodno.uladzimir_stsiatsko.my_service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.AdministratorDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;
import by.epam.grodno.uladzimir_stsiatsko.my_service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorDao adminDao;

	@PostConstruct
	private void init() {
		System.out.println("Post-initialization phase complete");
	}

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

}
