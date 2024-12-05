package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Buser;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuserForm {

	private int buserno;
	private String busername;
	private String busertel;
	
	public static Buser toEntity(BuserForm form) {
		return Buser.builder()
				.buserno(form.getBuserno())
				.busername(form.getBusername())
				.busertel(form.getBusertel())
				.build();
	}
}
