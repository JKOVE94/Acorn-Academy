package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.model.Mem;
import pack.model.MemDto;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemBean {

	private int num;
	private String name;
	private String addr;
	
	public static Mem toEntity(MemBean bean) {
		return Mem.builder()
				.num(bean.getNum())
				.name(bean.getName())
				.addr(bean.getAddr())
				.build();
	}
}
