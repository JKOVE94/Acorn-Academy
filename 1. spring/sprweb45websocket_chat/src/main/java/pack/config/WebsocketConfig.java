package pack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer{

	
	@Override
	//Websocket MessageBroker의 동작을 재정의
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//MessageBrokerRegistry : MessageBroker의 대상(Profile)을 설정, 외부 메세지 브로커로 라우팅(요청을 핸들러로 매핑)
		
		// '/topic'으로 시작하는 메세지는 MessageBroker로 라우팅 된다.
		registry.enableSimpleBroker("/topic");
		
		// 클라이언트는 '/app'으로 시작하는 메세지를 서버로 보냄
		registry.setApplicationDestinationPrefixes("/app");	
	}
	
	@Override
	//Endpoint를 등록
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//클라이언트가 websocket을 통해 연결할 수 있는 URL을 정의, SocketJS와 같은 콜백 옵션을 설정할 수 있다.
//		registry.addEndpoint("/ws").withSockJS();
		// '/ws' 이 결로로 접속해 STOMP 메세지를 주고받을 수 있다.
	
		// CORS(Cross Origin Resources Sharing)
		 registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
		
	}
}
