package by.epam.grodno.uladzimir_stsiatsko.my_web.page.registration;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_service.AdministratorService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.HomePage;

public class AdministratorRegistrationPage extends AbstractPage {

	// TODO обработать ситуацию, когда логин уже есть в базе

	@Inject
	AdministratorService aService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new FeedbackPanel("feedback"));

		final Administrator newAdmin = new Administrator();
		newAdmin.setAccessLevel("passenger");

		Form<TripList> form = new Form<>("administrator-registration-form");
		add(form);
		TextField<String> loginField = new TextField<String>("login", new PropertyModel<String>(newAdmin, "login"));
		loginField.setRequired(true);
		loginField.add(StringValidator.maximumLength(50));
		form.add(loginField);

		// можно добавить второе поле для проверки корректности ввода
		PasswordTextField passwordField = new PasswordTextField("password",
				new PropertyModel<String>(newAdmin, "password"));
		passwordField.setRequired(true);
		passwordField.add(StringValidator.maximumLength(50));
		form.add(passwordField);

		TextField<String> firstNameField = new TextField<String>("first-name",
				new PropertyModel<String>(newAdmin, "firstName"));
		firstNameField.setRequired(true);
		firstNameField.add(StringValidator.maximumLength(50));
		form.add(firstNameField);

		TextField<String> lastNameField = new TextField<String>("last-name",
				new PropertyModel<String>(newAdmin, "lastName"));
		lastNameField.setRequired(true);
		lastNameField.add(StringValidator.maximumLength(50));
		form.add(lastNameField);

		TextField<String> emailField = new TextField<String>("email", new PropertyModel<String>(newAdmin, "email"));
		emailField.setRequired(true);
		emailField.add(StringValidator.maximumLength(50));
		form.add(emailField);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				//TODO - correct 
//				if (aService.getByLogin(newAdmin.getLogin()) != null) {
//					warn("such login already exists");
//				}
//				if (aService.getByLogin(newAdmin.getLogin()) != null) {
//					warn("user with such email already exists");
//				}
//
//				if (aService.getByLogin(newAdmin.getLogin()) == null
//						&& aService.getByLogin(newAdmin.getLogin()) == null) {
					aService.register(newAdmin);
					setResponsePage(new HomePage());
				//}
			}
		});

	}

}
