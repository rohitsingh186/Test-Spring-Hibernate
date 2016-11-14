package com.barclays.domain;

public class Email implements Comparable{

	private int id;
	private String email;
	private Employee employee;

	public Email() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int compareTo(Object o) {
		if(this.email.equals(((Email)o).email))
			return 0;
		else 
			return 1;
	}

	

}
