package com.example.learnwebsocketreceiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SocketController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public String sendMessage(@RequestBody String message) {
        log.info("Submitted: " + message);
        return "Submitted message: " + message;
    }

    @PostMapping("/submit")
    public void receiveMessage(@RequestBody String message) {
        this.simpMessagingTemplate.convertAndSend("/topic/messages", "Received message: " + message);
    }
}
