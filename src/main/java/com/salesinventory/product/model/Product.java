package com.salesinventory.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@Column(name = "product_name")
	String pname;

	long price;

	int discount;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String pname, long price, int discount) {
		super();
		this.pname = pname;
		this.price = price;
		this.discount = discount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return pname;
	}

	public void setProductName(String productName) {
		this.pname = productName;
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
		return "Product [id=" + id + ", pname=" + pname + ", price=" + price + ", discount=" + discount
				+ "]";
	}

}
