package by.epam.grodno.uladzimir_stsiatsko.my_web.page.search;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Request;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.SearchResult;
import by.epam.grodno.uladzimir_stsiatsko.my_service.SearchResultService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.CustomDatePicker;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

public class SearchPage extends AbstractPage {

	@Inject
	private SearchResultService srService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new FeedbackPanel("feedback"));
		
		final Request newRequest = new Request();
		Form<Request> form = new Form<>("request-form", new CompoundPropertyModel<>(newRequest));
		add(form);

		TextField<String> departureStationField = new TextField<String>("departureStation");
		departureStationField.setRequired(true);
		departureStationField.add(StringValidator.maximumLength(50));
		form.add(departureStationField);
		
		TextField<String> destinationStationField = new TextField<String>("destinationStation");
		destinationStationField.setRequired(true);
		destinationStationField.add(StringValidator.maximumLength(50));
		form.add(destinationStationField);
		
		
		form.add(new DateTextField("departureDate", new StyleDateConverter("S-", true)).add(new CustomDatePicker()));
		form.add(new DateTextField("arrivalDate", new StyleDateConverter("S-", true)).add(new CustomDatePicker()));
		form.add(new DropDownChoice<String>("depCondition", Arrays.asList(">=", "<=")));
		form.add(new DropDownChoice<String>("arrCondition", Arrays.asList("<=", ">=")));

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {

				List<SearchResult> resultSet = srService.find(newRequest);

				resultSet.forEach(new Consumer<SearchResult>() {
					@Override
					public void accept(SearchResult e) {
						System.out.println("----------------");
						System.out.println(e.getTripId());
						System.out.println(e.getRouteName());
						System.out.println(e.getRouteType());
						System.out.println(e.getTrain());
						System.out.println(e.getFromStation());
						System.out.println(e.getFromBlock());
						System.out.println(e.getDepartureDate());
						System.out.println(e.getToStation());
						System.out.println(e.getToBlock());
						System.out.println(e.getArrivalDate());
						System.out.println(e.getPlaces());
						System.out.println(e.getSold());
						System.out.println(e.getKmPrice());
						System.out.println(e.getKm());
					}
				});

				setResponsePage(new SearchResultPage(resultSet));
			}
		});

	}

}
