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

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Administrator;
import by.epam.grodno.uladzimir_stsiatsko.my_service.AdministratorService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

public class EditAccountsPage extends AbstractPage {

	@Inject
	AdministratorService aService;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		AdministratorsDataProvider adminsDataProvider = new AdministratorsDataProvider();
		DataView<Administrator> dataView = new DataView<Administrator>("accounts-list", adminsDataProvider, 5) {
			@Override
			protected void populateItem(Item<Administrator> item) {
				final Administrator admin = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("login"));
				item.add(new Label("firstName"));
				item.add(new Label("lName", admin.getLastName())); //так без нейминг-конвенции
				item.add(new Label("email"));
				item.add(new Label("accessLevel"));

				item.add(new Link("delete-link") {
					@Override
					public void onClick() {
						aService.delete(admin);
					}
				});

			}
		};
		add(dataView);

		add(new OrderByBorder<Object>("sortId", "sort-by-id", adminsDataProvider));
		add(new OrderByBorder<Object>("sortLogin", "sort-by-login", adminsDataProvider));
		add(new OrderByBorder<Object>("sortFirstName", "sort-by-first-name", adminsDataProvider));
		add(new OrderByBorder<Object>("sortlName", "sort-by-last-name", adminsDataProvider));
		add(new OrderByBorder<Object>("sortEmail", "sort-by-email", adminsDataProvider));
		add(new OrderByBorder<Object>("sortAccessLevel", "sort-by-access-level", adminsDataProvider));
		
		add(new PagingNavigator("paging", dataView));

	}

	private class AdministratorsDataProvider extends SortableDataProvider<Administrator, Object> {

		public AdministratorsDataProvider() {
			super();
			setSort("sort-by-id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Administrator> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return aService.getAll(first, count, (String)sort.getProperty(), currentSort.name()).iterator();
		}

		@Override
		public long size() {
			return aService.getCount();
		}

		@Override
		public IModel<Administrator> model(Administrator object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}
