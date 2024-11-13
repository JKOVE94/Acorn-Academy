package pack;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//텍스트 메세지 처리용 클래스
public class StockPriceHandler extends TextWebSocketHandler{

	private final Random random = new Random(); //주가를 랜덤하게 생산하기 위함
	
	//Websocket 연결이 성공하면 자동으로 호출 (콜백메소드)
	//Session을 초기화하거나 연결이 성립될 때 수행할 작업을 정의
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//새로운 Scheduler 생성
		//newScheduledThreadPool(Pool의 갯수)
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		
		//주기적으로 주식 가격 전송
		executorService.scheduleAtFixedRate(()->{
			if(session.isOpen()) {
				try {
					//주식 가격 생성
					double price = 100 + random.nextDouble() * 10;
					//TextWebSocketHandler를 통해 Text기반 데이터를 다루기 때문에 TextMessage에 담아서 전송
					session.sendMessage(new TextMessage("현재 가격 : " + String.format("%.2f", price)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, 0, 2, TimeUnit.SECONDS);
		session.getAttributes().put("executorService", executorService);
	}
	
	//Websocket 연결이 종료되면 자동 호출 (Callback Method)
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//Session에 저장된 스케쥴러를 가져와서 종료
		ScheduledExecutorService executorService = (ScheduledExecutorService) session.getAttributes().get("executorService");
		
		if(executorService != null && !executorService.isShutdown()) {
			executorService.shutdown();
		}
	}
}
