package by.epam.grodno.uladzimir_stsiatsko.my_web.page;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

@AuthorizeInstantiation(value = { "admin" })
public class UsersPage extends AbstractPage {

}
