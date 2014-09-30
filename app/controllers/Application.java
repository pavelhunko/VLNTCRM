package controllers;

import models.Contact;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {
	final static Form<User> userForm = Form.form(User.class);
	 

	public static Result index() {
		User user = new User((long) 011014, "nicolatesla@nt.com", "Nicola", "Tesla", "secret");
		
		Contact newContact = new Contact();
		newContact.firstName = "Ada";
		newContact.lastName = "Lovelace";
		newContact.email = "ada@lvl.ad";
		newContact.companyName = "Algo Inc.";
		newContact.phone = "1 600 900";
		newContact.streetAddress = "12, Pacivic ave, Atl City, NJ";
		newContact.id = (long) 41114; //random number from my head
		newContact.user = user;
		
		user.save();
		newContact.save();
		return ok(views.html.index.render(userForm));
	}
}
