package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Buser;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuserDto {

	private int buserno;
	private String busername, buserloc, busertel;
	
	public static BuserDto fromEntity(Buser buser) {
		return BuserDto.builder()
				.buserloc(buser.getBuserloc())
				.busername(buser.getBusername())
				.buserno(buser.getBuserno())
				.busertel(buser.getBusertel())
				.build();
	}
}
