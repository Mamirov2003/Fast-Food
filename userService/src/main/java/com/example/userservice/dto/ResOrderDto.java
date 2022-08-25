package com.example.userservice.dto;

import com.example.userservice.entity.enums.OrderStatus;
import com.example.userservice.entity.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 8:09 PM on 8/11/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResOrderDto {
    private Long id;
    private List<ProductWQuantity> productWQuantities;
    private OrderStatus orderStatus;
    private OrderType orderType;
}
