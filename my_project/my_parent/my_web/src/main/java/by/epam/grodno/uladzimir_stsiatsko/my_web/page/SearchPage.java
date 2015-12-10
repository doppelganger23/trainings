package by.epam.grodno.uladzimir_stsiatsko.my_web.page;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;

public class SearchPage extends AbstractPage {

	private Request request = new Request();

	public SearchPage() {

//		add(new FeedbackPanel("feedback"));

		final TextField<String> departureStation = new TextField<String>("departure-station",
				new PropertyModel<String>(request, "departureStation"));

		final TextField<Integer> destinationStation = new TextField<Integer>("destination-station",
				new PropertyModel<Integer>(request, "destinationStation"));

		Form<?> form = new Form<Void>("search-form") {
			// @Override
			// protected void onSubmit() {
			//
			// PageParameters pageParameters = new PageParameters();
			// pageParameters.add("departureStation",
			// request.getDepartureStation());
			// pageParameters.add("destinationStation",
			// request.getDestinationStation());
			//
			// setResponsePage(HomePage.class, pageParameters);
			//
			// }
		};

		add(form);
		form.add(departureStation);
		form.add(destinationStation);
	}

}
