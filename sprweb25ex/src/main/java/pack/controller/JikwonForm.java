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
	
	public Jikwon toEntity() {
		Jikwon jikwon = new Jikwon();
		return jikwon.builder()
				.jikwonno(this.jikwonno)
				.jikwonname(this.jikwonname)
				.jikwonjik(this.jikwonjik)
				.build();
	}
}
