package com.example.operatorservice.client;

import com.example.operatorservice.dto.OrderHistoryDto;
import com.example.operatorservice.entity.Role;
import com.example.operatorservice.entity.enums.OrderStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 3:18 PM on 8/18/2022
 * @project fast-food
 */
@FeignClient(name = "userService",url = "http://localhost:8081")
public interface FeignUser {
    @GetMapping("/api/user/history")
    ResponseEntity<?>getOrder(@RequestParam OrderStatus orderStatus);

    @PutMapping("/api/user/order/{id}")
    ResponseEntity<?> editOrder(@PathVariable Long id,OrderStatus orderStatus);

    @GetMapping("/api/user/user")
    ResponseEntity<?> getAvailableCouriers(@RequestParam String role,@RequestParam Boolean online);

    @GetMapping("/api/user/{id}")
    ResponseEntity<?> getUser(@PathVariable Long id);

    @PutMapping("/api/user/history/{id}")
    ResponseEntity<?> toCourier(@PathVariable Long id, @RequestBody OrderHistoryDto orderHistoryDto);
}
