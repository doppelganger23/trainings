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
	
	
	@Override
	public Long insert(TripList tripList) {

		Object[] args = {tripList.getTrainId(), tripList.getRouteId(), tripList.getDepartureDate(), tripList.getTicketsSold()};
		jdbcTemplate.update("INSERT INTO trip_list (train_id, route_id, departure_date, tickets_sold) VALUES (?,?,?,?)", args);

		//разобраться потом (альтернатива с возвратом id)
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//				PreparedStatement ps = connection
//						.prepareStatement(
//								"INSERT INTO user_account (email, first_name, last_name,"
//										+ " creation_date, active, birth_date) VALUES (?,?,?,?,?,?)",
//								new String[] { "id" });
//				ps.setString(1, user.getEmail());
//				ps.setString(2, user.getFirstName());
//				ps.setString(3, user.getLastName());
//				ps.setDate(4, new Date(user.getCreationDate().getTime()));
//				ps.setBoolean(5, user.isActive());
//				ps.setDate(6, new Date(user.getBirthDate().getTime()));
//				return ps;
//			}
//		}, keyHolder);
//		return keyHolder.getKey().longValue();
		
		//temporal stub for ^^^ to work
		return new Long(0);
	}
	
	//убрать/заменить
	public List<TripList> findTrips(Request request) {
		//	тестовый запрос, вернет весь список	
		return jdbcTemplate.query("SELECT * FROM trip_list", tlMapper);
	}
	
}
