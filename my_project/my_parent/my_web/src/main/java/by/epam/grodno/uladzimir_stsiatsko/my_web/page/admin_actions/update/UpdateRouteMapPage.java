package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions.update;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.Route;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.RouteMap;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.StationToStationBlock;
import by.epam.grodno.uladzimir_stsiatsko.my_dao.model.TripList;
import by.epam.grodno.uladzimir_stsiatsko.my_service.RouteService;
import by.epam.grodno.uladzimir_stsiatsko.my_service.StationToStationBlockService;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions.EditRoutesPage;
import by.epam.grodno.uladzimir_stsiatsko.my_web.renderer.StationToStationBlockChoiceRenderer;

@AuthorizeAction(action=Action.RENDER, roles={"admin"})
public class UpdateRouteMapPage extends AbstractPage{
	private static final Logger LOGGER = LoggerFactory.getLogger(EditRoutesPage.class);
	
	private Route route;
	private RouteMap rMap = new RouteMap();
	
	@Inject
	RouteService rService;
	
	@Inject
	StationToStationBlockService blockService;
	
	public UpdateRouteMapPage(int routeId){
		this.route = rService.getById(routeId);
		LOGGER.debug("received route " + route.getRouteName());
		
		rMap.setRouteId(routeId);
	}
	
	protected void onInitialize(){
		super.onInitialize();
		add(new FeedbackPanel("feedback"));
		
		Form<TripList> form = new Form<>("form");
		add(form);

		final Model<StationToStationBlock> blockModel = new Model<StationToStationBlock>();
		DropDownChoice<StationToStationBlock> blockIdChoice = new DropDownChoice<StationToStationBlock>("block-id-choice", blockModel,
				blockService.getBlocks(), new StationToStationBlockChoiceRenderer());
		blockIdChoice.setRequired(true);
		form.add(blockIdChoice);
		
		
	}
	
	

}
