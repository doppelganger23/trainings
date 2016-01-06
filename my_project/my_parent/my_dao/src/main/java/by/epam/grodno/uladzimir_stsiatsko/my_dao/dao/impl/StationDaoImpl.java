package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.StationDao;

@Repository
public class StationDaoImpl implements StationDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> getStations(){
		return jdbcTemplate.query("SELECT name FROM station;", new SingleColumnRowMapper<String>());
	}

}
