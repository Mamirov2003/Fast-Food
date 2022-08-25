package com.example.courierservice.repository;

import com.example.courierservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 5:14 PM on 8/16/2022
 * @project fast-food
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
