package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Gogek;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GogekForm {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	
	public static Gogek toEntity(GogekForm form) {
		return Gogek.builder()
				.gogekno(form.getGogekno())
				.gogekname(form.getGogekname())
				.gogektel(form.getGogektel())
				.build();
	}
}
