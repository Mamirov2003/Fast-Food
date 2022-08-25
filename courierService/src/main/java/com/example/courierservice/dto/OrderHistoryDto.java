package com.example.courierservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 9:33 PM on 8/19/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderHistoryDto {
    private Long courierId;
    private int reliability;
    private String description;
    @CreationTimestamp
    private Timestamp timestamp;
}
