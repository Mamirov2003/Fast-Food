package com.example.operatorservice.repository;

import com.example.operatorservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 4:49 PM on 8/16/2022
 * @project fast-food
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Page<User> findAllByOnline(Boolean online, Pageable pageable);
}
