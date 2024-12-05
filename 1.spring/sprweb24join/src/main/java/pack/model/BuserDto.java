package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class BuserDto {

	private int buserno;
	private String busername;
	private String buserloc;
	private String busertel;

	// Dto --> Entity
	public Buser toEntity() {
		Buser buser = new Buser();
		return buser.builder()
				.buserno(this.getBuserno())
				.busername(this.getBusername())
				.busertel(this.getBusertel())
				.buserloc(this.getBuserloc()).build();
	}

	// Entity --> Dto
	public static BuserDto fromEntity(Buser buser) {
		BuserDto dto = new BuserDto();
		return dto.builder()
				.buserno(buser.getBuserno())
				.busername(buser.getBusername())
				.busertel(buser.getBusertel())
				.buserloc(buser.getBuserloc()).build();
	}
}
