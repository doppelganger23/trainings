package by.epam.grodno.uladzimir_stsiatsko.my_web.app;

import javax.inject.Inject;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.grodno.uladzimir_stsiatsko.my_service.AccountService;

public class CustomSession extends AuthenticatedWebSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomSession.class);
	
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
		// необходима проверка?
		if (accService == null) {
			throw new IllegalArgumentException("account service is null");
		}

		Integer id = accService.authenticate(login, password);
		if (id != null) {
			currentuserid = id;
			roles = new Roles();
			roles.add("passenger");
			LOGGER.info("passenger role added");
			LOGGER.info(id.toString());
			if ("admin".equals(accService.getAccessLevel(currentuserid))) {
				roles.add("admin");
				LOGGER.info("admin role added");
			}
			return true;
		}
		LOGGER.info("no roles added");
		return false;
	}

	@Override
	public void signOut() {
		super.signOut();
		currentuserid = null;
		roles = null;
		LOGGER.info("roles deleted");
	}

	@Override
	public Roles getRoles() {
		if (currentuserid == null) {
			LOGGER.info("no roles confirmed");
			return null;
		}
		if (roles == null) {
			roles = new Roles();
			roles.add("passenger");
			LOGGER.info("passenger role confirmed");
			if ("admin".equals(accService.getAccessLevel(currentuserid))) {
				roles.add("admin");
				LOGGER.info("admin role confirmed");
			}
		}
		LOGGER.info("returning roles: " + roles);
		return roles;
	}

	public Integer getCurrentuserid() {
		return currentuserid;
	}

}
