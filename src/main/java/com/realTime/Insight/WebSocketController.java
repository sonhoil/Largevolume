package com.realTime.Insight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        redisTemplate.convertAndSend("webSocketTopic", message);
        return HtmlUtils.htmlEscape(message);
    }
}