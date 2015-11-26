package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class RequestServiceTest {

	@Autowired
	private RequestService service;

	@Test
	public void setQuieryTest(){
		Request request = new Request();
		request.setDepartureStation("Grodno");
		request.setDestinationStation("St.Petersburg");
		request.setDepartureDate(new Timestamp(99999));
		request.setArrivalDate(new Timestamp(99999));
		service.find(request);
	}
	
	@Test
	public void getRequestTest(){
		Assert.assertNotNull(service.getRequest(1));
	}

}
