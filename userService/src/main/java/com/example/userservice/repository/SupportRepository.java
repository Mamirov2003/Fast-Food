package com.example.userservice.repository;

import com.example.userservice.entity.Support;
import com.example.userservice.entity.enums.SupportType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 9:47 PM on 8/14/2022
 * @project fast-food
 */
public interface SupportRepository extends JpaRepository<Support,Long> {
    Page<Support> findAllBySupportType(SupportType supportType, Pageable pageable);
}
