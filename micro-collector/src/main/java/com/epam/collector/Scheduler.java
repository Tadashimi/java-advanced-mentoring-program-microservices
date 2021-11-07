package com.epam.collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private CollectorClient client;

    @Autowired
    private CollectorRepository repository;

    private Logger logger = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(fixedRate = 2000)
    public void rescanQueue() {
        logger.info("Try to call get method for micro-recipient");
        try {
            List<BaseDto> baseDtoList = client.getMessages();
            logger.info("Read the list of dto:\n" + Arrays.toString(baseDtoList.toArray()));
            baseDtoList.forEach(dto -> repository.save(dto));
        } catch (Exception e) {
            logger.error("Fail call get method for micro-recipient");
        }
    }
}
