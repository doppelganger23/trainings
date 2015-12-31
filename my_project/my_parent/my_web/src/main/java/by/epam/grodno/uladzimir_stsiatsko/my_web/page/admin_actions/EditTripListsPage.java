package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import java.util.Date;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Route;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Train;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_service.RouteService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TrainService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TripListService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.app.CustomDatePicker;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.HomePage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.renderer.RouteChoiceRenderer;
import by.epam.grodno.uladzimir_stsiatsko.my_web.renderer.TrainChoiceRenderer;

@AuthorizeAction(action=Action.RENDER, roles={"admin"})
public class EditTripListsPage extends AbstractPage {

	@Inject
	TripListService tlService;

	@Inject
	TrainService trainService;

	@Inject
	RouteService routeService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new FeedbackPanel("feedback"));

		final TripList newTripList = new TripList();

		// добавить возможность задавать время, не только дату (поэтому
		// раздельные модели)
		Form<TripList> form = new Form<>("add-trip-list-form");
		add(form);

		final Model<Train> trainModel = new Model<Train>();
		DropDownChoice<Train> trainIdChoice = new DropDownChoice<Train>("train-id-choice", trainModel,
				trainService.findAll(), new TrainChoiceRenderer());
		trainIdChoice.setRequired(true);
		form.add(trainIdChoice);

		final Model<Route> routeModel = new Model<Route>();
		DropDownChoice<Route> routeIdChoice = new DropDownChoice<Route>("route-id-choice", routeModel,
				routeService.findAll(), new RouteChoiceRenderer());
		routeIdChoice.setRequired(true);
		form.add(routeIdChoice);

		// date part, without time yet
		DateTextField dateField = new DateTextField("departure-date",
				new PropertyModel<Date>(newTripList, "departureDate"), new StyleDateConverter("S-", true));
		dateField.add(new CustomDatePicker());
		dateField.setRequired(true);
		form.add(dateField);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
				// добавить проверку маршрутов на совпадение
				newTripList.setTrainId(trainModel.getObject().getId());
				newTripList.setRouteId(routeModel.getObject().getId());
				tlService.addTripList(newTripList);
				setResponsePage(new HomePage());
			}
		});

	}

}
