package com.study.order.model.dto;

import com.study.order.model.Order;

import java.math.BigDecimal;

public record OrderResponse(
        Long orderId,
        Long customerId,
        BigDecimal total
) {
    public static OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getCustomerId(),
                order.getAmount()
        );
    }
}
