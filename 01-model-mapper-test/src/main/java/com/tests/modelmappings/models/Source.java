package com.tests.modelmappings.models;

public class Source {
	private String id;
	private String fName;
	private String lName;
	private String role;
	public Source() {
		// TODO Auto-generated constructor stub
	}
	
	public Source(String fName, String lName, String role) {
		this.fName = fName;
		this.lName = lName;
		this.role = role;
	}
	
	public Source(String id, String fName, String lName, String role) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Source [id=" + id + ", fName=" + fName + ", lName=" + lName + ", role=" + role + "]";
	}	
	
}
