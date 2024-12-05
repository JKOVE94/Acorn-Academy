package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Alias("memberDto")
@Setter
@Getter
public class MemberDto {
	private int num;
	private String name;
	private String addr;
}
