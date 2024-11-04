package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.BuserDto;
import pack.dto.JikwonDto;
import pack.entity.Buser;
import pack.entity.Jikwon;
import pack.repository.BuserRepository;
import pack.repository.JikwonRepository;

@Repository
public class DataProcessImpl implements DataProcess{

	@Autowired
	private BuserRepository buserRepository;
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Override
	public List<String> getAllJik(){
		return jikwonRepository.getJik();
	}
	
	@Override
	public List<JikwonDto> getJikwonList(String jikwonjik, String jikwonrating){
		List<Jikwon> list;
		if(jikwonrating.equals("")) {
			list = jikwonRepository.getJikwon2(jikwonjik);
		}
		else {
			list = jikwonRepository.getJikwon1(jikwonjik, jikwonrating);
		}
		return list.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<String> getAllBuserName(){
		return buserRepository.getBuser();
	}
	
	@Override
	public List<JikwonDto> getJikwonListWithBuser(String busername, String jikwonrating){
		List<Jikwon> list;
		if(jikwonrating.equals("")) {
			list = jikwonRepository.getJikwonWithB2(busername);
		}
		else {
			list = jikwonRepository.getJikwonWithB1(busername, jikwonrating);
		}
		return list.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
	
}
