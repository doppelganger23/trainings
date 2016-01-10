package by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;

public class PassengerMapper implements RowMapper<Passenger> {
	
	@Override
	public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		String lastName = rs.getString("last_name");
		String firstName = rs.getString("first_name");
		String passportNumber = rs.getString("passport_number");
		
		Passenger passenger = new Passenger();
		
		passenger.setId(id);
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setPassportNumber(passportNumber);
		
		return passenger;
	}

}
