package pack.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Buser;
import pack.entity.Gogek;
import pack.entity.Jikwon;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JikwonDto {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;
	private List<Gogek> gogekList;
	private String busername;
	private String busertel;
	
	public static JikwonDto fromEntity(Jikwon jikwon) {
		return JikwonDto.builder()
				.busername(jikwon.getBuser().getBusername())
				.busertel(jikwon.getBuser().getBusertel())
				.jikwonno(jikwon.getJikwonno())
				.jikwonname(jikwon.getJikwonname())
				.jikwonjik(jikwon.getJikwonjik())
				.jikwonpay(jikwon.getJikwonpay())
				.gogekList(jikwon.getGogekList())
				.build();
	}	
}

