package com.coding.store.repository;

import com.coding.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findByName(String name);
    public List<Product> findByPriceBetween(double min, double max);
}
