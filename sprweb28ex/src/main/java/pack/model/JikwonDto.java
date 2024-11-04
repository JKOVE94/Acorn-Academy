package pack.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JikwonDto {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;
	private Buser buser;
	private boolean damdangGogek;
	private List<Gogek> gogekList;
	private List<GogekDto> gogekDtoList;
	
	public static JikwonDto fromEntity(Jikwon jikwon) {
		return JikwonDto.builder()
				.jikwonno(jikwon.getJikwonno())
				.jikwonname(jikwon.getJikwonname())
				.jikwonjik(jikwon.getJikwonjik())
				.jikwonpay(jikwon.getJikwonpay())
				.damdangGogek(JikwonDto.hasDamdangGogek(jikwon))
				.buser(jikwon.getBuser())
				.gogekList(jikwon.getGogekList())
				.build();
	}
	
	// 고객이 있는지 없는지를 추출하는 boolean 값으로 추출하는 메소드
	public static boolean hasDamdangGogek(Jikwon jikwon) {
		if(jikwon.getGogekList().size()>0) return true;
		else return false;
	}
}
