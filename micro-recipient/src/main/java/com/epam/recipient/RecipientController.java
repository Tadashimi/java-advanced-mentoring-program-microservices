package com.epam.recipient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipientController {

    @Autowired
    Scheduler scheduler;

    private Logger logger = LoggerFactory.getLogger(RecipientController.class);

    @GetMapping
    public String getStatus() {
        return "It is recipient";
    }

    @GetMapping(path = "/message")
    public List<BaseDto> getMessages() {
        logger.info("Try to get message list");
        return scheduler.getList();
    }
}
