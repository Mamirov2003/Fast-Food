package com.example.courierservice.controller;

import com.example.courierservice.client.FeignUser;
import com.example.courierservice.dto.ApiResponse;
import com.example.courierservice.dto.OrderHistoryDto;
import com.example.courierservice.dto.OrderWHistoryDto;
import com.example.courierservice.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 10:55 PM on 8/15/2022
 * @project fast-food
 */
@RestController
@RequestMapping("/courier")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService courierService;
    private final FeignUser feignUser;

    @PutMapping("/online/{id}")
    public ResponseEntity<?> editOnline(@PathVariable Long id,@RequestParam Boolean online){
       return feignUser.editOnline(id,online);
    }
    @GetMapping
    public ResponseEntity<?> getOrders (@RequestParam Long id) {
        ApiResponse response=courierService.getAll(id);
        return ResponseEntity.ok(response);
    }//todo rekursiya
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneOrder(@PathVariable Long id){
        return feignUser.getOne(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editOrder(@PathVariable Long id, @RequestBody OrderWHistoryDto orderWHistoryDto){
        return feignUser.edit(id,orderWHistoryDto);
    }
}
