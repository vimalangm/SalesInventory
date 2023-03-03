package com.salesinventory.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sales {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@Column(name = "product_name")
	String pname;

	long price;

	int discount;

	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(String pname, long price, int discount) {
		super();
		this.pname = pname;
		this.price = price;
		this.discount = discount;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", pname=" + pname + ", price=" + price + ", discount=" + discount + "]";
	}

}
