package com.barclays.domain;

import java.util.Set;
import java.util.TreeSet;

public class Employee {

	private int id;
	private String name;
	private String brid;
	private Address address;
	private Set<Email> emails;
	private Employee manager;

	public Employee() {
		this.emails = new TreeSet<Email>();
	}

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

	public String getBrid() {
		return brid;
	}

	public void setBrid(String brid) {
		this.brid = brid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}
	
	public void addEmail(Email email){
		this.emails.add(email);
	}
	
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

}
