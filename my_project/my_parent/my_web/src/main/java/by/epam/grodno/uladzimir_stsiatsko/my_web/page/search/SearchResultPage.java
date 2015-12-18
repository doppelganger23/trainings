package by.epam.grodno.uladzimir_stsiatsko.my_web.page.search;

import java.util.Iterator;
import java.util.List;

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

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.SearchResult;
import by.epam.grodno.uladzimir_stsiatsko.my_service.SearchResultService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.ticket.BuyTicketPage;

public class SearchResultPage extends AbstractPage{
	
	@Inject
	private SearchResultService srService;
	
	private List<SearchResult> resultSet;
	
	public SearchResultPage(List<SearchResult> resultSet){
		this.resultSet = resultSet;
	}

	@Override
	protected void onInitialize(){
		super.onInitialize();
		
		SearchResultDataProvider srDataProvider = new SearchResultDataProvider();
		DataView<SearchResult> dataView = new DataView<SearchResult>("search-results-list", srDataProvider, 3) {
			@Override
			protected void populateItem(Item<SearchResult> item) {
				final SearchResult sResult = item.getModelObject();
				item.add(new Label("route-name", sResult.getRouteName()));
				item.add(new Label("route-type", sResult.getRouteType()));
				item.add(new Label("train", sResult.getTrain()));
				item.add(new Label("from-station", sResult.getFromStation()));
				item.add(new Label("departure-date", sResult.getDepartureDate()));
				item.add(new Label("to-station", sResult.getToStation()));
				item.add(new Label("arrival-date", sResult.getArrivalDate()));			

				item.add(new Link("buy-ticket-link") {
					@Override
					public void onClick() {
						setResponsePage(new BuyTicketPage(sResult));
					}
				});
			}
			
		};
		add(dataView);
		add(new OrderByBorder<Object>("sort-from-station", "fromStation", srDataProvider));
		add(new OrderByBorder<Object>("sort-to-station", "toStation", srDataProvider));

		add(new PagingNavigator("paging", dataView));
		
//		ListView<SearchResult> listView = new ListView<SearchResult>("search-results-list", resultSet) {
//			@Override
//			protected void populateItem(ListItem<SearchResult> item) {
//				final SearchResult sResult = item.getModelObject();
//				item.add(new Label("route-name", sResult.getRouteName()));
//				item.add(new Label("route-type", sResult.getRouteType()));
//				item.add(new Label("train", sResult.getTrain()));
//				item.add(new Label("from-station", sResult.getFromStation()));
//				item.add(new Label("departure-date", sResult.getDepartureDate()));
//				item.add(new Label("to-station", sResult.getToStation()));
//				item.add(new Label("arrival-date", sResult.getArrivalDate()));			
//
//				item.add(new Link("buy-ticket-link") {
//					@Override
//					public void onClick() {
//						setResponsePage(new BuyTicketPage(sResult));
//					}
//				});
//			}
//			
//		};
//		add(listView);
	
	}
	
	private class SearchResultDataProvider extends SortableDataProvider<SearchResult, Object> {

		public SearchResultDataProvider() {
			super();
			setSort("id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends SearchResult> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			System.out.println(sort.getProperty() + ":" + currentSort.name());
			// TODO sort in service
			return srService.getAll(first, count).iterator();
		}

		@Override
		public long size() {
			return srService.getCount();
		}

		@Override
		public IModel<SearchResult> model(SearchResult srObject) {
			return new CompoundPropertyModel<>(srObject);
		}

	}
	
}
