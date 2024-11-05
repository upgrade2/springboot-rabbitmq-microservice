package com.example.orderservice.publisher;

import com.example.orderservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Value("${rabbitmq.queue.order.name}")
    private String orderQueueName;
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${rabbitmq.order.routing.key.name}")
    private String routingKeyName;

    @Value("${rabbitmq.email.routing.key.name}")
    private String emailRoutingKeyName;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent){
        LOGGER.info(String.format("Order event sent to RabbitMQ => %s",orderEvent.toString()));

        //send an order event to
        rabbitTemplate.convertAndSend(exchangeName,routingKeyName,orderEvent);

        //send an order event to email queue
        rabbitTemplate.convertAndSend(exchangeName,emailRoutingKeyName,orderEvent);
    }
}
