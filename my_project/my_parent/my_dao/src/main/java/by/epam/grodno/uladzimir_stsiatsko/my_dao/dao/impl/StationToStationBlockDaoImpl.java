package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.StationToStationBlockDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper.StationToStationBlockMapper;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.StationToStationBlock;

@Repository
public class StationToStationBlockDaoImpl implements StationToStationBlockDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	public List<StationToStationBlock> getBlocks(){
		return jdbcTemplate.query("SELECT * FROM station_to_station_block", new StationToStationBlockMapper());
	}

}
