package pack.model;

import java.util.List;

import pack.controller.SajinForm;
import pack.controller.SangForm;
import pack.dto.SangDto;

public interface Service {

	List<SangDto> getSangpumlist();
	SangDto getSang(int code);
	void uploadPic(SajinForm form);
	void uploadSang(SangForm form);
}
