package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

	@MessageMapping("/friend-request")
	@SendTo("/topic/notifications")
	public MyNotification friendRequest(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "알 수 없는 사용자";
		}
		return new MyNotification("친구 요청", "\'"+fromUser+"\' 님께서 친구 요청을 하셨습니다");
	}
	
	@MessageMapping("/comment")
	@SendTo("/topic/notifications")
	public MyNotification Comment(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "모르는 사용자";
		}
		return new MyNotification("댓글", "\'"+fromUser+"\' 님께서 댓글을 다셨습니다.");
	}
	
	@MessageMapping("/like")
	@SendTo("/topic/notifications")
	public MyNotification like(String fromUser) {
		if(fromUser == null || fromUser.trim().isEmpty()) {
			fromUser = "익명 사용자";
		}
		return new MyNotification("좋아요", "\'"+fromUser+"\' 님께서 좋아요를 누르셨습니다.");
	}
}
