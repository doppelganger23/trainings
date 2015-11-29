package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.TripListDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper.TripListMapper;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;

@Repository
public class TripListDaoImpl implements TripListDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TripListMapper tlMapper;
	
	public List<TripList> findTrips(Request request) {
		return jdbcTemplate.query("SELECT * FROM trip_list", tlMapper);
//		тестовый запрос, вернет весь список
		
		
		//return jdbcTemplate.query(, tlmapper);
		
		}
	
}
