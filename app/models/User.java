package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

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

	// hash password
	public static User authenticate(String _email, String _password) {
		return find.where().eq("email", _email).eq("password", _password)
				.findUnique();
	}

	public String validate() {
		if (User.authenticate(email, password) == null) {
			return "Invalid user or password";
		}
		return null;
	}
}
