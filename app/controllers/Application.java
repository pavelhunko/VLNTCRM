package controllers;

import models.Contact;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.data.*;
import views.html.*;
import views.html.login;

public class Application extends Controller {
    
    static Form<User> userForm = Form.form(User.class);
        
    public static Result index() {
	User user = new User(null, "nicolatesla@nt.com", "Nicola", "Tesla", "secret");

	Contact newContact = new Contact();
	newContact.firstName = "Ada";
	newContact.lastName = "Lovelace";
	newContact.email = "ada@lvl.ad";
	newContact.companyName = "Algo Inc.";
	newContact.phone = "1 600 900";
	newContact.streetAddress = "12, Pacivic ave, Atl City, NJ";
	newContact.id = (long) 41114; // random number from my head
	newContact.user = user;
	user.save();
	newContact.save();
	return ok(views.html.index.render(userForm));
    }
    public static class Login {

	    public String email;
	    public String password;

	}
    
    public static Result login() {
	return ok(login.render(Form.form(Login.class)));
    }   

    public static Result authenticate(){
	return (Result) User.authenticate(userForm.get().email, userForm.get().password);
    }
}
