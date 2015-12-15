package by.epam.grodno.uladzimir_stsiatsko.my_web.page.registration;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_service.PassengerService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.HomePage;

public class PassengerRegistrationPage extends AbstractPage {
	
	@Inject
	PassengerService pService;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new FeedbackPanel("feedback"));
		
		final Passenger newPassenger = new Passenger();
		Form<TripList> form = new Form<>("passenger-registration-form");
		add(form);
		
		TextField<String> firstNameField = new TextField<String>("first-name", new PropertyModel<String>(newPassenger, "firstName"));
		firstNameField.setRequired(true);
		firstNameField.add(StringValidator.maximumLength(50));
		form.add(firstNameField);
		
		TextField<String> lastNameField = new TextField<String>("last-name", new PropertyModel<String>(newPassenger, "lastName"));
		lastNameField.setRequired(true);
		lastNameField.add(StringValidator.maximumLength(50));
		form.add(lastNameField);
		
		form.add(new TextField<String>("passport-number", new PropertyModel<String>(newPassenger, "passportNumber")));
		
		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
			pService.registerPassenger(newPassenger);
			setResponsePage(new HomePage());
			}
		});

	}

}
