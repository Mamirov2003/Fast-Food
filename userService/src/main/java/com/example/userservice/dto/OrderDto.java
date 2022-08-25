package com.example.userservice.dto;

import com.example.userservice.entity.Address;
import com.example.userservice.entity.enums.OrderStatus;
import com.example.userservice.entity.enums.OrderType;
import com.example.userservice.entity.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 6:59 PM on 8/11/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    @NotNull
    private Long userId;
    @NotNull
    private List<Long> detailList;
    @NotNull
    private PayType payType;
    @NotNull
    private OrderType orderType;
    @NotNull
    private AddressDto address;
    @NotNull
    private Long filialId;
}
