package com.epam.recipient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private MessageService service;

    private Logger logger = LoggerFactory.getLogger(Scheduler.class);

    List<BaseDto> list = new ArrayList<>();

    @Scheduled(fixedRate = 1000)
    public void rescanQueue() {
        logger.info("Try to read message");
        try {
            list.add(service.receive());
        } catch (Exception e) {
            logger.error("Fail to read message");
        }
    }

    public List<BaseDto> getList() {
        List<BaseDto> listToReturn = new ArrayList<>(list);
        list.clear();
        return listToReturn;
    }
}
