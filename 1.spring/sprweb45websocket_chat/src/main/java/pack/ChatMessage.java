package pack;

import lombok.Data;

//메세지 객체를 정의. 메세지 타입(입장, 채팅, 퇴장), 발신자, 내용 등의 구조를 정의
@Data
public class ChatMessage {
	private String sender; //발신자
	private String content; // 메세지 내용
	private MessageType type; //메세지 타입(입장, 채팅, 퇴장)
	
	public enum MessageType{JOIN, CHAT, LEAVE}
}
