package com.example.userservice.repository;

import com.example.userservice.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface DetailRepository extends JpaRepository<Detail ,Long> {
}
