package controllers;

import models.Contact;
import models.User;
import static play.data.Form.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.*;
import views.html.*;
import views.html.login;

public class Application extends Controller {

	static Form<User> userForm = Form.form(User.class);

	public static Result index() {
		User user = new User(null, "nicolatesla@nt.com", "Nicola", "Tesla",
				"secret");

		/*Contact newContact = new Contact();
		newContact.firstName = "Ada";
		newContact.lastName = "Lovelace";
		newContact.email = "ada@lvl.ad";
		newContact.companyName = "Algo Inc.";
		newContact.phone = "1 600 900";
		newContact.streetAddress = "12, Pacivic ave, Atl City, NJ";
		newContact.id = (long) 41114; // random number from my head
		newContact.user = user;
		
		newContact.save();*/
		user.create(user);
		return ok(views.html.index.render(userForm));
	}

	public static class Login {

		public String email;
		public String password;
		
		public String validate() {
		    if (User.authenticate(email, password) == null) {
		      return "Invalid user or password";
		    }
		    return null;
		}

	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
	    Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
	    if (loginForm.hasErrors()) {
	        return badRequest(login.render(loginForm));
	    } else {
	        session().clear();
	        session("email", loginForm.get().email);
	        return redirect(
	            routes.Application.index()
	        );
	    }
	}
	
	/*public static Result authenticate() {
		return (Result) User.authenticate(userForm.get().email,
				userForm.get().password);
	}*/
	
}
