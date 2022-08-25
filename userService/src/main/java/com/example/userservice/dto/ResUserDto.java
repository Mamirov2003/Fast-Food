package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 12:36 AM on 8/11/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResUserDto {
    private String fullName;
    private String phone;
    private String region;
    private String roleName;
    private int reliability;
    private String filialName;
}
