package by.epam.grodno.uladzimir_stsiatsko.my_web.page.ticket;

import javax.inject.Inject;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Bill;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BillService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

@AuthorizeInstantiation(value = { "admin", "passenger" })
public class BankDetailsPage extends AbstractPage{
	
	@Inject
	private BillService billService;
	
	private Bill bill;
	
	public BankDetailsPage(Bill bill){
		this.bill = bill;
	}
	
	@Override
	protected void onInitialize(){
		super.onInitialize();
		
		add(new Label("billing-number", bill.getBillingNumber()));
		add(new Label("payment-value", bill.getPaymentValue() + " " + bill.getCurrencyOfPayment()));
		
		billService.addBill(bill);
		
		//TODO add service and dao methods etc.
		//add(new Label(""), tlService.getById(bill.getTripListId()).getName);
	}

}
