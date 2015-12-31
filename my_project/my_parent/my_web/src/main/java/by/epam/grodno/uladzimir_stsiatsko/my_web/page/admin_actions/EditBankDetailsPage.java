package by.epam.grodno.uladzimir_stsiatsko.my_web.page.admin_actions;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;

import by.epam.grodno.uladzimir_stsiatsko.my_web.page.AbstractPage;

@AuthorizeAction(action=Action.RENDER, roles={"admin"})
public class EditBankDetailsPage extends AbstractPage{

}
