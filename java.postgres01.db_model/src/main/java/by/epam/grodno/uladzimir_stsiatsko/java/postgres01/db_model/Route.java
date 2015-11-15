package by.epam.grodno.uladzimir_stsiatsko.java.postgres01.db_model;

public class Route {
	
	private int id;
	private String routeName;
	private String routeType;
	private double priceMultiplier;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getRouteType() {
		return routeType;
	}
	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	public double getPriceMultiplier() {
		return priceMultiplier;
	}
	public void setPriceMultiplier(double priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}
	

}
