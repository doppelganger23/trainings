package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import java.util.Date;
import java.util.Iterator;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Route;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Train;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripListInfo;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.RouteService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TrainService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TripListInfoService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TripListService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.app.CustomDatePicker;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.renderer.RouteChoiceRenderer;
import by.epam.grodno.uladzimir_stsiatsko.my_web.renderer.TrainChoiceRenderer;

@AuthorizeAction(action=Action.RENDER, roles={"admin"})
public class EditTripListsPage extends AbstractPage {
	
	@Inject
	BillService bService;
	
	@Inject
	TripListInfoService tlInfoService;

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
				setResponsePage(new EditTripListsPage());
			}
		});
		
		TripListInfoDataProvider tliDataProvider = new TripListInfoDataProvider();
		DataView<TripListInfo> dataView = new DataView<TripListInfo>("trip-list-info-list", tliDataProvider, 5){
			@Override
			protected void populateItem(Item<TripListInfo> item){	
				final TripListInfo tlInfo = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("trainNumber"));
				item.add(new Label("routeType"));
				item.add(new Label("routeName"));
				item.add(new Label("departureDate"));
				item.add(new Label("ticketsSold"));
				
				Link<Void> deleteLink = new Link<Void>("delete-trip-list-link"){
					@Override
					public void onClick(){
							tlService.deleteTripList(tlInfo.getId());
					}
				};
				item.add(deleteLink);
				if(bService.containsBill(tlInfo.getId())){
					deleteLink.setVisible(false);
				}
			}
		};
		add(dataView);
		
		add(new OrderByBorder<Object>("sortId", "id", tliDataProvider));
		add(new OrderByBorder<Object>("sortTrainNumber", "train_number", tliDataProvider));
		add(new OrderByBorder<Object>("sortRouteType", "route_type", tliDataProvider));
		add(new OrderByBorder<Object>("sortRouteName", "route_name", tliDataProvider));
		add(new OrderByBorder<Object>("sortDepartureDate", "departure_date", tliDataProvider));
		add(new OrderByBorder<Object>("sortTicketsSold", "tickets_sold", tliDataProvider));
		
		add(new PagingNavigator("paging", dataView));
	}

	private class TripListInfoDataProvider extends SortableDataProvider<TripListInfo, Object> {

		public TripListInfoDataProvider() {
			super();
			setSort("id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends TripListInfo> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return tlInfoService.getAll(first, count, (String)sort.getProperty(), currentSort.name()).iterator();
		}

		@Override
		public long size() {
			return tlInfoService.getCount();
		}

		@Override
		public IModel<TripListInfo> model(TripListInfo object) {
			return new CompoundPropertyModel<>(object);
		}

	}
	
}
