package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import java.util.Iterator;

import javax.inject.Inject;

import org.apache.wicket.MetaDataKey;
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

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Route;
import by.epam.grodno.uladzimir_stsiatsko.my_service.RouteService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.metadata.ElementsOnPageMetaData;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions.update.UpdateRouteMapPage;

@AuthorizeAction(action=Action.RENDER, roles={"admin"})
public class EditRoutesPage extends AbstractPage {
	
	@Inject
	RouteService rService;
	
	public static MetaDataKey<ElementsOnPageMetaData> ELEMENTS_ON_PAGE = new MetaDataKey<ElementsOnPageMetaData>() {
	};
	private int elementsOnPage = 5;
	
	public EditRoutesPage(){
		ElementsOnPageMetaData meta = getSession().getMetaData(ELEMENTS_ON_PAGE);
		if(meta != null){
			this.elementsOnPage = meta.getElementsOnPage();
		}
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		RoutesDataProvider routesDataProvider = new RoutesDataProvider();
		DataView<Route> dataView = new DataView<Route>("routes-list", routesDataProvider, elementsOnPage) {
			@Override
			protected void populateItem(Item<Route> item) {
				final Route route = item.getModelObject();
				item.add(new Label("id"));
				item.add(new Label("route_name"));
				item.add(new Label("route_type"));
				item.add(new Label("price_for_kilometer"));

				item.add(new Link<Void>("delete-link") {
					@Override
					public void onClick() {
						//дописать ворнинг месседж
						rService.delete(route);
					}
				});
				
				item.add(new Link<Void>("edit-link") {
					@Override
					public void onClick() {
						setResponsePage(new UpdateRouteMapPage(route));
					}
				});

			}
		};
		add(dataView);

		add(new OrderByBorder<Object>("sortId", "id", routesDataProvider));
		add(new OrderByBorder<Object>("sortRouteName", "route_name", routesDataProvider));
		add(new OrderByBorder<Object>("sortRouteType", "route_type", routesDataProvider));
		add(new OrderByBorder<Object>("sortPriceForKilometer", "price_for_kilometer", routesDataProvider));
		
		add(new PagingNavigator("paging", dataView));
		
		add(new Link<Void>("5-elements-link"){
			@Override
			public void onClick(){
				getSession().setMetaData(ELEMENTS_ON_PAGE, new ElementsOnPageMetaData(5));
				setResponsePage(new EditRoutesPage());
			}
		});
		add(new Link<Void>("10-elements-link"){
			@Override
			public void onClick(){
				getSession().setMetaData(ELEMENTS_ON_PAGE, new ElementsOnPageMetaData(10));
				setResponsePage(new EditRoutesPage());
			}
		});
		add(new Link<Void>("20-elements-link"){
			@Override
			public void onClick(){
				getSession().setMetaData(ELEMENTS_ON_PAGE, new ElementsOnPageMetaData(20));
				setResponsePage(new EditRoutesPage());
			}
		});

	}

	private class RoutesDataProvider extends SortableDataProvider<Route, Object> {

		public RoutesDataProvider() {
			super();
			setSort("id", SortOrder.ASCENDING);
		}

		@Override
		public Iterator<? extends Route> iterator(long first, long count) {

			SortParam<Object> sort = getSort();
			ISortState<Object> sortState = getSortState();
			SortOrder currentSort = sortState.getPropertySortOrder(sort.getProperty());

			return rService.getAll(first, count, (String)sort.getProperty(), currentSort.name()).iterator();
		}

		@Override
		public long size() {
			return rService.getCount();
		}

		@Override
		public IModel<Route> model(Route object) {
			return new CompoundPropertyModel<>(object);
		}

	}

	
}
