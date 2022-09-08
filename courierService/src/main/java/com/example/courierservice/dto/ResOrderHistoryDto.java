package com.example.courierservice.dto;

import com.example.courierservice.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResOrderHistoryDto {
    private String filialName;
    private String customerName;
    private String courierName;
    private Long orderId;
    private Address address;
}
