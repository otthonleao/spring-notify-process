package dev.otthon.notification.service;

import dev.otthon.notification.domain.Order;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Order order) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("orders@mail.com");
        simpleMailMessage.setTo(order.getEmailNotification());
        simpleMailMessage.setSubject("Order processed");
        simpleMailMessage.setText(this.generationMessage(order));

        mailSender.send(simpleMailMessage);
    }

    private String generationMessage(Order order) {
        String orderId = order.getId().toString();
        String client = order.getClient();
        String total = order.getTotal().toString();
        String status = order.getStatus().name();

        return String.format("Order %s processed for client %s with total %s.\n Status: %s", orderId, client, total, status);
    }
}
