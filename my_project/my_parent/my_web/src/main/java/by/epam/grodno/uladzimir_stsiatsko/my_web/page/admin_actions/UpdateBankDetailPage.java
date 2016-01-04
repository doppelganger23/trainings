package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.BankDetail;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_service.BankDetailService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

@AuthorizeAction(action = Action.RENDER, roles = { "admin" })
public class UpdateBankDetailPage extends AbstractPage {

	private BankDetail bDetail;
	private String exCurrency;
	private String newCurrency;

	@Inject
	BankDetailService bdService;

	public UpdateBankDetailPage(BankDetail bDetail) {
		this.bDetail = bDetail;
		this.exCurrency = bDetail.getCurrencyOfPayment();
	}

	protected void onInitialize() {
		super.onInitialize();
		add(new FeedbackPanel("feedback"));

		Form<TripList> form = new Form<>("update-form");
		add(form);

		TextField<String> currencyOfPayment = new TextField<String>("currency-of-payment",
				new PropertyModel<String>(bDetail, "currencyOfPayment"));
		currencyOfPayment.setRequired(true);
		currencyOfPayment.add(StringValidator.exactLength(3));
		form.add(currencyOfPayment);
		
		Label currencyLabel = new Label("currency-label", exCurrency);
		currencyLabel.setVisible(false);
		form.add(currencyLabel);
		if(exCurrency.equalsIgnoreCase("BYR")){
			currencyOfPayment.setVisible(false);
			currencyLabel.setVisible(true);
		}

		NumberTextField<Integer> billingNumber = new NumberTextField<Integer>("billing-number",
				new PropertyModel<Integer>(bDetail, "billingNumber"));
		billingNumber.setRequired(true);
		form.add(billingNumber);

		NumberTextField<Double> byrExchangeRate = new NumberTextField<Double>("byr-exchange-rate",
				new PropertyModel<Double>(bDetail, "byrExchangeRate"));
		byrExchangeRate.setRequired(true);
		form.add(byrExchangeRate);

		form.add(new SubmitLink("submit-update") {
			@Override
			public void onSubmit() {
				newCurrency = bDetail.getCurrencyOfPayment().toUpperCase();
				bDetail.setCurrencyOfPayment(newCurrency);
				
				if (exCurrency.equals(newCurrency)) {
					bdService.updateBankDetail(bDetail);
					setResponsePage(new EditBankDetailsPage());
				} else {
					bdService.deleteBankDetail(exCurrency);
					bdService.addBankDetail(bDetail);
					setResponsePage(new EditBankDetailsPage());
				}
			}
		});

	}

}
