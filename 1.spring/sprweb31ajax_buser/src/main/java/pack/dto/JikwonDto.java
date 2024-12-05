package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Jikwon;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JikwonDto {

	private int jikwonno;
	private String jikwonname, jikwonjik, jikwonibsail, jikwongen, jikwonrating;
	private int jikwonpay;
	private String buser;
	
	public static JikwonDto fromEntity(Jikwon jikwon) {
		return JikwonDto.builder()
				.buser(jikwon.getBuser())
				.jikwongen(jikwon.getJikwongen())
				.jikwonibsail(jikwon.getJikwonibsail())
				.jikwonjik(jikwon.getJikwonjik())
				.jikwonname(jikwon.getJikwonname())
				.jikwonno(jikwon.getJikwonno())
				.jikwonpay(jikwon.getJikwonpay())
				.jikwonrating(jikwon.getJikwonrating())
				.build();
		
	}
}
