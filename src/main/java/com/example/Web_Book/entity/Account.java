package com.example.Web_Book.entity;

public class Account {
	private int id;
	private String username;
	private String password;
	private String email;
	private int duty;

	public Account(int id, String username, String password, String email, int duty) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.duty = duty;
	}

	public Account(String username, String password, String email, int duty) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.duty = duty;
	}

	public Account() {

	}

	public int getDuty() {
		return duty;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setDuty(int duty) {
		this.duty = duty;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", duty=" + duty + "]";
	}

}
