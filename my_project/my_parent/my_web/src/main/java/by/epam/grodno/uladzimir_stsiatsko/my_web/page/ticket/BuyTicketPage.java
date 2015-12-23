package by.epam.grodno.uladzimir_stsiatsko.my_web.page.ticket;

import java.util.Date;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.SearchResult;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

public class BuyTicketPage extends AbstractPage{
	
	@Inject
	private BillService billService;
	@Inject
	private Bill bill;
	
	private SearchResult sResult;

	public BuyTicketPage(SearchResult sResult){
		
		this.sResult = sResult;//for onInitialize()
		bill.setTripListId(sResult.getTripId());
		bill.setFromBlock(sResult.getFromBlock());
		bill.setToBlock(sResult.getToBlock());
		//using 3 fields above to get 4rth value
		bill.setPaymentValue(billService.countPrice(bill));
		//пойдет такой или сменить на лонг | добавить генерацию?
		bill.setBillingNumber(1234567890);
		//заглушка, засетать когда сделаю авторизацию
		bill.setAccountId(1);
		bill.setCreationDate(new Date());
		
	}
	
	@Override
	protected void onInitialize(){
		super.onInitialize();
		
		add(new Label("chosen-route-name", sResult.getRouteName()));
		add(new Label("chosen-route-type", sResult.getRouteType()));
		add(new Label("chosen-train", sResult.getTrain()));
		add(new Label("chosen-from-station", sResult.getFromStation()));
		add(new Label("chosen-departure-date", sResult.getDepartureDate()));
		add(new Label("chosen-to-station", sResult.getToStation()));
		add(new Label("chosen-arrival-date", sResult.getArrivalDate()));
		
		add(new Label("payment-value", bill.getPaymentValue()));
		
		add(new Link("confirm-ticket-link") {
			@Override
			public void onClick() {
				//написать нормальное условие (проверка авторизации)
				if(bill.getTripListId()%2 == 1){
					setResponsePage(new BankDetailsPage(bill));
				} else {
					setResponsePage(new NameInputPage(bill));					
				}
			}
		});
		
	}
	

//	System.out.println(bill.getTripListId());
//	System.out.println(bill.getPaymentValue());
}
