package com.nagarro.entity;

import java.sql.Timestamp;

public class SearchFilter {
	private String search;
	private String productId;
	private String email;
	private Timestamp date;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public SearchFilter(String search, String productId, String email, Timestamp date) {
		super();
		this.search = search;
		this.productId = productId;
		this.email = email;
		this.date = date;
	}

	public SearchFilter() {
		super();
	}

	@Override
	public String toString() {
		return "SearchFilter [search=" + search + ", productId=" + productId + ", email=" + email + ", date=" + date
				+ "]";
	}

}
