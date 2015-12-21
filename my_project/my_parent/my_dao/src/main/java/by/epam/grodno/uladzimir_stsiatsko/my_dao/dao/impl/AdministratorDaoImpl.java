package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.AdministratorDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper.AdministratorMapper;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;

@Repository
public class AdministratorDaoImpl implements AdministratorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Administrator getById(int id) {
		return jdbcTemplate.queryForObject("select * from administrator where id = ?", new Object[] { id },
				new AdministratorMapper());
	}
	
	@Override
	public Administrator getByLogin(String login) {
		return jdbcTemplate.queryForObject("select * from administrator where login = ?", new Object[] { login },
				new AdministratorMapper());
	}

	@Override
	public void insert(Administrator admin) {
		jdbcTemplate.update("INSERT INTO administrator (login, password, last_name, first_name, email) VALUES (?,?,?,?,?)",
				admin.getLogin(), admin.getPassword(), admin.getLastName(), admin.getFirstName(), admin.getEmail());
	}

	@Override
	public void update(Administrator admin) {
//		Administrator existingAdmin = TABLE_ADMIN.get(admin.getId());
//		existingAdmin.setFirstName(admin.getFirstName());
//		existingAdmin.setLastName(admin.getLastName());
//		existingAdmin.setLogin(admin.getLogin());
//		existingAdmin.setPassword(admin.getPassword());
	}

}
