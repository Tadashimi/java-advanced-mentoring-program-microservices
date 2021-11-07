package com.epam.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SenderController {

    @Autowired
    private MessageService service;

    private Logger logger = LoggerFactory.getLogger(SenderController.class);

    @GetMapping
    public String getStatus() {
        return "It is sender";
    }

    @PostMapping(path = "/notification")
    public String createMessage(@RequestBody BaseDto baseDto) {
        logger.info("Message is received: " + baseDto.toString());
        try {
            service.send(baseDto);
            logger.info("Message is added to rabbitMQ");
            return "Message is added to rabbitMQ";
        } catch (Exception e) {
            logger.error("Error while adding message");
            logger.error(e.toString());
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                logger.error(stackTraceElement.toString());
            }
            return "Error while adding message";
        }
    }
}
