package by.epam.grodno.uladzimir_stsiatsko.my_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.dao.SearchResultDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db-context.xml")
public class SearchResultDaoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultDaoTest.class);
	
	@Autowired
	private SearchResultDao srDao;
	
	@Test
	public void testMethod(){
	}
	
}
