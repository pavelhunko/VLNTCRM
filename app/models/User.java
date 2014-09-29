package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class User extends Model {

    @Id
    public String email;
    public String name;
    public String phone;
    public String companyName;
    public String streetAddress;
    public String password;

    public User(String email, String name, String password, String phone, String companyName, String streetAddress) {
	this.email = email;
	this.name = name;
	this.password = password;
	this.phone = phone;
	this.companyName = companyName;
	this.streetAddress = streetAddress;
    }

    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);
    
    public static List<User> all(){
	return find.all();
    }
    
    public static void create(User user){
	user.save();
    }
    
    //hash password
    public static User authenticate(String email, String password){
	return find.where().eq(email, email).eq("password", password).findUnique();
    }
}
