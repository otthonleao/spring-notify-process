package dev.otthon.notification.listener;

import dev.otthon.notification.domain.Order;
import dev.otthon.notification.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    private final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    private final EmailService emailService;

    public OrderListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void sendNotification(Order order) {
        emailService.sendEmail(order);
        logger.info("Notificação gerada: {}", order.toString());
    }

}
