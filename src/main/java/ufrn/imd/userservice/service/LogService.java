package ufrn.imd.userservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ufrn.imd.userservice.model.Log;

@Component
public class LogService {
    @Value("${client.log.queue}")
    private String queue;
    private final RabbitTemplate rabbitTemplate;

    public LogService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Log log) {
        rabbitTemplate.convertAndSend(log);
    }
}
