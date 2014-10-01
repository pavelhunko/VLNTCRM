package models;

import java.util.List;

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

	public Contact(Long i, String firstName, String lastName, String email,
			String phone, String streetAddress, String companyName) {
		this.id = i;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.streetAddress = streetAddress;
		this.companyName = companyName;
	}

	public static Model.Finder<Long, Contact> find = new Model.Finder(
			Long.class, Contact.class);

	public static List<Contact> findContact(Long user_id) {
		return find.fetch("dbusers.users").where().eq("id", user_id).findList();
	}

	public static Contact create(String fName, String lName, String email, String phone,
			String sAddress, String comName, Long user_id) {
		Contact contact = new Contact(null, fName, lName, email, phone, sAddress, comName);
		//Contact contact = new Contact(null, null, null, null, null, null, null);
		contact.user = User.findByID.ref(user_id);
		contact.save(); // ????
		return contact;
	}

}
