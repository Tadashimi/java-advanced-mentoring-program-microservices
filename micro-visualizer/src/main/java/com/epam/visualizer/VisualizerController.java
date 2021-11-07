package com.epam.visualizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class VisualizerController {

    @Autowired
    VisualizerRepository repository;

    private Logger logger = LoggerFactory.getLogger(VisualizerController.class);

    @GetMapping
    public String getStatus() {
        return "It is visualizer";
    }

    @GetMapping(path = "/saved-messages")
    public String createMessage() {
        logger.info("Try to read messages from DB");
        try {
            List<BaseDto> baseDtos = repository.findAll();
            logger.info("Messages were read from DB\n" + Arrays.toString(baseDtos.toArray()));
            return "Messages were read from DB";
        } catch (Exception e) {
            return "Error reading message from DB";
        }
    }
}
