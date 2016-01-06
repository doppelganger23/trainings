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

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.BillInfo;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillInfoService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

@AuthorizeAction(action=Action.RENDER, roles={"admin"})
public class EditBillsPage extends AbstractPage {
	
	@Inject
	BillInfoService bInfoService;
	
	@Inject
	BillService billService;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		BillInfoDataProvider biDataProvider = new BillInfoDataProvider();
		DataView<BillInfo> dataView = new DataView<BillInfo>("bill-info-list", biDataProvider, 5) {
			@Override
			protected void populateItem(Item<BillInfo> item) {
				final BillInfo bInfo = item.getModelObject();
				item.add(new Label("billId", bInfo.getBillId()));//without using naming conv.
				item.add(new Label("paymentValue"));//and with
				item.add(new Label("currencyOfPayment"));
				item.add(new Label("billingNumber"));
				item.add(new Label("creationDate"));
				item.add(new Label("isPaid"));
				item.add(new Label("firstName"));
				item.add(new Label("lastName"));
				item.add(new Label("email"));
			
				item.add(new Link<Void>("set-paid-link"){
					@Override
					public void onClick() {
						//TODO warning window
						billService.setPaid(bInfo.getBillId(), true);
					}
				});
				
			}			
			
		};
		add(dataView);
				
		add(new OrderByBorder<Object>("sortBillId", "bill_id", biDataProvider));
		add(new OrderByBorder<Object>("sortPaymentValue", "payment_value", biDataProvider));
		add(new OrderByBorder<Object>("sortCurrencyOfPayment", "currency_of_payment", biDataProvider));
		add(new OrderByBorder<Object>("sortBillingNumber", "billing_number", biDataProvider));
		add(new OrderByBorder<Object>("sortCreationDate", "creation_date", biDataProvider));
		add(new OrderByBorder<Object>("sortIsPaid", "is_paid", biDataProvider));
		add(new OrderByBorder<Object>("sortFirstName", "first_name", biDataProvider));
		add(new OrderByBorder<Object>("sortLastName", "last_name", biDataProvider));
		add(new OrderByBorder<Object>("sortEmail", "email", biDataProvider));
		
		add(new PagingNavigator("paging", dataView));
		
	}

	private class BillInfoDataProvider extends SortableDataProvider<BillInfo, Object> {

		public BillInfoDataProvider() {
			super();
			setSort("bill_id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends BillInfo> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return bInfoService.getAll(first, count, (String)sort.getProperty(), currentSort.name()).iterator();
		}

		@Override
		public long size() {
			return bInfoService.getCount();
		}

		@Override
		public IModel<BillInfo> model(BillInfo object) {
			return new CompoundPropertyModel<>(object);
		}

	}
	
}
