package com.example.kitchenservice.controller.client;

import com.example.kitchenservice.entity.enums.OrderStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 5:24 PM on 8/18/2022
 * @project fast-food
 */
@FeignClient(name = "userService",url = "http://localhost:8081")
public interface FeignUser {
    @GetMapping("/api/user/order")
    ResponseEntity<?> getOrder(@RequestParam OrderStatus orderStatus);

    @PutMapping("/api/user/order/{id}")
    ResponseEntity<?> editOrder(@PathVariable Long id, @RequestParam OrderStatus orderStatus);
}
