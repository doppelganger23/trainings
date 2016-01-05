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
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Train;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TrainService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.TripListService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions.update.UpdateTrainPage;

@AuthorizeAction(action = Action.RENDER, roles = { "admin" })
public class EditTrainsPage extends AbstractPage {

	@Inject
	TripListService tlService;
	
	@Inject
	TrainService tService;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new FeedbackPanel("feedback"));

		final Train newTrain = new Train();
		Form<Train> newTrainForm = new Form<>("new-train-form");
		add(newTrainForm);

		TextField<String> trainNumberField = new TextField<String>("train-number",
				new PropertyModel<String>(newTrain, "trainNumber"));
		trainNumberField.setRequired(true);
		trainNumberField.add(StringValidator.maximumLength(10));
		newTrainForm.add(trainNumberField);

		NumberTextField<Integer> passengersCapacityField = new NumberTextField<Integer>("passengers-capacity",
				new PropertyModel<Integer>(newTrain, "passengersCapacity"));
		passengersCapacityField.setRequired(true);
		newTrainForm.add(passengersCapacityField);

		newTrainForm.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
				if (tService.containsTrain(newTrain.getTrainNumber())) {
					error(getString("error.trainExists"));
				} else {
					tService.addTrain(newTrain);
					setResponsePage(new EditTrainsPage());
				}
			}
		});

		TrainsDataProvider tDataProvider = new TrainsDataProvider();
		DataView<Train> dataView = new DataView<Train>("train-list", tDataProvider, 5) {
			@Override
			protected void populateItem(Item<Train> item) {
				final Train train = item.getModelObject();

				item.add(new Label("id"));
				item.add(new Label("trainNumber"));
				item.add(new Label("passengersCapacity"));

				Link<Void> deleteLink = new Link<Void>("delete-train-link") {
					@Override
					public void onClick() {
						tService.deleteTrain(train.getId());
						setResponsePage(new EditTrainsPage());
					}
				};
				if(tlService.containsTrain(train.getId())){
					deleteLink.setVisible(false);
				}
				item.add(deleteLink);
				
				Link<Void> editLink = new Link<Void>("edit-train-link"){
					@Override
					public void onClick() {
						setResponsePage(new UpdateTrainPage(train));
					}
				};
				item.add(editLink);
			}
		};
		add(dataView);

		add(new OrderByBorder<Object>("sortId", "id", tDataProvider));
		add(new OrderByBorder<Object>("sortTrainNumber", "train_number", tDataProvider));
		add(new OrderByBorder<Object>("sortPassengersCapacity", "passengers_capacity", tDataProvider));

		add(new PagingNavigator("paging", dataView));

	}

	private class TrainsDataProvider extends SortableDataProvider<Train, Object> {

		public TrainsDataProvider() {
			super();
			setSort("id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Train> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return tService.getAll(first, count, (String) sort.getProperty(), currentSort.name()).iterator();
		}

		@Override
		public long size() {
			return tService.getCount();
		}

		@Override
		public IModel<Train> model(Train object) {
			return new CompoundPropertyModel<>(object);
		}

	}

}
