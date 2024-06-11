package com.example.Web_Book.entity;

public class Item {
	private Book book;
	private int quantity;
	private int price;

	public Item() {
	}

	public Item(Book book, int quantity, int price) {
		this.book = book;
		this.quantity = quantity;
		this.price = price;
	}

	public Book getBook() {
		return book;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
