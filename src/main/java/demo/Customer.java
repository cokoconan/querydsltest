package demo;

import javax.persistence.Entity;


@Entity
public class Customer {
	private String firstName;
	private String lastName;
	
	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

}
