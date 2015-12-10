package by.epam.grodno.uladzimir_stsiatsko.my_web.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

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
		add(new Link<Void>("passenger-registration-page-link") {
			@Override
			public void onClick() {
				setResponsePage(PassengerRegistrationPage.class);
			}
		});
		add(new Link<Void>("administrator-registration-page-link") {
			@Override
			public void onClick() {
				setResponsePage(AdministratorRegistrationPage.class);
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
