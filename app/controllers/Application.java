package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    static Form<User> registerUserForm = Form.form(User.class);

    public static Result index() {
	return ok(views.html.index.render(registerUserForm));
    }

    public static Result register() {
	return ok(views.html.register.render(registerUserForm));
    }

    public static Result newUser() {
	Form<User> filledForm = registerUserForm.bindFromRequest();
	if (filledForm.hasErrors()) {
	    return redirect(routes.Application.index());
	} else {
	    User.create(filledForm.get());
	    // return redirect(routes.Application.show(filledForm.get().id));
	    return redirect(routes.Application.index());
	}
    }
    
}
