package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

public class RouteMap {
	
	private int id;
	private int routeId;
	private int stSBlockId;
	private int blockNumberInRoute;
	private int standTimeInMinutes;
	
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
	public int getStSBlockId() {
		return stSBlockId;
	}
	public void setStSBlockId(int stSBlockId) {
		this.stSBlockId = stSBlockId;
	}
	public int getBlockNumberInRoute() {
		return blockNumberInRoute;
	}
	public void setBlockNumberInRoute(int blockNumberInRoute) {
		this.blockNumberInRoute = blockNumberInRoute;
	}
	public int getStandTimeInMinutes() {
		return standTimeInMinutes;
	}
	public void setStandTimeInMinutes(int standTimeInMinutes) {
		this.standTimeInMinutes = standTimeInMinutes;
	}
	

}
