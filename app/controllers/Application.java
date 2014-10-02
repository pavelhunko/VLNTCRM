package controllers;

import models.Contact;
import models.User;
import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.*;
import views.html.*;

public class Application extends Controller {

    static Form<User> userForm = Form.form(User.class);

    public static Result index() {

	User user = new User(null, "nicolatesla@nt.com", "Nicola", "Tesla", "secret");
	Contact newContact = new Contact((long) 41114, "Ada", "Lovelace", "ada@lvl.ad", "Algo Inc.", "1 600 900",
		"12, Pacivic ave, Atl City, NJ");
	newContact.user = user;
	newContact.save();
	user.create(user);
	/*
	 * newContact.firstName = "Ada"; newContact.lastName = "Lovelace";
	 * newContact.email = "ada@lvl.ad"; newContact.companyName =
	 * "Algo Inc."; newContact.phone = "1 600 900"; newContact.streetAddress
	 * = "12, Pacivic ave, Atl City, NJ"; newContact.id = (long) 41114; //
	 * random number from my head
	 */

	return ok(views.html.index.render(userForm));
    }

    /*
     * public static class Login {
     * 
     * public String email; public String password;
     * 
     * public String validate() { if (User.authenticate(email, password) ==
     * null) { return "Invalid user or password"; } return null; }
     * 
     * }
     */

    public static Result authenticate() {
	Form<User> userLoginForm = Form.form(User.class).bindFromRequest();
	if (userLoginForm.hasErrors()) {
	    return badRequest(login.render(userLoginForm));
	} else {
	    session().clear();
	    session("email", userLoginForm.get().email);
	    return redirect(routes.Application.index());
	}
    }

    public static Result login() {
	return ok(login.render(Form.form(User.class)));
    }

}
