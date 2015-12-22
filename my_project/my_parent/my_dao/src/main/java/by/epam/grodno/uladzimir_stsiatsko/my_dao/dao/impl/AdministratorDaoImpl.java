package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

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
	public Administrator getByEmail(String email) {
		return jdbcTemplate.queryForObject("select * from administrator where email = ?", new Object[] { email },
				new AdministratorMapper());
	}

	@Override
	public void insert(Administrator admin) {
		jdbcTemplate.update(
				"INSERT INTO administrator (login, password, last_name, first_name, email, access_level) VALUES (?,?,?,?,?,?) ;",
				admin.getLogin(), admin.getPassword(), admin.getLastName(), admin.getFirstName(), admin.getEmail(),
				admin.getAccessLevel());
	}

	// сделать нормальный метод
	@Override
	public void update(Administrator admin) {
		jdbcTemplate.update(
				"UPDATE administrator SET login=?, password=?, last_name=?, first_name=?, email=?, access_level=? WHERE id=?",
				admin.getLogin(), admin.getPassword(), admin.getLastName(), admin.getFirstName(), admin.getEmail(),
				admin.getAccessLevel());
	}

	@Override
	public void remove(Administrator admin) {
		Object[] args = { admin.getId() };
		jdbcTemplate.update("DELETE FROM administrator WHERE id = ? ;", args);
	}

	@Override
	public List<Administrator> getAll(long first, long count, String sortBy, String sortType) {
		return jdbcTemplate.query(String.format("select * from administrator order by %s %s limit %s offset %s ;",
				sortBy, sortType, count, first), new AdministratorMapper());
	}

	@Override
	public int getCount() {
		return jdbcTemplate.queryForObject("select count(1) from administrator ;", Integer.class);
	}

}
