package com.example.operatorservice.repository;

import com.example.operatorservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 5:56 PM on 8/18/2022
 * @project fast-food
 */
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByNameContainingIgnoreCase(String name);
}
