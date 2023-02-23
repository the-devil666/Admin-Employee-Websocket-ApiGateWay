package com.pws.spring.ws.api.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.pws.spring.ws.api.model.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

	@MessageMapping("/chat.leave")
	@SendTo("/topic/public")
	public ChatMessage leave(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		if (username != null) {
			ChatMessage leaveMessage = new ChatMessage();
			leaveMessage.setType(ChatMessage.MessageType.LEAVE);
			leaveMessage.setSender(username);
			return leaveMessage;
		}
		return null;
	}



}
