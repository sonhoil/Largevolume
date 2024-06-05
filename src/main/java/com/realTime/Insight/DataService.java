package com.realTime.Insight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> valueOperations;

    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
    }


    public List<Data> getData() {
        return redisTemplate.opsForHash().values("TimeSeriesData").stream()
                .map(data -> (Data) data)
                .collect(Collectors.toList());
    }

    public void addData(Data data) {
        String key = "webSocketTopic:" + System.currentTimeMillis();
        valueOperations.set(key, data);
        redisTemplate.opsForHash().put("TimeSeriesData", key, data);
    }
    
    public List<Object> getAllData() {
        List<Object> dataList = new ArrayList<>();
        // Fetch all keys matching the pattern
        for (String key : redisTemplate.keys("webSocketTopic:*")) {
            dataList.add(valueOperations.get(key));
        }
        return dataList;
    }
}