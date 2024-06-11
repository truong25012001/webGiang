package com.example.Web_Book.entity;

public class OderLine {
	private int oid;
	private int bid;
	private int price;
	private int quantity;
	private int totalMoney;
	private String image;
	private String title;
	private String author;
	private String category;

	public OderLine(int oid, int bid, int quantity, int totalMoney) {
		super();
		this.oid = oid;
		this.bid = bid;
		this.quantity = quantity;
		this.totalMoney = totalMoney;
	}

	public OderLine(int oid, int bid, String image, String title, String author, String category, int price,
			int quantity, int totalMoney) {
		super();
		this.oid = oid;
		this.bid = bid;
		this.quantity = quantity;
		this.image = image;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.totalMoney = totalMoney;
	}

	public OderLine(String image, String title, String author, int quantity) {
		super();
		this.quantity = quantity;
		this.image = image;
		this.title = title;
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public int getBid() {
		return bid;
	}

	public String getCategory() {
		return category;
	}

	public String getImage() {
		return image;
	}

	public int getOid() {
		return oid;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getTitle() {
		return title;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	@Override
	public String toString() {
		return "OderLine [oid=" + oid + ", bid=" + bid + ", quantity=" + quantity + ", image=" + image + ", title="
				+ title + ", author=" + author + "]";
	}

}
