package com.study.order.service;

import com.study.order.model.Order;
import com.study.order.model.OrderItem;
import com.study.order.model.dto.OrderCreatedEvent;
import com.study.order.model.dto.OrderResponse;
import com.study.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MongoTemplate mongoTemplate;

    public void createOrder(OrderCreatedEvent orderCreatedEvent) {
        Order order = new Order();
        order.setOrderId(orderCreatedEvent.codigoPedido());
        order.setCustomerId(orderCreatedEvent.codigoCliente());
        order.setOrderItems(getOrderItems(orderCreatedEvent));
        order.setAmount(getAmount(orderCreatedEvent));
        orderRepository.save(order);
    }

    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        Page<Order> orders = orderRepository.findAllByCustomerId(customerId, pageRequest);
        return orders.map(OrderResponse::fromOrder);
    }

    public BigDecimal getTotalAmountOnOrderByCustomerId(Long customerId) {
        Aggregation aggregation = newAggregation(
                match(Criteria.where("customerId").is(customerId)),
                group().sum("amount").as("totalAmount")
        );
        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "orders", Document.class);
        return new BigDecimal(Objects.requireNonNull(results.getUniqueMappedResult()).get("totalAmount").toString());
    }

    private BigDecimal getAmount(OrderCreatedEvent orderCreatedEvent) {
        return orderCreatedEvent.itens().stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static List<OrderItem> getOrderItems(OrderCreatedEvent orderCreatedEvent) {
        return orderCreatedEvent.itens().stream()
                .map(i -> new OrderItem(i.produto(), i.quantidade(), i.preco()))
                .toList();
    }
}
