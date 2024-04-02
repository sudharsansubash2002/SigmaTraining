package com.example.sigmademo.model;

public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private String emailId;
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + "]";
	}
	public Employee(int empId, String firstName, String lastName, String emailId) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	public Employee() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
