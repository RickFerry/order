package com.study.order.controller;

import com.study.order.model.dto.ApiResponse;
import com.study.order.model.dto.OrderResponse;
import com.study.order.model.dto.PaginationResponse;
import com.study.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("customers/{customerId}/orders")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrders(@PathVariable("customerId") Long customerId,
                                                                @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                @RequestParam(name = "size", defaultValue = "10") Integer size) {
        Page<OrderResponse> body = orderService.findAllByCustomerId(customerId, PageRequest.of(page, size));
        return ResponseEntity.ok(new ApiResponse<>(body.getContent(), PaginationResponse.fromPage(body)));
    }
}
