package com.tests.modelmappings.models;

public class Role {
	private String role;
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public Role(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}
	
}
