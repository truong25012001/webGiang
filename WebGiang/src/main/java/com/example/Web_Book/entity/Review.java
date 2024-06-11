package com.example.Web_Book.entity;

public class Review {
	private int uid;
	private int bid;
	private String username;
	private String content;
	private int rating;
	private String day;

	public Review() {
		super();
	}

	public Review(int uid, int bid, String content, int rating, String day) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.content = content;
		this.rating = rating;
		this.day = day;
	}

	public Review(String username, String content, int rating, String day) {
		super();
		this.username = username;
		this.content = content;
		this.rating = rating;
		this.day = day;
	}

	public int getBid() {
		return bid;
	}

	public String getContent() {
		return content;
	}

	public String getDay() {
		return day;
	}

	public int getRating() {
		return rating;
	}

	public int getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Review [uid=" + uid + ", bid=" + bid + ", content=" + content + ", rating=" + rating + ", day=" + day
				+ "]";
	}

}
