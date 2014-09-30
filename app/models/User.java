package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
import scala.Int;

@Entity
public class User extends Model {

    @Id
    public String email;
    public String firstName;
    public String lastName;
    public String password;

    public User(String email, String firstName, String lastName, String password) {

	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;

    }

    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);

    public static List<User> all() {
	return find.all();
    }

    public static void create(User user) {
	user.save();
    }

    // hash password
    public static User authenticate(String email, String password) {
	return find.where().eq(email, email).eq("password", password).findUnique();
    }
}
