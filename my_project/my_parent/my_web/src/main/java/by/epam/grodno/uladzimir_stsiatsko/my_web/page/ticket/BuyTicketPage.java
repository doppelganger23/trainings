package by.epam.grodno.uladzimir_stsiatsko.my_web.page.ticket;

import java.util.Date;

import javax.inject.Inject;

import org.apache.wicket.MetaDataKey;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.SearchResult;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BankDetailService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.app.CustomSession;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

public class BuyTicketPage extends AbstractPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(BuyTicketPage.class);
	
	public static MetaDataKey<BillMetaData> CURRENCY = new MetaDataKey<BillMetaData>() {
	};

	@Inject
	private BankDetailService bdService;
	@Inject
	private BillService billService;
	@Inject
	private Bill bill;
	
	private String displayedCurrency;
	private double displayedValue;

	private SearchResult sResult;
	private Integer currentuserid;

	public BuyTicketPage(SearchResult sResult) {
		this.sResult = sResult;// for onInitialize()

		bill.setTripListId(sResult.getTripId());
		bill.setFromBlock(sResult.getFromBlock());
		bill.setToBlock(sResult.getToBlock());
		// using 3 fields above to get 4rth value
		bill.setPaymentValue(billService.countPrice(bill));

		currentuserid = CustomSession.get().getCurrentuserid();
		if (currentuserid == null) {
			currentuserid = 0;
		}
		bill.setAccountId(currentuserid);
		LOGGER.debug("setting account id to " + currentuserid);

		bill.setCreationDate(new Date());
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Label("chosen-route-name", sResult.getRouteName()));
		add(new Label("chosen-route-type", sResult.getRouteType()));
		add(new Label("chosen-train", sResult.getTrain()));
		add(new Label("chosen-from-station", sResult.getFromStation()));
		add(new Label("chosen-departure-date", sResult.getDepartureDate()));
		add(new Label("chosen-to-station", sResult.getToStation()));
		add(new Label("chosen-arrival-date", sResult.getArrivalDate()));

		Form<Void> form = new Form<Void>("confirmation-form");

		BillMetaData metaBill = getSession().getMetaData(CURRENCY);
		if (metaBill == null){
			LOGGER.info("metadata is null");
			displayedCurrency = "BYR";
			displayedValue = bill.getPaymentValue();
		} else {
			LOGGER.info("metadata is not null");
			displayedCurrency = metaBill.getCurrency();
			displayedValue = bill.getPaymentValue() * bdService.getByrExchangeRate(displayedCurrency);
		}
		
		form.add(new Label("payment-value", displayedValue));
		final Model<String> currencyModel = new Model<>(displayedCurrency);

		final DropDownChoice<String> currencyChoice = new DropDownChoice<String>("currency-type", currencyModel, bdService.findAllTypes()){
            @Override
            protected void onSelectionChanged(final String newCurrency) {
            	LOGGER.info("It's " + newCurrency + " time!");
				getSession().setMetaData(CURRENCY,
						new BillMetaData(newCurrency));
				setResponsePage(new BuyTicketPage(sResult));
            }
            @Override
            protected boolean wantOnSelectionChangedNotifications() {
                return true;
            }
        };;
        //<<<AJAX GO HERE
		form.add(currencyChoice);
		
		SubmitLink submitLink = new SubmitLink("confirm-ticket-link") {
			@Override
			public void onSubmit() {
				bill.setBillingNumber(bdService.getBillingNumber(displayedCurrency));
				bill.setCurrencyOfPayment(displayedCurrency);
				bill.setPaymentValue(displayedValue);
				
				if (currentuserid != 0) {
					setResponsePage(new BankDetailsPage(bill));
				} else {
					setResponsePage(new NameInputPage(bill));
				}
			}
		};
		form.add(submitLink);
		add(form);
		
//		---AJAX
//		currencyChoice.add(new AjaxEventBehavior("change"){
//			@Override
//			protected void onEvent(AjaxRequestTarget target) {
//				String newCurrency = currencyModel.getObject();
//				LOGGER.info("setting currency to " + newCurrency);
//				defCurrency = newCurrency;
//				target.add(currencyChoice);
//			}
//		});
		
//		AjaxSubmitLink ajaxSubmitLink = new AjaxSubmitLink("calculate-link"){
//			@Override
//			public void onSubmit(AjaxRequestTarget target, Form<?> form) {
//				String newCurrency = currencyModel.getObject();
//				LOGGER.info("setting currency to " + newCurrency);
//				defCurrency = newCurrency;
//				target.add(currencyChoice);
//			}
//		};
//		ajaxSubmitLink.
//		form.add(ajaxSubmitLink);

	}

}
