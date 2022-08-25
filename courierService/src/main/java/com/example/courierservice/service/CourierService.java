package com.example.courierservice.service;

import com.example.courierservice.dto.ApiResponse;
import com.example.courierservice.dto.ResOrderHistoryDto;
import com.example.courierservice.entity.OrderHistory;
import com.example.courierservice.repository.OrderHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 8:35 PM on 8/18/2022
 * @project fast-food
 */
@Service
@RequiredArgsConstructor
public class CourierService {
    private final OrderHistoryRepository orderHistoryRepository;

    public ApiResponse getAll(Long id) {
        Page<OrderHistory> orderHistories = orderHistoryRepository.findAllByCourier_Id(id, PageRequest.of(0, 10));

        return ApiResponse.builder().data(toDTOPage(orderHistories)).success(true).message("There").build();
    }
    public ResOrderHistoryDto orderHistoryToDto(OrderHistory orderHistory){
        ResOrderHistoryDto resOrderHistoryDto=new ResOrderHistoryDto();
        resOrderHistoryDto.setFilialName(orderHistory.getFilial().getName());
        resOrderHistoryDto.setCustomerName(orderHistory.getCustomer().getFullName());
        resOrderHistoryDto.setAddress(orderHistory.getOrder().getAddress());
        resOrderHistoryDto.setCourierName(orderHistory.getCourier().getFullName());
        resOrderHistoryDto.setOrderId(orderHistory.getOrder().getId());
        return resOrderHistoryDto;
    }

    public Page<ResOrderHistoryDto> toDTOPage(Page<OrderHistory> orderHistories) {
        List<ResOrderHistoryDto> collect =orderHistories.stream().map(this::orderHistoryToDto).collect(Collectors.toList());
        return new PageImpl<>(collect);
    }
}
