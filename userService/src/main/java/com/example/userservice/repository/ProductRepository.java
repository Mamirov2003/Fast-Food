package com.example.userservice.repository;

import com.example.userservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 12:33 PM on 8/11/2022
 * @project fast-food
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
