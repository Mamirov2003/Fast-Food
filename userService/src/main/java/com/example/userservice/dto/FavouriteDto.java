package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 9:07 PM on 8/14/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavouriteDto {
    @NotNull
    private Long userId;
    @NotNull
    private List<Long> productIds;
}
