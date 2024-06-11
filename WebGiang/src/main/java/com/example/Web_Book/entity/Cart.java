package com.example.Web_Book.entity;

import java.util.ArrayList;

public class Cart {
	ArrayList<Item> items;

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

}
