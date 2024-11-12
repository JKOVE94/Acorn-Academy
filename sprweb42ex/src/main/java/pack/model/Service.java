package pack.model;

import java.util.List;

import pack.controller.SajinForm;
import pack.controller.SangForm;
import pack.dto.SangDto;
import pack.entity.Sangdata;

public interface Service {

	List<SangDto> getSangpumlist();
	SangDto getSang(int code);
	Sangdata uploadSang(SangForm form);
	public void uploadPic(SangForm sangform, SajinForm form);
}
