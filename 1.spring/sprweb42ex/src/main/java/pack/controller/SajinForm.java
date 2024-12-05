package pack.controller;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import pack.entity.Sajindata;
import pack.entity.Sangdata;

@Getter
@Setter
public class SajinForm {

	private String about;
	private String filepath;	
	private LocalDate uploadat;
	private Sangdata sangdata;

	SajinForm(){
		this.uploadat = LocalDate.now();
	}
	
	public static Sajindata toEntity(SajinForm form) {
		Sajindata data = new Sajindata();
		data.setAbout(form.getAbout());
		data.setFilepath(form.getFilepath());
		data.setSangdata(form.getSangdata());
		data.setSangdata(null);
		return data;
	}
}
