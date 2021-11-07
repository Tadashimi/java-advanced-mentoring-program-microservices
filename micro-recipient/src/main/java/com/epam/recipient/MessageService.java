package com.epam.recipient;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.queue}")
    private String queueName;

    public BaseDto receive() {
        return amqpTemplate.receiveAndConvert(queueName, new ParameterizedTypeReference<BaseDto>(){});
    }
}
