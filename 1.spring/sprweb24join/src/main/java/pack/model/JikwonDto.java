package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class JikwonDto {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;
	private String jikwonibsail;
	private String jikwongen;
	private String jikwonrating;
	private BuserDto buserDto;
	
	// Dto --> Entity
		public Jikwon toEntity() {
			Jikwon jikwon = new Jikwon();
			jikwon.setJikwonno(this.jikwonno);
			jikwon.setJikwonname(this.jikwonname);
			jikwon.setJikwonjik(this.jikwonjik);
			jikwon.setJikwonpay(this.jikwonpay);
			jikwon.setJikwonibsail(this.jikwonibsail);
			jikwon.setJikwongen(this.jikwongen);
			jikwon.setJikwonrating(this.jikwonrating);
			if(this.buserDto!=null) {				
				jikwon.setBuser(this.buserDto.toEntity());
			}
			return jikwon;
		}

		// Entity --> Dto
		public static JikwonDto fromEntity(Jikwon jikwon) {
			JikwonDto dto = new JikwonDto();
			dto.setJikwonno(jikwon.getJikwonno());
			dto.setJikwonname(jikwon.getJikwonname());
			dto.setJikwonjik(jikwon.getJikwonjik());
			dto.setJikwonpay(jikwon.getJikwonpay());
			dto.setJikwonibsail(jikwon.getJikwonibsail());
			dto.setJikwongen(jikwon.getJikwongen());
			dto.setJikwonrating(jikwon.getJikwonrating());
			if(jikwon.getBuser()!=null) {				
				dto.setBuserDto(BuserDto.fromEntity(jikwon.getBuser()));
			}
			return dto;
		}
	
}
