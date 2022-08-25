package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 12:39 PM on 8/11/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResDetailDto {
    private String productName;
    private byte[] photo;
    private short quantity;
    private Double price;
}
