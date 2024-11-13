package pack.model;

import java.util.List;

public interface JikwonInter {
	public List<JikwonDto> findJikwonL(String level);
	public List<JikwonDto> findJikwonD(String depart);
	
}
