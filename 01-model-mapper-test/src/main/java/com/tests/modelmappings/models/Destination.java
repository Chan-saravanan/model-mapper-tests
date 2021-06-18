package com.tests.modelmappings.models;

public class Destination {
	private String destId;
	private String fName;
	private String lName;
	private Role role;
	
	public Destination() {
		// TODO Auto-generated constructor stub
	}
	
	public Destination(String id, String fName, String lName, Role role) {
		this.fName = fName;
		this.lName = lName;
		this.role = role;
	}

	public String getDestId() {
		return destId;
	}

	public void setDestId(String destId) {
		this.destId = destId;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Destination [destId=" + destId + ", fName=" + fName + ", lName=" + lName + ", role=" + role + "]";
	}
	
	
}
