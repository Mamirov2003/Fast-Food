package com.example.userservice.dto;

import com.example.userservice.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 6:59 PM on 8/26/2022
 * @project fast-food
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderWHistoryDto {
    private OrderStatus orderStatus;
    private Double price;
    @CreationTimestamp
    private Timestamp timestamp;
}
