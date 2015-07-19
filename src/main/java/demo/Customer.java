package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;


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
	
	
    @Autowired
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="companyname")
    private Company company;

    
    
    
	public Customer() {
	}
	
	
	public Customer(String firstName, String lastName, Company com) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = com;
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


	


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}

	

}
