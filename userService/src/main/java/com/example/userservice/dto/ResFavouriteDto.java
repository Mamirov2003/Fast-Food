package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 9:20 PM on 8/14/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResFavouriteDto {
    private String userName;
    private List<String> productNames;
}
