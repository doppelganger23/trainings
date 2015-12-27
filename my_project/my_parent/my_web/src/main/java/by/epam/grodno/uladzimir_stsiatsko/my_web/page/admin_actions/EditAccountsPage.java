package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
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

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Account;
import by.epam.grodno.uladzimir_stsiatsko.my_service.AccountService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

@AuthorizeAction(action=Action.RENDER, roles={"admin"})
public class EditAccountsPage extends AbstractPage {

	@Inject
	AccountService aService;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		AccountsDataProvider accsDataProvider = new AccountsDataProvider();
		DataView<Account> dataView = new DataView<Account>("accounts-list", accsDataProvider, 5) {
			@Override
			protected void populateItem(Item<Account> item) {
				final Account acc = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("login"));
				item.add(new Label("firstName"));
				item.add(new Label("lName", acc.getLastName())); //так без нейминг-конвенции
				item.add(new Label("email"));
				item.add(new Label("accessLevel"));

				item.add(new Link<Void>("delete-link") {
					@Override
					public void onClick() {
						//дописать ворнинг месседж
						aService.delete(acc);
					}
				});
				
				item.add(new Link<Void>("edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new UpdateAccountPage(acc));
					}
				});

			}
		};
		add(dataView);

		add(new OrderByBorder<Object>("sortId", "sort-by-id", accsDataProvider));
		add(new OrderByBorder<Object>("sortLogin", "sort-by-login", accsDataProvider));
		add(new OrderByBorder<Object>("sortFirstName", "sort-by-first-name", accsDataProvider));
		add(new OrderByBorder<Object>("sortlName", "sort-by-last-name", accsDataProvider));
		add(new OrderByBorder<Object>("sortEmail", "sort-by-email", accsDataProvider));
		add(new OrderByBorder<Object>("sortAccessLevel", "sort-by-access-level", accsDataProvider));
		
		add(new PagingNavigator("paging", dataView));

	}

	private class AccountsDataProvider extends SortableDataProvider<Account, Object> {

		public AccountsDataProvider() {
			super();
			setSort("sort-by-id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Account> iterator(long first, long count) {

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
		public IModel<Account> model(Account object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}
