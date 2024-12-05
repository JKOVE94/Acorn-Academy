package pack.controller;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Sang;

@Getter
@Setter
public class SangForm {

	private int code;
	private String sang;
	private int su;
	private long dan;
	
	public static Sang toEntity(SangForm form) {
		return Sang.builder()
				.code(form.getCode())
				.sang(form.getSang())
				.su(form.getSu())
				.dan(form.getDan())
				.build();		
	}
}
