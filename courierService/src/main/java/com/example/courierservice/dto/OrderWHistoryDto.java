package com.example.courierservice.dto;

import com.example.courierservice.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderWHistoryDto {
    private OrderStatus orderStatus;
    private Double price;
    @CreationTimestamp
    private Timestamp timestamp;
}
