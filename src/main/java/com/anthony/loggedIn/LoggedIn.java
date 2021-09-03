package com.anthony.loggedIn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "logged_in")

public class LoggedIn {
	
	
	@Id
	private int log_id;
	
	@Column(name = "log_username", length = 100)
	private String log_username;
	
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public String getLogUsername() {
		return log_username;
	}
	public void setLogUsername(String logUsername) {
		this.log_username = logUsername;
	}
	
	public LoggedIn(int log_id, String log_username) {
		super();
		this.log_id = log_id;
		this.log_username = log_username;
	}
	
	

}
