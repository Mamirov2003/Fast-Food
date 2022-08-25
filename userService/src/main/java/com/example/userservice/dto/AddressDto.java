package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 9:08 PM on 8/20/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {
    private Double lat;
    private Double lon;
    private String target;

}
