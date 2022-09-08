package com.example.courierservice.repository;

import com.example.courierservice.entity.OrderHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
    @Query("select o from OrderHistory o where o.courier.id = ?1")
    Page<OrderHistory> findAllByCourier_Id(Long id, Pageable pageable);
}
