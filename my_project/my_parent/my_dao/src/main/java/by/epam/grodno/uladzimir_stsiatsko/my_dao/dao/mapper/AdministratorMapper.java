package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;


public final class AdministratorMapper implements RowMapper<Administrator> {
	@Override
	public Administrator mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String login = rs.getString("login");
		String password = rs.getString("password");
		String lastName = rs.getString("last_name");
		String firstName = rs.getString("first_name");
		Administrator admin = new Administrator();
		admin.setId(id);
		admin.setLogin(login);
		admin.setPassword(password);
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		return admin;
	}
}