package com.example.courierservice.client;

import com.example.courierservice.dto.OrderHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 6:25 PM on 8/18/2022
 * @project fast-food
 */
@FeignClient(name = "userService",url = "http://localhost:8081")
public interface FeignUser {
    @PutMapping("/api/user/user/{id}")
    ResponseEntity<?> editOnline(@PathVariable Long id, @RequestParam Boolean online);

    @GetMapping("/api/user/history/{id}")
    ResponseEntity<?> getOne(@PathVariable Long id);

    @PutMapping("/api/user/history/{id}")
    ResponseEntity<?> edit(@PathVariable Long id, @RequestBody OrderHistoryDto orderHistoryDto);
}
