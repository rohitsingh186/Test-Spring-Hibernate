package com.barclays.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMAIL")
public class Email implements Comparable {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "employee_id")
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
		if (this.email.equals(((Email) o).email))
			return 0;
		else
			return 1;
	}

}
