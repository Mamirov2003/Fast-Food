package com.example.adminservice.controller;

import com.example.adminservice.dto.ApiResponse;
import com.example.adminservice.service.OrderHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderhistory")
@RequiredArgsConstructor
public class OrderHistoryController {
    private final OrderHistoryService orderHistoryService;

    //OrderStatus orqali OrderHistorylarni olish
    @GetMapping("/employeesemployees")
    public ResponseEntity<?> getAllByOrderStatus(@RequestParam String orderStatus){
        ApiResponse response = orderHistoryService.getAllByOrderStatus(orderStatus);
        return ResponseEntity.ok().body(response);
    }

}
