package com.example.kitchenservice.controller;

import com.example.kitchenservice.controller.client.FeignUser;
import com.example.kitchenservice.entity.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 10:23 AM on 8/16/2022
 * @project fast-food
 */
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final FeignUser feignUser;


    @GetMapping
    public ResponseEntity<?> getApprovedOrder(){
       return feignUser.getOrder(OrderStatus.APPROVED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editOrder(@PathVariable Long id, @RequestParam OrderStatus orderStatus){
      return feignUser.editOrder(id,orderStatus);
    }
}
