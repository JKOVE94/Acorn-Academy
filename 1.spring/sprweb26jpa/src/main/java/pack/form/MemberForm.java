package pack.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Member;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberForm {

	private Long num;
	private String name;
	private String addr;
	
	//Form을 Entity로
	public static Member toEntity(MemberForm form) {
		return Member.builder()
				.num(form.getNum())
				.name(form.getName())
				.addr(form.getAddr())
				.build();
	}
}
