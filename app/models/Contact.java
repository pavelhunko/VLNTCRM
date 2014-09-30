package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Contact extends Model {
	
	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	public String streetAddress;
	public String companyName;

	@ManyToOne
	public User user;

	
}
