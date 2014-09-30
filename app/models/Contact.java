package models;

import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.ManyToOne;

import play.db.ebean.Model;
import scala.Int;

@Entity
public class Contact extends Model {
    @Id
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String streetAddress;
    public String companyName;
    
    @ManyToOne
    public User user; 
    
    public static Finder<Long, User> find() {
	return new Finder<Long, User>(Long.class, User.class); 
	}
}
