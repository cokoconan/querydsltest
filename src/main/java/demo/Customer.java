package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Customer {
	
	@Id
	@Column
	@GeneratedValue	
	private int id;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String companyname;
	
	
	@ManyToOne
    @JoinColumn(name = "companyname")
    private Company company;
	
	
	
	public Customer() {
	}
	
	
	public Customer(String firstName, String lastName, String companyname) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyname = companyname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCompanyname() {
		return companyname;
	}


	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", companyname=" + companyname
				+ "]";
	}

	
	

}
