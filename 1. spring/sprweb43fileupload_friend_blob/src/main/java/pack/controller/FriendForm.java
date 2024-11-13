package pack.controller;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Friend;

@Setter
@Getter
public class FriendForm {

	private int bunho;
	private String irum;
	private String junhwa;
	private String jikup;
	private String imagetype;
	private byte[] sajin;
	private String base64Image;

	public static Friend toEntity(FriendForm form) {
		Friend friend = new Friend();
		friend.setBunho(form.getBunho());
		friend.setIrum(form.getIrum());
		friend.setJunhwa(form.getJunhwa());
		friend.setJikup(form.getJikup());
		friend.setImagetype(form.getImagetype());
		friend.setSajin(form.getSajin());
		friend.setBase64Image(form.getBase64Image());
		return friend;
	}
}
