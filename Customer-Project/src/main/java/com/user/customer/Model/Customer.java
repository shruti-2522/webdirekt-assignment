package com.user.customer.Model;

public class Customer {

	private int id;
	private String name;
	private String addr1;
	private String addr2;
	private String street;
	private String country;
	private int zip;
	private String city;
	private int phone;
	private int fax;
	private String web;
	private String email;
	private String Notes;
	
	
  
	public Customer(String name, String addr1, String addr2, String street, String country, int zip, String city,
			int phone, int fax, String web, String email, String notes) {
		super();
		this.name = name;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.street = street;
		this.country = country;
		this.zip = zip;
		this.city = city;
		this.phone = phone;
		this.fax = fax;
		this.web = web;
		this.email = email;
		Notes = notes;
	}

	public Customer(int id, String name, String addr1, String addr2, String street, String country, int zip,
			String city, int phone, int fax, String web, String email, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.street = street;
		this.country = country;
		this.zip = zip;
		this.city = city;
		this.phone = phone;
		this.fax = fax;
		this.web = web;
		this.email = email;
		Notes = notes;
	}

	// Getter and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

}
