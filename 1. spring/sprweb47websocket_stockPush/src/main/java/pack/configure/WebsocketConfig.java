package pack.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import pack.StockPriceHandler;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//WebSocket의 엔드포인트와 핸들러를 설정
		//setAllowedOrigins : CORS 설정
		registry.addHandler(new StockPriceHandler(), "/stock-price").setAllowedOrigins("*");
	}

}
