package pack.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Buser;
import pack.entity.Jikwon;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuserDto {

	private int buserno;
	private String busername;
	private String busertel;
	private List<Jikwon> jikwonList;	
	
	public static BuserDto fromEntity(Buser dept) {
		return BuserDto.builder()
				.buserno(dept.getBuserno())
				.busername(dept.getBusername())
				.busertel(dept.getBusertel())
				.jikwonList(dept.getJikwonList())
				.build();
	}
}
