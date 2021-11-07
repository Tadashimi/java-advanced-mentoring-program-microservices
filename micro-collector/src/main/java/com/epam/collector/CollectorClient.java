package com.epam.collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "micro-recipient", url = "http://localhost:8082")
public interface CollectorClient {
    Logger logger = LoggerFactory.getLogger(CollectorClient.class);

    @GetMapping(path = "/message")
    public List<BaseDto> getMessages();

    @GetMapping
    public String getStatus();
}
