package com.salesinventory.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesinventory.product.model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long>{

}
