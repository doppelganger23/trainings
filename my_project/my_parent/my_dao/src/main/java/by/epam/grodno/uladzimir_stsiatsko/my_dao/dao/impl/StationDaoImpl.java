package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.StationDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper.StationMapper;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Station;

@Repository
public class StationDaoImpl implements StationDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<String> getStationNames(){
		return jdbcTemplate.query("SELECT name FROM station;", new SingleColumnRowMapper<String>());
	}

	public List<Station> getStations(){
		return jdbcTemplate.query("SELECT * FROM station;", new StationMapper());
	}
	
	public String getName(int stationId){
		Object[] args = {stationId};
		return jdbcTemplate.queryForObject("SELECT name FROM station WHERE id = ? ;", String.class, args);
	}
	
}
