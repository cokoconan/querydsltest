package demo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	@Column
	@GeneratedValue	
	private int id;
	
	@Column
	private String companyname;
	
	@Column
	private String address;
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "companyname")
	 private Set<Customer> customer = new HashSet<Customer>();


	public Company() {
	}



	public Company(String companyname, String address) {
		this.companyname = companyname;
		this.address = address;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCompanyname() {
		return companyname;
	}



	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Set<Customer> getCustomer() {
		return customer;
	}



	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	
	
}
