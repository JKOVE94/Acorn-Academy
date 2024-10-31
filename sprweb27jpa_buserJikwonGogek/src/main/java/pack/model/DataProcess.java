package pack.model;

import java.util.List;

public interface DataProcess {

	List<JikwonDto> jikwonBuserList();
	List<JikwonDto> jikwonGogekList();
	List<GogekDto> GogekDamdangList();
	List<String> GogekDamdangListStr();
}
