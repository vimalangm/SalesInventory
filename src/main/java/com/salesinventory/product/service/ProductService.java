package com.salesinventory.product.service;


import com.salesinventory.product.model.Product;

public interface ProductService {

	public void save(String pname, long price, int discount);

	public void update(long id, String pname, long price, int discount);
	public Product get(long id); 
	public void sales(String pname,long price,int discount);
	public Product getSalesItem(long id); 
}
