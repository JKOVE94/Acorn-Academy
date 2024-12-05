package pack.dto;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Jikwon;

@Getter
@Setter
public class JikwonDto {

	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private int jikwonpay;		
	private String busername;
	
	public static JikwonDto fromEntity(Jikwon jikwon) {
		JikwonDto dto = new JikwonDto();
		dto.setBusername(jikwon.getBuser().getBusername());
		dto.setJikwonjik(jikwon.getJikwonjik());
		dto.setJikwonname(jikwon.getJikwonname());
		dto.setJikwonno(jikwon.getJikwonno());
		dto.setJikwonpay(jikwon.getJikwonpay());
		return dto;
	}
}
