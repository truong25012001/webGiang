package com.example.Web_Book.entity;

public class Order {
	private int stt;
	private int id;
	private int uid;
	private int quantity;
	private String day;
	private int totalMoney;
	private int status;
	private String username;

	public Order(int id, int uid, int quantity, String day, int totalMoney, int status) {
		super();
		this.id = id;
		this.uid = uid;
		this.quantity = quantity;
		this.day = day;
		this.status = status;
		this.totalMoney = totalMoney;
	}

	public Order(int id, int quantity, String day, int totalMoney, int status) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.day = day;
		this.totalMoney = totalMoney;
		this.status = status;
	}

	public Order(int id, int quantity, String day, int status, String username) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.day = day;
		this.status = status;
		this.username = username;
	}

	public Order(int stt, int id, String username, String day, int quantity, int totalMoney, int status) {
		super();
		this.stt = stt;
		this.id = id;
		this.quantity = quantity;
		this.totalMoney = totalMoney;
		this.day = day;
		this.status = status;
		this.username = username;
	}

	public String getDay() {
		return day;
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getStatus() {
		return status;
	}

	public int getStt() {
		return stt;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public int getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", quantity=" + quantity + ", day=" + day + ", totalMoney="
				+ totalMoney + ", status=" + status + ", username=" + username + "]";
	}

}
