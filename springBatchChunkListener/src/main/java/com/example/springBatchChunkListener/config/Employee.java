package com.example.springBatchChunkListener.config;

import javax.persistence.Column;

public class Employee {
@Column
	private String id;
@Column
	private String firstName;
@Column
	private String lastName;

public static String[] fields() {
	return new String[] {":id",":firstName",":lastName"};
}
public Employee(String id, String firstName, String lastName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Employee() {
	super();
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
	
		
}
