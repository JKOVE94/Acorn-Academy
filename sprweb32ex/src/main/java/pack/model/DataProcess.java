package pack.model;

import java.util.List;

import pack.dto.BuserDto;
import pack.dto.JikwonDto;

public interface DataProcess {
	List<String> getAllBuserName();
	List<JikwonDto> getJikwonListWithBuser(String busername, String jikwonrating);
	
	
	List<String> getAllJik();
	List<JikwonDto> getJikwonList(String jikwonjik, String jikwonrating);

}
