package by.epam.grodno.uladzimir_stsiatsko.my_web.page.ticket;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;
import by.epam.grodno.uladzimir_stsiatsko.my_web.app.CustomSession;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.registration.RegistrationPage;

public class NameInputPage extends AbstractPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(NameInputPage.class);

	// нужна айдишка

	// нужна проверка валидности логина

	// нужен заполненный счет для передачи дальше
	private Bill bill;

	public NameInputPage(Bill bill) {
		this.bill = bill;
	}

	protected void onInitialize() {
		super.onInitialize();
		add(new FeedbackPanel("feedback"));

		Form<Void> form = new Form<Void>("login-form");
		final Model<String> loginModel = new Model<>(null);
		final Model<String> passModel = new Model<>(null);
		TextField<String> loginTf = new TextField<String>("login", loginModel);
		TextField<String> passTf = new PasswordTextField("password", passModel);
		form.add(loginTf);
		form.add(passTf);
		add(form);

		form.add(new SubmitLink("submit") {
			@Override
			public void onSubmit() {
				super.onSubmit();

				boolean isSuccess = CustomSession.get().signIn(loginModel.getObject(), passModel.getObject());

				if (isSuccess) {
					bill.setAccountId(CustomSession.get().getCurrentuserid());
					LOGGER.debug("bill account_id is set to " + CustomSession.get().getCurrentuserid());
					setResponsePage(new BankDetailsPage(bill));
				} else {
					error("login error");
					setResponsePage(getPage());
				}
			}
		});

		add(new Link<Void>("register") {
			@Override
			public void onClick() {
				setResponsePage(new RegistrationPage());
			}
		});
	}

}
