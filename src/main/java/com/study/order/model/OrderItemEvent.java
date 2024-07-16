package com.study.order.model;

import java.math.BigDecimal;

public record OrderItemEvent(
        String produto,
        Integer quantidade,
        BigDecimal preco
) {
}
