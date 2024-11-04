package pack.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Buser;
import pack.entity.Jikwon;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuserDto {

	private int buserno;
	private String busername, buserloc, busertel;
	private List<Jikwon> jikwonlist;
	
	public static BuserDto fromEntity(Buser buser) {
		return BuserDto.builder()
				.jikwonlist(buser.getJikwonlist())
				.buserloc(buser.getBuserloc())
				.busername(buser.getBusername())
				.buserno(buser.getBuserno())
				.busertel(buser.getBusertel())
				.build();
	}
}
