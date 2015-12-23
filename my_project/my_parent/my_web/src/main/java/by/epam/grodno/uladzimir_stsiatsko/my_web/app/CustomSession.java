package by.epam.grodno.uladzimir_stsiatsko.my_web.app;

import javax.inject.Inject;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

import by.epam.grodno.uladzimir_stsiatsko.my_service.AccountService;

public class CustomSession extends AuthenticatedWebSession {

	@Inject
	private AccountService accService;

	private Integer currentuserid;

	private Roles roles;

	public CustomSession(Request request) {
		super(request);
		Injector.get().inject(this);
	}

	public static CustomSession get() {
		return (CustomSession) Session.get();
	}

	@Override
	protected boolean authenticate(String login, String password) {
		//необходима проверка?
		if (accService == null) {
			throw new IllegalArgumentException("account service is null");
		}
		
		Integer id = accService.authenticate(login, password);
		if(id != null){
			currentuserid = id;
			roles = new Roles();
			roles.add("admin");
			return true;
		} // else Integer id = passengerService.authenticate(login, password) - TODO
		return false;
	}

	@Override
	public void signOut() {
		super.signOut();
		currentuserid = null;
		roles = null;
	}

	@Override
	public Roles getRoles() {
		if (currentuserid == null) {
			return null;
		}

		if (roles == null) {
			roles = new Roles();
			// TODO add actual list of roles for current logged user
			roles.add("admin");// 'client', 'simple user' etc...
		}
		return roles;
	}

	public Integer getCurrentuserid() {
		return currentuserid;
	}

}
