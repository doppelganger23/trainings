package by.epam.grodno.uladzimir_stsiatsko.my_dao.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RouteMap implements Serializable {
	
	private int id;
	private int routeId;
	private int stationToStationBlockId;
	private int blockNumberInRoute;
	//разбить на два и поправить формат
	private Timestamp timeSinceDeparture;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getBlockNumberInRoute() {
		return blockNumberInRoute;
	}
	public void setBlockNumberInRoute(int blockNumberInRoute) {
		this.blockNumberInRoute = blockNumberInRoute;
	}
	public int getStationToStationBlockId() {
		return stationToStationBlockId;
	}
	public void setStationToStationBlockId(int stationToStationBlockId) {
		this.stationToStationBlockId = stationToStationBlockId;
	}
	public Timestamp getTimeSinceDeparture() {
		return timeSinceDeparture;
	}
	public void setTimeSinceDeparture(Timestamp timeSinceDeparture) {
		this.timeSinceDeparture = timeSinceDeparture;
	}
	
}
