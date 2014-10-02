package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import controllers.routes;
//import controllers.Application.Login;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.mvc.Result;
import views.html.login;

@Entity
public class User extends Model {

	@Id
	public Long id;
	public String firstName;
	public String lastName;
	@Required
	public String email;
	public String password;

	public User(Long id, String email, String firstName, String lastName,
			String password) {

		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;

	}

	public static Finder<Long, User> findByID = new Finder<Long, User>(
			Long.class, User.class);
	public static Finder<String, User> find = new Finder<String, User>(
			String.class, User.class);

	public static List<User> all() {
		return find.all();
	}

	public static void create(User user) {
		user.save();
	}

	public static User authenticate(String email, String password) {
	        return find.where().eq("email", email)
	            .eq("password", password).findUnique();
	    }
	public String validate() {
	        if (authenticate(email, password) == null) {
	            return "Invalid email or password";
	        }
	        return null;
	    }

	
}
