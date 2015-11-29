package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.SearchResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class SearchResultServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultServiceTest.class);
	private int cnt;

	@Autowired
	private SearchResultService service;

	//@Test
	public void quieryWithoutDatesTest() {
		LOGGER.debug("Starting quieryWithoutDatesTest");
		Request request = new Request();
		request.setDepartureStation("МОСТЫ");
		request.setDestinationStation("ОСИПОВИЧИ");
		testSearch(request);
	}
	
	//@Test
	public void quieryWithoutDepartureDateTest(){
		LOGGER.debug("Starting quieryWithoutDepartureDateTest");
		Request request = new Request();
		request.setDepartureStation("МОСТЫ");
		request.setDestinationStation("ОСИПОВИЧИ");
		request.setArrivalDate(Timestamp.valueOf("2015-12-09 00:00:00"));
		testSearch(request);
	}
	
	@Test
	public void quieryWithoutArrivalDateTest(){
		LOGGER.debug("Starting quieryWithoutArrivalDateTest");
		Request request = new Request();
		request.setDepartureStation("МОСТЫ");
		request.setDestinationStation("ОСИПОВИЧИ");
		request.setDepartureDate(Timestamp.valueOf("2015-12-01 00:00:00"));
		testSearch(request);
	}
	
	//@Test
	public void quieryWithBothDatesTest() {
		LOGGER.debug("Starting quieryWithBothDatesTest");
		Request request = new Request();
		request.setDepartureStation("МОСТЫ");
		request.setDestinationStation("ОСИПОВИЧИ");
		request.setDepartureDate(Timestamp.valueOf("2015-12-01 00:00:00"));
		request.setArrivalDate(Timestamp.valueOf("2015-12-03 00:00:00"));
		testSearch(request);
	}
	
	private void testSearch(Request request){
		LOGGER.debug("Request created. Sending to SearchResultService find method.");
		List<SearchResult> resList = service.find(request);
		Assert.assertFalse(resList.isEmpty());
		LOGGER.debug("Received response from database. Result list not empty.");

		resList.forEach(new Consumer<SearchResult>() {
			@Override
			public void accept(SearchResult e) {
				Assert.assertNotNull(e.getTripId());
				LOGGER.info("Id рейса: {}", e.getTripId());
				Assert.assertNotNull(e.getRouteName());
				LOGGER.info("Название маршрута: {}", e.getRouteName());
				Assert.assertNotNull(e.getTrain());
				LOGGER.info("Номер поезда: {}", e.getTrain());
				LOGGER.info("Дата отправления: {}", e.getDepartureDate());
				LOGGER.info("Продано билетов: {}", e.getSold());
				LOGGER.info("---------------------");
				cnt++;
			}
		});
		LOGGER.info("Рейсов в выдаче: {}", cnt);
		cnt = 0;
	}

}
