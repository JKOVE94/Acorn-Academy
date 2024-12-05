package pack.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import pack.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat.addUser") 
	@SendTo("/topic/public")
	public ChatMessage addUser(ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
		//새로운 사용자가 채팅에 참여하면 해당 메세지를 반환 => broadcasting
		//SimpMessageHeaderAccessor => WebSocket 세션에 사용자 이름을 저장 - 세션은 클라이언트와 서버간의 연결을 추적 가능
		headerAccessor.getSessionAttributes().put("username", message.getSender());
		
		return message; //새로운 채팅참여자 이름을 broadcasting
	}
	
	@MessageMapping("/chat.leaveUser") 
	@SendTo("/topic/public") 
	public ChatMessage leaveUser(ChatMessage message) {
		return message;
	}
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(ChatMessage message) {
		//클라이언트로부터 채팅 메세지를 수신 후 해당 메세지를 반환 => broadcasting
		return message;
	}
	
}
