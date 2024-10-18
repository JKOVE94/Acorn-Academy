package pack.business;

import java.util.HashMap;
import java.util.List;

import org.springframework.util.MultiValueMap;

public interface BusinessInter {
	MultiValueMap<Integer, Integer> getJikwonMultiValueMap();
	HashMap<Integer, Integer> getJikwonTopSalMap();
	List<Integer> getBuserNumList();
	
	void printJikwonData();
	void printBuserInwon();
	void printBuserTopsal();
}
