package com.example.learnwebsocketreceiver;

import java.sql.Timestamp;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnwebsocketreceiver.domain.ChatRequest;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(SocketController.class);
    
    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public String sendMessage(@RequestBody ChatRequest request) {
    	
    	logger.info("Submitted: " + request.getMessage() + " By User: "+ request.getChatUser());
    	insertUserMessage(request.getMessage(), request.getChatUser());
    	
        return "Submitted message: " + request.getMessage();
    }

    @PostMapping("/submit")
    public void receiveMessage(@RequestBody String message) {
        this.simpMessagingTemplate.convertAndSend("/topic/messages", "Received message: " + message);
    }
    
    private void insertUserMessage(String message, String userName) {   	
    	Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
   	
    	// @TODO figure out how to get the user
    	String sql = "INSERT INTO user_messages (dte, usr, msg) VALUES('" + timestamp + "','"+userName+"','" + message + "')";
    	int rows = jdbcTemplate.update (sql);
    	logger.info("Inserted " + rows + " row");
    }
}
