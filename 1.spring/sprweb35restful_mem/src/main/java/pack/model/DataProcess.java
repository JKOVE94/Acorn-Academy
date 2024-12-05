package pack.model;

import java.util.List;

import pack.controller.MemBean;

public interface DataProcess {

	List<MemDto> getDataAll();
	MemDto getMemberByNum(int num);
	String insertData(MemBean bean);
	String updateData(MemBean bean);
	String deleteData(Integer num);
}
