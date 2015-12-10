package by.epam.grodno.uladzimir_stsiatsko.my_web.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

public class ExamplePage extends AbstractPage {
	
    private String message = "[type your message to the world here]";

    public ExamplePage() {
        // This model references the page's message property and is
        // shared by the label and form component
        PropertyModel<String> messageModel = new PropertyModel<String>(this, "message");

        // The label displays the currently set message
        add(new Label("msg", messageModel));

        // Add a form to change the message. We don't need to do anything
        // else with this form as the shared model is automatically updated
        // on form submits
        Form<?> form = new Form("form");
        form.add(new TextField<String>("msgInput", messageModel));
        add(form);
        
        add(new Label("msg2", messageModel));
        Form<?> form2 = new Form("form2");
        form2.add(new TextField<String>("msgInput2", messageModel));
        add(form2);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}