package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.Link;

import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

@AuthorizeAction(action=Action.RENDER)
public class AdminActionsPage extends AbstractPage {

	public AdminActionsPage() {
		
		add(new Link<Void>("edit-accounts-page-link") {
			@Override
			public void onClick() {
				setResponsePage(EditAccountsPage.class);
			}
		});
		add(new Link<Void>("edit-trip-lists-page-link") {
			@Override
			public void onClick() {
				setResponsePage(EditTripListsPage.class);
			}
		});
		add(new Link<Void>("edit-bills-page-link") {
			@Override
			public void onClick() {
				setResponsePage(EditBillsPage.class);
			}
		});
		add(new Link<Void>("edit-bank-details-page-link") {
			@Override
			public void onClick() {
				setResponsePage(EditBankDetailsPage.class);
			}
		});
		
		
		
	}
	
}
