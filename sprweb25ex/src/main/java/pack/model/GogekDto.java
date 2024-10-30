package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GogekDto {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	
	public static GogekDto fromEntity(Gogek gogek) {
		GogekDto dto = new GogekDto();
		return dto.builder()
				.gogekno(gogek.getGogekno())
				.gogekname(gogek.getGogekname())
				.gogektel(gogek.getGogektel())
				.build();
	}
}
