package com.example.userservice.repository;

import com.example.userservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 11:44 PM on 8/10/2022
 * @project fast-food
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByNameContainingIgnoreCase(String name);
}
