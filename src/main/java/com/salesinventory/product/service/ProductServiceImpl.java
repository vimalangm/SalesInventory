package com.salesinventory.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesinventory.product.model.Product;
import com.salesinventory.product.model.Sales;
import com.salesinventory.product.repository.ProductRepository;
import com.salesinventory.product.repository.SalesRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SalesRepository salesRepository;

	@Override
	public void save(String pname, long price, int discount) {
		List<Product> listOfProducts = new ArrayList<>();
		listOfProducts.add(new Product(pname, price, discount));
		productRepository.saveAll(listOfProducts);
	}

	@Override
	public void update(long id, String pname, long price, int discount) {
		Optional<Product> product = productRepository.findById(id);
		Product p = new Product();
		p.setId(id);
		p.setProductName(pname);
		p.setPrice(price);
		p.setDiscount(discount);
		if (product != null) {
			productRepository.save(p);
		}

	}

	@Override
	public Product get(long id) {

		return productRepository.findById(id).get();
	}

	@Override
	public void sales( String pname, long price, int discount) {
		List<Sales> listOfSales = new ArrayList<>();
		long discountPrice = price - (discount / 100 * price);
		listOfSales.add(new Sales( pname, discountPrice, discount));
		salesRepository.saveAll(listOfSales);
	}
	@Override
	public Product getSalesItem(long id) {

		Product listOfItems = productRepository.findById(id).get();
		long price=listOfItems.getPrice();
		long finalPrice=(long) (price-(Double.valueOf(listOfItems.getDiscount())/100.0)*price);
		listOfItems.setProductName(listOfItems.getProductName());
		listOfItems.setPrice(finalPrice);
		listOfItems.setDiscount(listOfItems.getDiscount());
		return listOfItems;
	}

}
