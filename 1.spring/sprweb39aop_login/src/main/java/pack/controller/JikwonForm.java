package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Jikwon;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JikwonForm {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;
	
	public static Jikwon fromEntity(JikwonForm form) {
		return Jikwon.builder()
				.jikwonno(form.getJikwonno())
				.jikwonname(form.getJikwonname())
				.jikwonjik(form.getJikwonjik())
				.jikwonpay(form.getJikwonpay())
				.build();
	}
}
