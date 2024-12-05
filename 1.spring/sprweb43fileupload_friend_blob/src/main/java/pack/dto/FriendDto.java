package pack.dto;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Friend;

@Setter
@Getter
public class FriendDto {

	private int bunho;
	private String irum;
	private String junhwa;
	private String jikup;
	private String imagetype;
	private byte[] sajin;
	private String base64Image;

	public static FriendDto fromEntity(Friend friend) {
		FriendDto dto = new FriendDto();
		dto.setBunho(friend.getBunho());
		dto.setIrum(friend.getIrum());
		dto.setJunhwa(friend.getJunhwa());
		dto.setJikup(friend.getJikup());
		dto.setImagetype(friend.getImagetype());
		dto.setSajin(friend.getSajin());
		dto.setBase64Image(friend.getBase64Image());
		return dto;
	}
}
