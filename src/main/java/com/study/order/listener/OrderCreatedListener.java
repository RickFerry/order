package com.study.order.listener;

import com.study.order.model.dto.OrderCreatedEvent;
import com.study.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.study.order.config.RabbitMQConfig.ORDER_CREATED_QUEUE;

@Component
@AllArgsConstructor
public class OrderCreatedListener {
    private OrderService orderService;

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void handleOrderCreatedEvent(Message<OrderCreatedEvent> message) {
        orderService.createOrder(message.getPayload());
    }
}