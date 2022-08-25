package com.example.userservice.dto;

import com.example.userservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 9:18 PM on 8/19/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResOrderHistoryDto {
    private String userName;
    private Long reliability;
    private String phoneNumber;
    private List<ProductWQuantity> productList;
    private Address address;
}
