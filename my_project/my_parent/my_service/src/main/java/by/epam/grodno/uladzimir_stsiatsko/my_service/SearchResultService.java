package by.epam.grodno.uladzimir_stsiatsko.my_service;

import java.util.List;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.SearchResult;


public interface SearchResultService {

	/** Must be either <= or >= */
	void setDepartureDateCondition(String condition);
	
	/** Must be either <= or >= */
	void setArrivalDateCondition(String condition);
	
	List<SearchResult> find(Request request);
	
}
