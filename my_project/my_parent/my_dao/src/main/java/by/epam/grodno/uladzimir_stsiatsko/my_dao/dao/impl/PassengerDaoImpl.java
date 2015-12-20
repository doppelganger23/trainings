package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.PassengerDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper.PassengerMapper;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;

@Repository
public class PassengerDaoImpl implements PassengerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(Passenger passenger) {
		Object[] args = { passenger.getFirstName(), passenger.getLastName(), passenger.getPassportNumber() };
		jdbcTemplate.update("INSERT INTO passenger (first_name, last_name, passport_number) VALUES (?,?,?)", args);
	}

	@Override
	public List<Passenger> getAll(long first, long count, String sortBy, String sortType){
		return jdbcTemplate.query(String.format(
				"select * from passenger order by %s %s limit %s offset %s ;", sortBy, sortType, count,
				first), new PassengerMapper());	
	}

	@Override
	public int getCount(){
		return jdbcTemplate.queryForObject("select count(1) from passenger ;",
				Integer.class);
	}

	@Override
	public void remove(Passenger passenger) {
		Object[] args = {passenger.getId()};
		jdbcTemplate.update("DELETE FROM passenger WHERE id = ? ;", args);
	}

}
