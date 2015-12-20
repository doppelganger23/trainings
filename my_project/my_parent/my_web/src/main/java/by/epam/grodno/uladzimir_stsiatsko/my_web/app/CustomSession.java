package by.epam.grodno.uladzimir_stsiatsko.my_web.app;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;

public class CustomSession extends AuthenticatedWebSession {

//	@Inject
//	private UserService userService;

	private Long currentuserid;

	private Roles roles;

	public CustomSession(Request request) {
		super(request);
		Injector.get().inject(this);
	}

	public static CustomSession get() {
		return (CustomSession) Session.get();
	}

	@Override
	protected boolean authenticate(String username, String password) {
//		if (userService == null) {
//			throw new IllegalArgumentException("user service is null");
//		}
		// TODO implement logic with DB

		if ("test".equals(username) && "test".equals(password)) {
			currentuserid = 11l;
			return true;
		} else {
			return false;
		}

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

	public Long getCurrentuserid() {
		return currentuserid;
	}

}
