package com.study.order.repository;

import com.study.order.model.Order;
import com.study.order.model.dto.OrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Page<Order> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}
