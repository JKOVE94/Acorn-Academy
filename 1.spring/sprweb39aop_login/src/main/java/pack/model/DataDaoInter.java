package pack.model;

import java.util.List;

public interface DataDaoInter {

	List<JikwonDto> getAllJik();
	JikwonDto jikwonLogin(String jikwonno);
}
