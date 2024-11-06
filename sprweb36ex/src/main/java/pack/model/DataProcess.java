package pack.model;

import java.util.List;

import pack.controller.SangForm;

public interface DataProcess {

	List<SangDto> getAllSang();
	SangDto getSang(int code);
	int getMax();
	void insert(SangForm form);
	void update(SangForm form);
	void delete(int code);
}
