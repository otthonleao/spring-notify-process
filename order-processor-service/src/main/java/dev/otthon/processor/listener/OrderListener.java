package dev.otthon.processor.listener;

import dev.otthon.processor.entity.Order;
import dev.otthon.processor.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    private final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void saveOrder(Order order) {
        order.setStatus(Status.PROCESSED);
        logger.info("Order {} has been processed", order.toString());
    }

}
