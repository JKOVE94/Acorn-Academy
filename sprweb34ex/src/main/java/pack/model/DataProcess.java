package pack.model;

import java.util.List;

import pack.dto.GogekDto;
import pack.dto.JikwonDto;

public interface DataProcess {
	JikwonDto getJikwon(String gogekgogekno, String gogekname);
	List<JikwonDto> getJikwonsWithBusername(String busername);
	List<GogekDto> getGogeksWithJikwonno(String jikwonno);
}
