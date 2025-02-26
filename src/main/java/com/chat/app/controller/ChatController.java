package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage") // accept the message
    @SendTo("/topic/messages") // send the return value to clients subscribed to this topic
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    // return the thymeleaf template to the root url
    @GetMapping("chat")
    public String chat() {
        return "chat";
    }
}
