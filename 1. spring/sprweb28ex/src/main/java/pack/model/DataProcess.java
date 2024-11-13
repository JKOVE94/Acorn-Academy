package pack.model;

import java.util.List;

public interface DataProcess {

	List<JikwonDto> jikwonBuserList(); 
	JikwonDto jikwonGogekList(int jikwonno); //해당 직원의 담당 고객
}
