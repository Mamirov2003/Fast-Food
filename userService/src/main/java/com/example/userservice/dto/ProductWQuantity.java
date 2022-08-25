package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 5:20 PM on 8/13/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductWQuantity {
    private String productName;
    private short quantity;
}
