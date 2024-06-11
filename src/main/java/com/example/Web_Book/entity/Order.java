package com.example.Web_Book.entity;

import java.util.ArrayList;

public class Order {
	private int stt;
	private int id;
	private int uid;
	private String day;
	private Double totalMoney;
	private int status;
	private String username;
	private String name;
	private String phone;
	private String address;
	private String payment;
	private int quantity;
	private ArrayList<OrderLine> orderLines;

	public Order(int id, int uid, int quantity, String day, Double totalMoney, int status) {
		super();
		this.id = id;
		this.uid = uid;
		this.day = day;
		this.status = status;
		this.quantity = quantity;
		this.totalMoney = totalMoney;
	}

	public Order(int id, int quantity, String day, double totalMoney, int status) {
		super();
		this.id = id;
		this.day = day;
		this.quantity = quantity;
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

	public Order(int stt, int id, String username, String day, int quantity, double totalMoney, int status) {
		super();
		this.stt = stt;
		this.id = id;
		this.quantity = quantity;
		this.totalMoney = totalMoney;
		this.day = day;
		this.status = status;
		this.username = username;
	}

	public Order() {

	}

	public String getDay() {
		return day;
	}

	public int getId() {
		return id;
	}



	public int getStatus() {
		return status;
	}



	public double getTotalMoney() {
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



	public void setStatus(int status) {
		this.status = status;
	}



	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", uid=" + uid +
				", day='" + day + '\'' +
				", totalMoney=" + totalMoney +
				", status=" + status +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", payment='" + payment + '\'' +
				", orderLines=" + orderLines +
				'}';
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
