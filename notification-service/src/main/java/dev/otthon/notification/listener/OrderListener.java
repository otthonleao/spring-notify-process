package dev.otthon.notification.listener;

import dev.otthon.notification.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    private final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void sendNotification(Order order) {
        logger.info("Notificação gerada: {}", order.toString());
    }

}
