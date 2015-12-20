package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Passenger;
import by.epam.grodno.uladzimir_stsiatsko.my_service.PassengerService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

public class EditPassengersPage extends AbstractPage {

	@Inject
	PassengerService pService;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		PassengersDataProvider passengersDataProvider = new PassengersDataProvider();
		DataView<Passenger> dataView = new DataView<Passenger>("passengers-list", passengersDataProvider, 5) {
			@Override
			protected void populateItem(Item<Passenger> item) {
				final Passenger passenger = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("firstName"));
				item.add(new Label("lName", passenger.getLastName())); //можно и так
				item.add(new Label("passportNumber"));

				item.add(new Link("delete-link") {
					@Override
					public void onClick() {
						pService.delete(passenger);
					}
				});

			}
		};
		add(dataView);

		add(new OrderByBorder<Object>("sortId", "sort-by-id", passengersDataProvider));
		add(new OrderByBorder<Object>("sortfName", "sort-by-first-name", passengersDataProvider));
		add(new OrderByBorder<Object>("sortlName", "sort-by-last-name", passengersDataProvider));
		add(new OrderByBorder<Object>("sortPassport", "sort-by-passport-number", passengersDataProvider));
		
		add(new PagingNavigator("paging", dataView));

	}

	private class PassengersDataProvider extends SortableDataProvider<Passenger, Object> {

		public PassengersDataProvider() {
			super();
			setSort("sort-by-id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Passenger> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return pService.getAll(first, count, (String)sort.getProperty(), currentSort.name()).iterator();
		}

		@Override
		public long size() {
			return pService.getCount();
		}

		@Override
		public IModel<Passenger> model(Passenger object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}
