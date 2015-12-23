package by.epam.grodno.uladzimir_stsiatsko.my_web.page.ticket;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

@AuthorizeInstantiation(value = { "admin", "passenger" })
public class NameInputPage extends AbstractPage{
	
	public NameInputPage(Bill bill){
		
	}

}
