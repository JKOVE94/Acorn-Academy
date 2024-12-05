package pack.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Sangdata;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SangdataForm {

	private int code;
	private String sang;
	private int su;
	private long dan;
	
	public static Sangdata toEntity(SangdataForm form) {
		return Sangdata.builder()
				.code(form.getCode())
				.dan(form.getDan())
				.sang(form.getSang())
				.su(form.getSu())
				.build();
	}
}
