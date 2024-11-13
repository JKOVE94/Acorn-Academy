package pack;

public class MyNotification {
	private String type;
	private String message;
	
	public MyNotification(String type, String message) {
		this.type=type;
		this.message=message;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
