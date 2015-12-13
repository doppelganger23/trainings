package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import java.util.Date;

import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_web.CustomDatePicker;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.HomePage;

public class EditTripListsPage extends AbstractPage {
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		final TripList newTripList = new TripList();

		// добавить возможность задавать время, не только дату (поэтому раздельные модели)
		Form<TripList> form = new Form<>("add-trip-list-form");
		add(form);
		form.add(new TextField<Integer>("train-id", new PropertyModel<Integer>(newTripList, "trainId")));
		form.add(new TextField<Integer>("route-id", new PropertyModel<Integer>(newTripList, "routeId")));
		//date part, without time
//		form.add(new DateTextField("departureDate", new StyleDateConverter("S-", true)).add(new CustomDatePicker()));
		form.add(new DateTextField("departure-date", new PropertyModel<Date>(newTripList, "departureDate"), new StyleDateConverter(
						"S-", true)).add(new CustomDatePicker()));	
		
		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
		//TODO
			setResponsePage(new HomePage());
			}
		});

	}

}
