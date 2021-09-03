package com.anthony.manager;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table (name = "managers")

public class Manager {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int man_id;
	
	@Column(name = "man_username", length = 100)
	private String man_username;
	
	@Column(name = "man_password", length = 100)
	private String man_password;
	
	public Manager(int man_id, String man_username, String man_password) {
		super();
		this.man_id = man_id;
		this.man_username = man_username;
		this.man_password = man_password;
	}

	public Manager() {
		super();
	}

	public int getMan_id() {
		return man_id;
	}

	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}

	public String getMan_username() {
		return man_username;
	}

	public void setMan_username(String man_username) {
		this.man_username = man_username;
	}

	public String getMan_password() {
		return man_password;
	}

	public void setMan_password(String man_password) {
		this.man_password = man_password;
	}

	@Override
	public String toString() {
		return "Manager [man_id=" + man_id + ", man_username=" + man_username + ", man_password=" + man_password + "]";
	}
	
	
	
}
