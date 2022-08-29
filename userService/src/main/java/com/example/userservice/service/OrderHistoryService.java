package com.example.userservice.service;

import com.example.userservice.dto.*;
import com.example.userservice.entity.Detail;
import com.example.userservice.entity.Order;
import com.example.userservice.entity.OrderHistory;
import com.example.userservice.entity.enums.OrderStatus;
import com.example.userservice.repository.OrderHistoryRepository;
import com.example.userservice.repository.OrderRepository;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 9:16 PM on 8/19/2022
 * @project fast-food
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderHistoryService {
    private final OrderHistoryRepository orderHistoryRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public ApiResponse getAll(OrderStatus orderStatus) {
        Page<OrderHistory> histories=null;
        if (orderStatus.equals(null)){
            histories = orderHistoryRepository.findAll(PageRequest.of(0, 10));
        }else {
            histories = orderHistoryRepository.findAllByOrder_OrderStatus(orderStatus,PageRequest.of(0,10));
        }

        return ApiResponse.builder().success(true).message("There").data(toDTOPage(histories)).build();
    }

    public ResOrderHistoryDto orderHistoryToDto(OrderHistory orderHistory){
        ResOrderHistoryDto resOrderHistoryDto=new ResOrderHistoryDto();
        resOrderHistoryDto.setUserName(orderHistory.getCustomer().getFullName());
        resOrderHistoryDto.setReliability((long) orderHistory.getCustomer().getReliability());
        resOrderHistoryDto.setPhoneNumber(orderHistory.getCustomer().getPhone());
        resOrderHistoryDto.setAddress(orderHistory.getOrder().getAddress());

        List<Detail> detailList = orderHistory.getOrder().getDetailList();
        List<ProductWQuantity> productList=new ArrayList<>();
        for (Detail detail : detailList) {
            ProductWQuantity productWQuantity=new ProductWQuantity();
            productWQuantity.setProductName(detail.getProduct().getName());
            productWQuantity.setQuantity(detail.getQuantity());
            productList.add(productWQuantity);
        }

        resOrderHistoryDto.setProductList(productList);

        return resOrderHistoryDto;
    }

    public Page<ResOrderHistoryDto> toDTOPage(Page<OrderHistory> orderHistories) {
        List<ResOrderHistoryDto> collect =orderHistories.stream().map(this::orderHistoryToDto).collect(Collectors.toList());
        return new PageImpl<>(collect);
    }

    public ApiResponse getOne(Long id) {
        OrderHistory orderHistory = orderHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        return ApiResponse.builder().data(orderHistoryToDto(orderHistory)).message("There").success(true).build();
    }

    public ApiResponse edit(Long id, OrderHistoryDto orderHistoryDto,OrderWHistoryDto orderWHistoryDto) {
        OrderHistory orderHistory = orderHistoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        if (!(Objects.isNull(orderHistoryDto))) {
            try {
//            orderHistory.setReliability(orderHistoryDto.getReliability());
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
            try {
                orderHistory.setDescription(orderHistoryDto.getDescription());
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
            try {
                orderHistory.setCourier(userRepository.findById(orderHistoryDto.getCourierId()).orElseThrow(() -> new RuntimeException("Not Found")));
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
            try {
                orderHistoryRepository.save(orderHistory);
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
        } else {
            try {
                Order order = orderHistory.getOrder();
                order.setOrderStatus(orderWHistoryDto.getOrderStatus());
                orderRepository.save(order);
            }catch (Exception e){
                log.error(String.valueOf(e));
            }
            try {
                orderHistory.setDeliveredPrice(orderWHistoryDto.getPrice());
            }catch (Exception e){
                log.error(String.valueOf(e));
            }
            try {
                orderHistory.setDeliveredTime(orderWHistoryDto.getTimestamp());
                orderHistoryRepository.save(orderHistory);
            }catch (Exception e){
                log.error(String.valueOf(e));
            }
        }
        return ApiResponse.builder().success(true).message("Edited").build();

    }
}
