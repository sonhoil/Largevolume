package com.realTime.Insight;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/api/addData")
    public void addData(@RequestBody Data data) {
        String id = UUID.randomUUID().toString();
        long timestamp = Instant.now().toEpochMilli();
        Data newData = new Data(id, timestamp, data.getTitle(), data.getDescription());
        
        dataService.addData(newData);
        kafkaProducerService.sendMessage("webSocketTopic", newData);
    }

    @GetMapping("/api/data")
    public List<Object> getData() {
        return dataService.getAllData();
    }
}