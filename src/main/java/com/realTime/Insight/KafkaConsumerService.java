package com.realTime.Insight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "webSocketTopic", groupId = "group_id")
    public void consume(String message) {
        redisTemplate.opsForList().rightPush("real_time_data", message);
        System.out.println("message ==>"+message);
        messagingTemplate.convertAndSend("/topic/data", message);
        System.out.println("Consumed message: " + message);
    }
}
