package pack.dto;

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
public class MemberDto {

	private Long num;
	private String name;
	private String addr;
	
	//Entity를 DTO로
	public static MemberDto fromEntity(Member member) {
		return MemberDto.builder()
				.num(member.getNum())
				.name(member.getName())
				.addr(member.getAddr())
				.build();
	}
}
