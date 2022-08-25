package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 12:31 PM on 8/11/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    @NotNull
    private short quantity;
}
