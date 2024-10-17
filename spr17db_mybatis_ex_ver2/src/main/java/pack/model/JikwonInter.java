package pack.model;

import java.util.List;
import java.util.Map;

public interface JikwonInter {
	Map<Integer,String> getBuserInfo();
	List<JikwonDto> SelectJikwon();
	List<InwonDto> FindInwon();
}
