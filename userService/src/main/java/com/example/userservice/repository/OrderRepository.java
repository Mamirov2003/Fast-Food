package com.example.userservice.repository;

import com.example.userservice.entity.Order;
import com.example.userservice.entity.User;
import com.example.userservice.entity.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order ,Long> {
    Page<Order> findAllByOrderStatus(OrderStatus orderStatus,Pageable pageable);
    Page<Order>findAllByUserId(Long userId,Pageable pageable);
}
