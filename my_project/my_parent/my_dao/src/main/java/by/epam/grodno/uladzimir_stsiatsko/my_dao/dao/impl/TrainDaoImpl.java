package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.TrainDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper.TrainMapper;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Train;

@Repository
public class TrainDaoImpl implements TrainDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Train> getAll(){
		return jdbcTemplate.query("SELECT * FROM train;", new TrainMapper());
	}
	
}
