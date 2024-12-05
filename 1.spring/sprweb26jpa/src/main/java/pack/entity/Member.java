package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.dto.MemberDto;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="MEMBER_TBL")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num;
	private String name;
	private String addr;
	
	//DTO를 Entity로
	public static Member toEntity(MemberDto dto) {
		return Member.builder()
				.addr(dto.getAddr())
				.name(dto.getName())
				.num(dto.getNum())
				.build();	
	}
}
