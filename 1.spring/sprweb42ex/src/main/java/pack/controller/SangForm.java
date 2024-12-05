package pack.controller;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Sangdata;

@Getter
@Setter
public class SangForm {

	private int code;
	private String sang;
	private int su;
	private int dan;
	
	public static Sangdata toEntity(SangForm form) {
		Sangdata data = new Sangdata();
		data.setCode(form.getCode());
		data.setDan(form.getDan());
		data.setSu(form.getSu());
		data.setSang(form.getSang());
		return data;
	}
}
