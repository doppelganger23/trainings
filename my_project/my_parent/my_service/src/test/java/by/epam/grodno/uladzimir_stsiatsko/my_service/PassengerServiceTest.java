package by.epam.grodno.uladzimir_stsiatsko.my_service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.PassengerDao;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class PassengerServiceTest {
	
	@Autowired
	private PassengerService service;
	
	private PassengerDao passengerDaoMock;

	private Passenger passenger = new Passenger();

	@Before
	public void before() {
		passengerDaoMock = Mockito.mock(PassengerDao.class);

		ReflectionTestUtils.setField(service, "pDao", passengerDaoMock);
	}
	
	@Test
	public void registerPassengerTest() {
		service.registerPassenger(passenger);
		verify(passengerDaoMock).insert(passenger);
	}
	
	@Test
	public void deleteTest() {
		service.delete(passenger);
		verify(passengerDaoMock).remove(passenger);
	}
	
	@Test
	public void getAllTest() {
		service.getAll(1, 2, "sort-by-id", "ASCENDING");
		verify(passengerDaoMock).getAll(1, 2, "id", "asc");
		
		service.getAll(1, 2, "sort-by-id", "DESCENDING");
		verify(passengerDaoMock).getAll(1, 2, "id", "desc");
	}
	
	@Test
	public void getCountTest() {
		service.getCount();
		verify(passengerDaoMock).getCount();		
	}

}
