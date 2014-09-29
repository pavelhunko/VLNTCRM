package controllers;

import java.util.List;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {
    
    final static Form<User> userForm = Form.form(User.class);
        
    public static Result index() {
	return ok(views.html.index.render(userForm));
    }

}
