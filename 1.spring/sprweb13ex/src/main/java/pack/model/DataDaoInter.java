package pack.model;

import java.util.List;

public interface DataDaoInter {

	List<JikwonDto> getAllJik();
	List<JikwonDto> getSearchJik(String jikwonname);
}
