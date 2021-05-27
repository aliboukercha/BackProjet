package com.nab.product.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nab.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
