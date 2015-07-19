package demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Column
	@GeneratedValue	
	private int id;


	@Column
	private String companyname;
	
	@Column
	private String address;
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
	 private List<Customer> customer = new ArrayList<Customer>();


	public Company() {
	}



	public Company(String companyname, String address) {
		this.companyname = companyname;
		this.address = address;
	}
	public Company(String companyname) {
		this.companyname = companyname;

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


	public List<Customer> getCustomer() {
		return customer;
	}



	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}	
	
	
}
