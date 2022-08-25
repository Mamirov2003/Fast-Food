package com.example.userservice.repository;

import com.example.userservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 1:11 PM on 8/11/2022
 * @project fast-food
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
