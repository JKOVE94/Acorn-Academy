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
public class DataProcess {

	@Autowired
	private BuserRepository buserRepository;
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	public List<BuserDto> buserList(){
		List<Buser> list = buserRepository.findAll();
		return list.stream()
				.map(BuserDto :: fromEntity)
				.collect(Collectors.toList());
		
	}
	
	public List<JikwonDto> jikwonList(int buserno){
		List<Jikwon> list = jikwonRepository.buserDatas(buserno);
		return list.stream()
				.map(JikwonDto :: fromEntity)
				.collect(Collectors.toList());
	}
}
