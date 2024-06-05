package com.realTime.Insight;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> sampleData = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String key = "data:" + i;
            Data data = new Data();
            data.setTitle("Sample Data " + i);
            data.setDescription("This is sample data " + i);
            sampleData.put(key, data);
        }
        redisTemplate.opsForHash().putAll("TimeSeriesData", sampleData);
    }
}
