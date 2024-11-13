package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

	// 클라이언트가 '/app/message' 로 전송한 메세지를 처리
	@MessageMapping("/message") // 수신된 메세지
	@SendTo("/topic/messages") //broadcasting
	public String sendMessage(String message) {
		return message;
		//반환하는 메세지는 자동으로 '/topic/messages'를 구독하는 모든 subscriber에게 broadcasting 됨.
	}
	
}
