package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.PassengerDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;

@Repository
public class PassengerDaoImpl implements PassengerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(Passenger passenger) {

		Object[] args = {passenger.getFirstName(), passenger.getLastName(), passenger.getPassportNumber()};
		jdbcTemplate.update("INSERT INTO passenger (first_name, last_name, passport_number) VALUES (?,?,?)", args);
		
	}

}
