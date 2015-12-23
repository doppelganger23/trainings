package by.epam.grodno.uladzimir_stsiatsko.my_web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions.AdminActionsPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.registration.RegistrationPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.search.SearchPage;

public class AbstractPage extends WebPage {

	public AbstractPage() {
		add(new Link<Void>("home-page-link") {
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
		add(new Link<Void>("example-page-link") {
			@Override
			public void onClick() {
				setResponsePage(ExamplePage.class);
			}
		});
		add(new Link<Void>("search-page-link") {
			@Override
			public void onClick() {
				setResponsePage(SearchPage.class);
			}
		});
		add(new Link<Void>("admin-actions-page-link") {
			@Override
			public void onClick() {
				setResponsePage(AdminActionsPage.class);
			}
		});
		add(new Link<Void>("registration-page-link") {
			@Override
			public void onClick() {
				setResponsePage(RegistrationPage.class);
			}
		});
		add(new Link<Void>("log-in-page-link") {
			@Override
			public void onClick() {
				setResponsePage(LogInPage.class);
			}
		});
		add(new Link<Void>("users-page-link") {
			@Override
			public void onClick() {
				setResponsePage(UsersPage.class);
			}
		});
		
	}
}
