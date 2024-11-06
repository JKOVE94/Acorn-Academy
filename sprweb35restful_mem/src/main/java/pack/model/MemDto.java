package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemDto {

	private int num;
	private String name;
	private String addr;
	
	public static MemDto fromEntity(Mem mem) {
		return MemDto.builder()
				.num(mem.getNum())
				.name(mem.getName())
				.addr(mem.getAddr())
				.build();
	}
}
