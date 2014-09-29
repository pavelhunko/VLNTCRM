package models;

import javax.persistence.Id;

public class Admin extends User {
    
    @Id
    public String email;
    public String name;
    public String phone;
    public String companyName;
    public String streetAddress;
    public String password;
    public Boolean isAdmin;
    
    

    public Admin(String email, String name, String password, String phone, String companyName, String streetAddress, Boolean isAdmin) {
	this.email = email;
	this.name = name;
	this.password = password;
	this.phone = phone;
	this.companyName = companyName;
	this.streetAddress = streetAddress;
	this.isAdmin = isAdmin;
	
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = true;
    }
}
