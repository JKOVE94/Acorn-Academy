package pack.model;

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
	private String jikwongen;
	private Buser buser;
	
	public static JikwonDto fromEntity(Jikwon jikwon) {
		return JikwonDto.builder()
				.jikwonno(jikwon.getJikwonno())
				.jikwongen(jikwon.getJikwongen())
				.jikwonname(jikwon.getJikwonname())
				.jikwonjik(jikwon.getJikwonjik())
				.jikwonpay(jikwon.getJikwonpay())
				.buser(jikwon.getBuser())
				.build();
	}
}
