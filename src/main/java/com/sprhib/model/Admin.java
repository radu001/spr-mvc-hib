package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin {

	@Id
	private int idAdmin;
	
	private String password;
	
	private String email;
	
	public int getIdAdmin() {
		return idAdmin;
	}

	public Admin(String password, String email) {
		this.password = password;
		this.email = email;
	}

	protected Admin() {
		
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
