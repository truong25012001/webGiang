package com.example.Web_Book.entity;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> items;
	private String name;
	private String phone;
	private String address;
	private String date;
	private Double totalMoney;
	private String payment;
	public Cart() {
		items = new ArrayList<>();
	}

	public void addItem(Item t) {
		if (getItemById(t.getBook().getId()) != null) {
			Item m = getItemById(t.getBook().getId());
			m.setQuantity(m.getQuantity() + t.getQuantity());
		} else {
			items.add(t);
		}
	}

	private Book getBookById(int id, ArrayList<Book> list) {
		for (Book i : list) {
			if (i.getId() == id) {
				return i;
			}
		}
		return null;
	}

	private Item getItemById(int id) {
		for (Item i : items) {
			if (i.getBook().getId() == id) {
				return i;
			}
		}
		return null;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}

	public void removeItem(int id) {
		if (getItemById(id) != null) {
			items.remove(getItemById(id));
		}
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"items=" + items +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", date='" + date + '\'' +
				", totalMoney=" + totalMoney +
				'}';
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
}
