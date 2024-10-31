package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GogekDto {
	private int gogekno;
	private String gogekname;
	private String gogektel;
	private Jikwon jikwon;
	
	public static GogekDto fromEntity(Gogek gogek) {
		return GogekDto.builder()
				.gogekno(gogek.getGogekno())
				.gogekname(gogek.getGogekname())
				.gogektel(gogek.getGogektel())
				.jikwon(gogek.getJikwon())
				.build();
	}
}
