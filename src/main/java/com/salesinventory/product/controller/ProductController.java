package com.salesinventory.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesinventory.product.service.ProductServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("sales/inventory/system")
public class ProductController {
	@Autowired
	ProductServiceImpl productServiceImpl;

	@GetMapping("/save/{pname}/{price}/{discount}")
	public String save(@PathVariable("pname") String pname, @PathVariable("price") long price,
			@PathVariable("discount") int discount) {
		productServiceImpl.save(pname, price, discount);

		return "Successfully data has been saved!";
	}

	@GetMapping("/update/{id}/{pname}/{price}/{discount}")
	public String update(@PathVariable("id") long id, @PathVariable("pname") String pname,
			@PathVariable("price") long price, @PathVariable("discount") int discount) {
		productServiceImpl.update(id, pname, price, discount);

		return "Successfully data has been modified!";
	}

	@GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> get(@PathVariable("id") long id) {

		return new ResponseEntity<Object>(productServiceImpl.get(id), HttpStatus.OK);
	}
	@GetMapping("/sale/{pname}/{price}/{discount}")
	public String sale(@PathVariable("pname") String pname, @PathVariable("price") long price,
			@PathVariable("discount") int discount) {
		productServiceImpl.sales(pname, price, discount);

		return "Successfully data has been saved!";
	}
	@GetMapping(path = "/getSalesItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getSalesItem(@PathVariable("id") long id) {

		return new ResponseEntity<Object>(productServiceImpl.getSalesItem(id), HttpStatus.OK);
	}
}
