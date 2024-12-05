package pack.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import pack.ChatMessage;

@Component // 연결해제 이벤트 처리용
public class WebsocketLeaveListener {
	private final SimpMessagingTemplate messagingTemplate;
	
	public WebsocketLeaveListener(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	@EventListener
	public void handleWebsocketDisconnectListener(SessionDisconnectEvent disconnectEvent) {
		//StompHeaderAccessor를 사용해 STOMP 메세지의 헤더정보를 접근할 수 있도록 wrapping
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(disconnectEvent.getMessage());
		
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		if(username != null) {
			ChatMessage chatmessage = new ChatMessage();
			chatmessage.setType(ChatMessage.MessageType.LEAVE);
			chatmessage.setSender(username); //메세지의 발신자를 WebSocket Session에 담긴 username으로 설정
			
			messagingTemplate.convertAndSend("/topic/public", chatmessage);
		}
	}
}
