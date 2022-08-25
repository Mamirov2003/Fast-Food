package com.example.courierservice.repository;

import com.example.courierservice.entity.OrderHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 5:17 PM on 8/16/2022
 * @project fast-food
 */
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
    Page<OrderHistory> findAllByCourier_Id(Long id,Pageable pageable);
}
