package com.example.userservice.repository;

import com.example.userservice.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 12:27 PM on 8/11/2022
 * @project fast-food
 */
public interface DetailRepository extends JpaRepository<Detail ,Long> {
}
